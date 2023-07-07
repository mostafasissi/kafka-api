package ehtp.mostafa.email_web_service.producer;

import ehtp.mostafa.email_web_service.entities.ProducerMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j

public class Topic1Producer {
    final String topic = "topic-1";
    private KafkaTemplate<String , String> kafkaTemplate ;

    @Autowired
    public Topic1Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic", message);

        future.whenComplete((input, exception) -> {
            if (exception != null) {
                System.out.println("exception occurs");
                System.err.println(exception);
            } else {
                System.out.println("no exception, got result: " + input);
            }
        });



    }
}
