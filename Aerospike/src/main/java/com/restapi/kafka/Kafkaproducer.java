package com.restapi.kafka;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

/**
 * The interface Kafkaproducer.
 */
@KafkaClient
public interface Kafkaproducer {

    /**
     * Send.
     *
     * @param topic   the topic
     * @param message the message
     */
    void send(@Topic String topic, String message);
    
}
