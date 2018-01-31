package mk.ukim.finki.soaticketstickets.business.services.implementation;

import mk.ukim.finki.soaticketstickets.business.services.IBoughtTicketService;
import mk.ukim.finki.soaticketstickets.business.view.BoughtTicketViewModel;
import mk.ukim.finki.soaticketstickets.models.BoughtTicket;
import mk.ukim.finki.soaticketstickets.repository.IBoughtTicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoughtTicketService implements IBoughtTicketService {

    private ModelMapper mapper;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IEventRepository eventRepository;

    @Autowired
    private IBoughtTicketRepository boughtTicketRepository;

    public BoughtTicketService() {
        mapper = new ModelMapper();
    }

    @Override
    public List<BoughtTicketViewModel> getAllForUser(long userId) throws Exception {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new Exception("User not found");
        }
        List<BoughtTicketViewModel> result = new ArrayList<>();
        for (BoughtTicket boughtTicket : user.getBoughtTickets()) {
            BoughtTicketViewModel boughtTicketViewModel = mapper.map(boughtTicket, BoughtTicketViewModel.class);
            boughtTicketViewModel.setOwner(mapper.map(boughtTicket.getUser(), UserViewModel.class));
            boughtTicketViewModel.setEvent(mapper.map(boughtTicket.getTicket().getEvent(), EventViewModel.class));
            result.add(boughtTicketViewModel);
        }
        return result;
    }

    @Override
    public List<BoughtTicketViewModel> getAllForEvent(long eventId) throws Exception {
        List<BoughtTicketViewModel> result = new ArrayList<>();

        Event event = eventRepository.findOne(eventId);
        if (event == null)
            throw new Exception("Event not found!");

        List<BoughtTicket> boughtTickets = event.getBoughtTickets();
        for (BoughtTicket boughtTicket : boughtTickets) {
            BoughtTicketViewModel boughtTicketViewModel = mapper.map(boughtTicket, BoughtTicketViewModel.class);
            boughtTicketViewModel.setOwner(mapper.map(boughtTicket.getUser(), UserViewModel.class));
            boughtTicketViewModel.setEvent(mapper.map(boughtTicket.getTicket().getEvent(), EventViewModel.class));
            result.add(boughtTicketViewModel);
        }

        return result;
    }
}