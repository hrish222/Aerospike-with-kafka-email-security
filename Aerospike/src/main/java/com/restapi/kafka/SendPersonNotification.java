package com.restapi.kafka;

import jakarta.inject.Inject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.protocol.Message;

public class SendPersonNotification {
    @Inject
    Kafkaproducer kafkaProducer;



    public void sendAccountNotification(Message message) {
        //logger.info("In class " + getClass().getSimpleName() + ".sendAccountNotification(Message message)");
        kafkaProducer.send(KafkaConstraints.PERSON_TOPIC_VALUE, message);
    }
}
