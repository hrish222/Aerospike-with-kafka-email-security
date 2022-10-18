//package com.restapi.kafka;
//
//import com.restapi.Model.Person;
//import io.micronaut.configuration.kafka.annotation.KafkaClient;
//import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//
//import java.util.concurrent.Future;
//
//@Singleton
//public class KafkaController {
//
//        private final Producer<String, Person> kafkaProducer;
//
//        public KafkaController(
//                @KafkaClient("person") Producer<String, Person> kafkaProducer) {
//            this.kafkaProducer = kafkaProducer;
//        }
//
//        public Future<RecordMetadata> send(String name, Person person) {
//            return kafkaProducer.send(new ProducerRecord<>("person", name, person));
//        }
//
//    }
//
