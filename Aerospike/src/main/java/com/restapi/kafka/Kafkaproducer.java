package com.restapi.kafka;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.apache.kafka.common.protocol.Message;

@KafkaClient
public interface Kafkaproducer {
    //void sendProduct(@Topic String topic, @KafkaKey String name, String email);
    void send(@Topic String topic, Message message);
    //void send(String personTopicValue, Message message);
}
