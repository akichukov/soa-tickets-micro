package mk.ukim.finki.soaticketsevents.repositories;

import mk.ukim.finki.soaticketsevents.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IEventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByName(String name);
    List<Event> findAllByLocation(String location);
    List<Event> findAllByDate(Date date);
}