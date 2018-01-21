package mk.ukim.finki.soaticketszuul;

import mk.ukim.finki.soaticketszuul.filters.ErrorFilter;
import mk.ukim.finki.soaticketszuul.filters.PostFilter;
import mk.ukim.finki.soaticketszuul.filters.PreFilter;
import mk.ukim.finki.soaticketszuul.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class SoaTicketsZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsZuulApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
