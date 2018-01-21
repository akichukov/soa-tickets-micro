package mk.ukim.finki.soaticketsblog.controllers;

import mk.ukim.finki.soaticketsblog.external.IUsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class BlogController {
    @Autowired
    private IUsersClient IUsersClient;

    @RequestMapping("/")
    public String index(){
        return "Hello! :)" + IUsersClient.getName("Meshkovski");
    }
}