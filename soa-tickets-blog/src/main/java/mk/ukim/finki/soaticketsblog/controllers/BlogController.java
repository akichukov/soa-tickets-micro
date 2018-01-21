package mk.ukim.finki.soaticketsblog.controllers;

import mk.ukim.finki.soaticketsblog.external.UsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/")
@RestController
public class BlogController {
    @Autowired
    private UsersClient usersClient;

    @RequestMapping("/")
    public String index(){
        return "Hello! :)" + usersClient.getName("Meshkovski");
    }
}