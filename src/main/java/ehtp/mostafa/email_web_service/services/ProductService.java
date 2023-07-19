package ehtp.mostafa.email_web_service.services;

import ehtp.mostafa.email_web_service.entities.Message;
import ehtp.mostafa.email_web_service.producer.TopicProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    private TopicProducer producer;

    @Autowired
    public ProductService(TopicProducer prod) {
        this.producer = prod;
    }

    public void sendMessageToSMSTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("sms", message  );
    }
    public void sendMessageToMailTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("mail", message  );
    }
    public void sendMessageToWebHookTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("webhook", message  );
    }

}
