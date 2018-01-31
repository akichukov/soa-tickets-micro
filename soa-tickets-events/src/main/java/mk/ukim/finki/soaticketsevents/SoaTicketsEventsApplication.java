package mk.ukim.finki.soaticketsevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SoaTicketsEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsEventsApplication.class, args);
	}
}
