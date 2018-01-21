package mk.ukim.finki.soaticketssearch.controllers;

import mk.ukim.finki.soaticketssearch.business.services.ISearchService;
import mk.ukim.finki.soaticketssearch.business.view.models.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {
    @Autowired
    private ISearchService searchService;

    @RequestMapping(method = RequestMethod.GET, value = "/users/{searchTerm}")
    public List<UserViewModel> searchUsers(@PathVariable("searchTerm") String searchTerm){
        return searchService.searchUsers(searchTerm);
    }
}
