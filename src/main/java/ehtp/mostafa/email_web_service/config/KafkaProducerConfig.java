package ehtp.mostafa.email_web_service.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress ;

    @Bean
    public ProducerFactory<String , String> producerFactory(){
        Map<String , Object> prodConf = new HashMap<>();
        prodConf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , bootstrapAddress);
        prodConf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class);
        prodConf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG  , JsonSerializer.class);
        prodConf.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG , "20971520");

        return new DefaultKafkaProducerFactory<>(
                        prodConf ,
                        new StringSerializer() ,
                        new JsonSerializer<>()
                );
    }

    @Bean
    KafkaTemplate<String , String> jsonKafkaTemplate(
            ProducerFactory<String , String> jsonProducerFactory
    ){
        return new KafkaTemplate<>(jsonProducerFactory);
    }
}
