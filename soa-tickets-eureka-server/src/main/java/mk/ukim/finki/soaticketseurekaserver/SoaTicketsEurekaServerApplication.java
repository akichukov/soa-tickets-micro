package mk.ukim.finki.soaticketseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SoaTicketsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsEurekaServerApplication.class, args);
	}
}
