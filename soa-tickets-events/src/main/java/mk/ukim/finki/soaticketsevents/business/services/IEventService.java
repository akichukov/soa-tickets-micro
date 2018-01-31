package mk.ukim.finki.soaticketsevents.business.services;


import mk.ukim.finki.soaticketsevents.business.views.CreateEventViewModel;
import mk.ukim.finki.soaticketsevents.business.views.EventViewModel;
import mk.ukim.finki.soaticketsevents.business.views.UpdateEventViewModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IEventService {
    List<EventViewModel> getAll();
    EventViewModel getById(Long eventId) throws Exception;
    Long create(CreateEventViewModel event) throws Exception;
    Long update(UpdateEventViewModel event) throws Exception;
    Long delete(Long eventId) throws Exception;
    List<EventViewModel> findAllByName(String name) throws Exception;
    List<EventViewModel> findAllByDate(String date) throws Exception;
    List<EventViewModel> findAllByLocation(String location) throws Exception;
}
