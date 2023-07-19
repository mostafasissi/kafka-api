package ehtp.mostafa.email_web_service;

import ehtp.mostafa.email_web_service.entities.Message;
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

	@Bean
	CommandLineRunner start(ProductService productService){
		return args -> {
			for (int i=0 ; i<3 ; i++){
				Message message = new Message("from" , "to" , "Hello from kafka"  );
				productService.sendMessageToMailTopic(message);
				productService.sendMessageToWebHookTopic(message);
				productService.sendMessageToSMSTopic(message);
				Thread.sleep(100);
			}

		};
	}

}
