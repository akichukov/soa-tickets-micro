package mk.ukim.finki.soaticketssearch;

import mk.ukim.finki.soaticketssearch.business.services.implementation.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class SoaTicketsSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTicketsSearchApplication.class, args);
	}

//    @Autowired
//    private EntityManager entityManager;
//
//    @Bean
//    ISearchService eventsSearchService(){
//        SearchService searchService = new SearchService(entityManager);
//        searchService.initialize();
//        return searchService;
//    }
}
