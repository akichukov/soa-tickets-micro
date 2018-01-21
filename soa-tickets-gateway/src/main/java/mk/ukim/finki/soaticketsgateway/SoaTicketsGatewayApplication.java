package mk.ukim.finki.soaticketsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringBootApplication
@RestController
public class SoaTicketsGatewayApplication {

	public static void main(String[] args) {
        new SpringApplicationBuilder(SoaTicketsGatewayApplication.class).web(true).run(args);
	}
}