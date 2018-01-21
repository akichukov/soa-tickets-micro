package mk.ukim.finki.soaticketsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class SoaTicketsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsGatewayApplication.class, args);
	}

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}