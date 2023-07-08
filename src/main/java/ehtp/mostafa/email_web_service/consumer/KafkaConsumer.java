package ehtp.mostafa.email_web_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "newTopic" , groupId ="cunsuming" )
    public void listenGroup(String message){
        System.out.println("Received Message in group consuming :" + message);
    }
}
