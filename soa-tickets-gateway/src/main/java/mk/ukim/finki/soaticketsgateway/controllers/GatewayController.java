package mk.ukim.finki.soaticketsgateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class GatewayController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/api/{name}")
    public Object api(@PathVariable(value="name") String name) {
        Random rnd = new Random();

        List<ServiceInstance> instances = this.discoveryClient.getInstances("soa-tickets-api");
        EurekaDiscoveryClient.EurekaServiceInstance serviceInstance = (EurekaDiscoveryClient.EurekaServiceInstance) instances.get(rnd.nextInt(instances.size()));

        String ipAddress = serviceInstance.getInstanceInfo().getIPAddr();
        String asd = serviceInstance.getUri().toString();
        return this.restTemplate.getForObject("http://" + ipAddress + ":8079/" + name + "/", String.class);
    }
}