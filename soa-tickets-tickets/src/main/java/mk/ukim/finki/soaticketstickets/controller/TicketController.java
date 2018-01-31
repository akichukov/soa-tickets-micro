package mk.ukim.finki.soaticketstickets.controller;

import mk.ukim.finki.soaticketstickets.business.services.implementation.TicketsService;
import mk.ukim.finki.soaticketstickets.business.view.PurchaseTicketViewModel;
import mk.ukim.finki.soaticketstickets.business.view.TicketViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {
    @Autowired
    private IUsersService usersService;

    @Autowired
    private TicketsService ticketsService;

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public List<TicketViewModel> getTicketsForEvent(@PathVariable long id) throws Exception {
        return ticketsService.getAllForEvent(id);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)

    public Object purchaseTicket(Principal principal, PurchaseTicketViewModel purchaseTicketViewModel, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        UserViewModel currentUser;
        if (purchaseTicketViewModel.getUserId() == 0)
        {
            currentUser = usersService.findByEmail(principal.getName());
            purchaseTicketViewModel.setUserId(currentUser.getId());
        }

        return ticketsService.purchaseTicket(purchaseTicketViewModel);
    }
}