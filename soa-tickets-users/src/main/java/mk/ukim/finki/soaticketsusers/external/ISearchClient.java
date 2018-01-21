package mk.ukim.finki.soaticketsusers.external;

import mk.ukim.finki.soaticketsusers.business.view.models.user.UserViewModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("soa-tickets-search")
public interface ISearchClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/{searchTerm}")
    List<UserViewModel> searchUsers(@PathVariable("searchTerm") String searchTerm);
}