package com.example.customerriskconsumer.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.customerriskconsumer.models.CustomerRisk;

@EnableKafka
@Configuration
public class KafkaConsumerRiskConfig {
	
    @Bean
    public ConsumerFactory<String, CustomerRisk> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          "127.0.0.1:9092");
        props.put(
          ConsumerConfig.GROUP_ID_CONFIG, 
          "GazelleCustomerRisk");

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer(CustomerRisk.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CustomerRisk>
      kafkaListenerContainerFactory() {
   
        ConcurrentKafkaListenerContainerFactory<String, CustomerRisk> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
