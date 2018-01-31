package mk.ukim.finki.soaticketstickets.repository;
import mk.ukim.finki.soaticketstickets.models.BoughtTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBoughtTicketRepository extends CrudRepository<BoughtTicket, Long> {
    List<BoughtTicket> findByEvent(long eventId);
}