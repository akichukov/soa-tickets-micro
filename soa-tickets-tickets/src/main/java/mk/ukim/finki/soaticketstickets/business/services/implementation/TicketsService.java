package mk.ukim.finki.soaticketstickets.business.services.implementation;

import mk.ukim.finki.soaticketstickets.business.services.ITicketsService;
import mk.ukim.finki.soaticketstickets.business.view.PurchaseTicketViewModel;
import mk.ukim.finki.soaticketstickets.business.view.TicketViewModel;
import mk.ukim.finki.soaticketstickets.models.BoughtTicket;
import mk.ukim.finki.soaticketstickets.models.Invoice;
import mk.ukim.finki.soaticketstickets.models.Ticket;
import mk.ukim.finki.soaticketstickets.repository.IBoughtTicketRepository;
import mk.ukim.finki.soaticketstickets.repository.IInvoiceRepository;
import mk.ukim.finki.soaticketstickets.repository.ITicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketsService implements ITicketsService {
    @Value("${invoice.taxPercentage}")
    private int taxPercentage;

    @Autowired
    private IEventRepository eventRepository;

    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private IInvoiceRepository invoiceRepository;

    @Autowired
    private IBoughtTicketRepository boughtTicketRepository;

    @Autowired
    private IUserRepository userRepository;

    private ModelMapper modelMapper;

    public TicketsService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<TicketViewModel> getAllForEvent(long eventId) throws Exception {
        Event event = eventRepository.findOne(eventId);
        if (event == null) {
            throw new Exception("Event not found");
        }
        List<TicketViewModel> result = new ArrayList<>();
        for (Ticket ticket : event.getTickets()) {
            TicketViewModel ticketViewModel = modelMapper.map(ticket, TicketViewModel.class);
            float rawTicketPrice = ticket.getPrice();
            float ticketPriceWithTaxIncluded = (rawTicketPrice * taxPercentage / 100) + rawTicketPrice;
            ticketViewModel.setPrice(ticketPriceWithTaxIncluded);
            result.add(ticketViewModel);
        }

        return result;
    }

    @Override
    public long deleteTicket(long eventId, long ticketId) throws Exception {
        if(eventId < 0 || ticketId < 0) {
            throw new Exception("Invalid event or ticket id");
        }

        Ticket ticket = ticketRepository.findOne(ticketId);
        ticketRepository.delete(ticket);
        return ticket.getId();
    }

    @Override
    public long createTicketForEvent(long eventId, int price) throws Exception {
        Event event = eventRepository.findOne(eventId);
        if(event == null) {
            throw new Exception("Event not found");
        }
        Ticket ticket = new Ticket(event, price);
        ticketRepository.save(ticket);
        return ticket.getId();
    }

    @Override
    public long removeTicketsForEvent(long eventId) throws Exception {
        if(eventId < 0) {
            throw new Exception("Invalid event id");
        }

        Event event = eventRepository.findOne(eventId);

        for(Ticket ticket : event.getTickets()) {
            ticketRepository.delete(ticket);
        }

        return eventId;
    }



    @Override
    public long updatePriceForEvent(long eventId, int price) throws Exception {
        if(eventId < 0) {
            throw new Exception("Invalid event id");
        }
        Event event = eventRepository.findOne(eventId);
        if(event == null) {
            throw new Exception("Event not found");
        }

        for(Ticket ticket : event.getTickets()) {
            ticket.setPrice(price);
            ticketRepository.save(ticket);
        }
        return eventId;
    }

    @Override
    public long purchaseTicket(PurchaseTicketViewModel model) throws Exception {
        User user = userRepository.findOne(model.getUserId());
        if (user == null)
            throw new Exception("User not found!");

        Ticket ticket = ticketRepository.findOne(model.getTicketId());
        if (ticket == null)
            throw new Exception("Ticket not found!");

        float rawTicketPrice = ticket.getPrice();
        float ticketPriceWithTaxIncluded = (rawTicketPrice * taxPercentage / 100) + rawTicketPrice;
        if (ticketPriceWithTaxIncluded != model.getAmountPayed())
            throw new Exception("Ooops..looks like something went wrong.  Please try purchasing the ticket again or contact our support.");

        Invoice invoice = new Invoice(user, ticket, ticketPriceWithTaxIncluded, model.getPaymentMethod());
        invoiceRepository.save(invoice);

        BoughtTicket boughtTicket = new BoughtTicket(user, ticket);
        boughtTicketRepository.save(boughtTicket);

        return invoice.getId();
    }
}