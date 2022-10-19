package com.restapi.kafka;

import jakarta.inject.Inject;

public class SendPersonNotification {
    @Inject
    Kafkaproducer kafkaProducer;



    public void sendPersonNotification(String message) {

        kafkaProducer.send(KafkaConstraints.PERSON_TOPIC_VALUE,  message);
    }
}
