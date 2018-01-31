package mk.ukim.finki.soaticketstickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SoaTicketsTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsTicketsApplication.class, args);
	}
}
