package ehtp.mostafa.email_web_service.consumer;

import ehtp.mostafa.email_web_service.entities.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "sms" , groupId ="cunsuming" )
    public void smsListener(Message message){
        System.out.println("Received Message in group consuming <sms topic> :" + message);
    }

    @KafkaListener(topics = "mail" , groupId ="cunsuming" )
    public void mailListener(Message message){
        System.out.println("Received Message in group consuming <mail topic> :" + message);
    }

    @KafkaListener(topics = "webhook" , groupId ="cunsuming" )
    public void webhookListener(Message message){
        System.out.println("Received Message in group consuming <webhook topic> :" + message);
    }



}
