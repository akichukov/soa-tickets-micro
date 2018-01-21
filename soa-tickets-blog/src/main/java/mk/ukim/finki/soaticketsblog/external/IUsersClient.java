package mk.ukim.finki.soaticketsblog.external;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("soa-tickets-users")
public interface IUsersClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/{surname}")
    String getName(@PathVariable("surname") String surname);
}
