package mk.ukim.finki.soaticketstickets.repository;

import mk.ukim.finki.soaticketstickets.models.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    public List<Ticket> findAllByEventId(long eventId);
    //public void createTicketForEvent(Ticket ticket);
    //public void deleteTicketsForEvent(long eventId);
    //public void updatePriceForEvent(long eventId, int price);
}
