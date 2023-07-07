package ehtp.mostafa.email_web_service.services;

import ehtp.mostafa.email_web_service.entities.ProducerMessage;
import ehtp.mostafa.email_web_service.producer.Topic1Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    private Topic1Producer topic1Producer;

    @Autowired
    public ProductService(Topic1Producer topic1Producer) {
        this.topic1Producer = topic1Producer;
    }

    public void sendMessage(String  message) {
        log.info("[ProductService] send product to topic");
        topic1Producer.send(message);
    }

}
