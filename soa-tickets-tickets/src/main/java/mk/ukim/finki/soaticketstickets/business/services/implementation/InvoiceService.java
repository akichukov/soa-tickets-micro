package mk.ukim.finki.soaticketstickets.business.services.implementation;
import mk.ukim.finki.soaticketstickets.business.services.IInvoiceService;
import mk.ukim.finki.soaticketstickets.business.view.InvoiceViewModel;
import mk.ukim.finki.soaticketstickets.models.Invoice;
import mk.ukim.finki.soaticketstickets.models.PaymentMethod;
import mk.ukim.finki.soaticketstickets.models.Ticket;
import mk.ukim.finki.soaticketstickets.repository.IInvoiceRepository;
import mk.ukim.finki.soaticketstickets.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DarkoM on 03.12.2017.
 */

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<InvoiceViewModel> getAllForUser(long userId) throws Exception {
        User user = userRepository.findOne(userId);
        if (user == null)
            throw new Exception("User not found!!");

        List<InvoiceViewModel> mappedInvoices = new ArrayList<>();
        List<Invoice> userInvoices = user.getInvoices();
        mappedInvoices.addAll(userInvoices.stream().map(invoice -> new InvoiceViewModel(user, invoice.getTicket(), invoice.getAmountPayed(), invoice.getPaymentMethod())).collect(Collectors.toList()));

        return mappedInvoices;
    }

    @Override
    public long createInvoice(long userId, long eventId, float amountPayed, PaymentMethod paymentMethod) throws Exception {
        User user = userRepository.findOne(userId);
        if (user == null)
            throw new Exception("User not found!!");

        Ticket ticket = ticketRepository.findOne(eventId);
        if (ticket == null)
            throw new Exception("Ticket not found!!");

        Invoice invoice = new Invoice(user, ticket, amountPayed, paymentMethod);
        invoiceRepository.save(invoice);

        return invoice.getId();
    }
}
