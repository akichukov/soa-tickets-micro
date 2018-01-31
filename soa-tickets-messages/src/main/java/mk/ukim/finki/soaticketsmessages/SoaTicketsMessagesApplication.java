package mk.ukim.finki.soaticketsmessages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SoaTicketsMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsMessagesApplication.class, args);
	}
}
