package ehtp.mostafa.email_web_service;

import ehtp.mostafa.email_web_service.entities.ProducerMessage;
import ehtp.mostafa.email_web_service.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailWebServiceApplication.class, args);
	}

/*	@Bean
	CommandLineRunner start(ProductService productService){
		return args -> {
			int i = 0 ;
			while (true){
				productService.sendMessage("message " + i );
				i++ ;
				Thread.sleep(1000);
			}

		};
	}*/

}
