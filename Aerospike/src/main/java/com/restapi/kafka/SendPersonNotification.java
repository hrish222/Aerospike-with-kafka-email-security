package com.restapi.kafka;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * The type Send person notification.
 */
@Singleton
public class SendPersonNotification {
    /**
     * The Kafka producer.
     */
    @Inject
    Kafkaproducer kafkaProducer;

    /**
     * Send person notification.
     *
     * @param message the message
     */
    public void sendPersonNotification(String message) {

        kafkaProducer.send(KafkaConstraints.PERSON_TOPIC_VALUE,  message);
    }
}
