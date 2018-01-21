package mk.ukim.finki.soaticketsusers.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @RequestMapping("/{surname}")
    public String getName(@PathVariable String surname){
        return "Darko" + surname;
    }
}