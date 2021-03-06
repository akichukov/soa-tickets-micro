package mk.ukim.finki.soaticketsevents.controllers;

import mk.ukim.finki.soaticketsevents.business.services.IEventService;
import mk.ukim.finki.soaticketsevents.business.views.CreateEventViewModel;

import mk.ukim.finki.soaticketsevents.business.views.EventViewModel;
import mk.ukim.finki.soaticketsevents.business.views.UpdateEventViewModel;
import mk.ukim.finki.soaticketsevents.core.helpers.ErrorMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    @Autowired
    private IEventService eventService;

    @Autowired
    private ISearchService searchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<EventViewModel> getAllEvents() {
        return eventService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EventViewModel getEvent(@PathVariable Long id) throws Exception {
        return eventService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object create(@Valid CreateEventViewModel event, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());
        return eventService.create(event);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@Valid UpdateEventViewModel event, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());
        return eventService.update(event);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Long delete(@PathVariable Long id) throws Exception {
        return eventService.delete(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<EventViewModel> getByName(@PathVariable String name) throws Exception {
        return eventService.findAllByName(name);
    }

    @RequestMapping(value = "/location/{location}", method = RequestMethod.GET)
    public List<EventViewModel> getByLocation(@PathVariable String location) throws Exception {
        return eventService.findAllByLocation(location);
    }

    @RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
    public List<EventViewModel> byName(@PathVariable String date) throws Exception {
        return eventService.findAllByDate(date);
    }

    @RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
    public List<EventViewModel> search(@PathVariable String term) throws Exception {
        return searchService.searchEvents(term);
    }
}