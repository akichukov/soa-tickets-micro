package mk.ukim.finki.soaticketstickets.business.services;


import mk.ukim.finki.soaticketstickets.business.view.PurchaseTicketViewModel;
import mk.ukim.finki.soaticketstickets.business.view.TicketViewModel;

import java.util.List;

public interface ITicketsService {
    public List<TicketViewModel> getAllForEvent(long eventId) throws Exception;
    long deleteTicket(long eventId, long ticketId) throws Exception;
    long createTicketForEvent(long eventId, int price) throws Exception;
    long removeTicketsForEvent(long eventId) throws Exception;
    long updatePriceForEvent(long eventId, int price) throws Exception;
    long purchaseTicket(PurchaseTicketViewModel model) throws Exception;
}