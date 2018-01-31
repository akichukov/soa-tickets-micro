package mk.ukim.finki.soaticketstickets.business.services;


import mk.ukim.finki.soaticketstickets.business.view.BoughtTicketViewModel;

import java.util.List;

public interface IBoughtTicketService {
    public List<BoughtTicketViewModel> getAllForUser(long userId) throws Exception;
    public List<BoughtTicketViewModel> getAllForEvent(long eventId) throws Exception;
}
