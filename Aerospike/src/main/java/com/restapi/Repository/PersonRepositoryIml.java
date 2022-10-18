package com.restapi.Repository;


import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Email.EmailDetails;
import com.restapi.Model.Person;
import com.restapi.Service.EmailService;
import jakarta.inject.Inject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
import java.util.Properties;

import static org.apache.kafka.common.resource.ResourceType.TOPIC;

public class PersonRepositoryIml implements PersonRepository {
    @Inject
    aeroMapperConfig mapper;

    @Inject
    EmailService emailService;



    static final Object BOOTSTRAP_SERVERS = "localhost:9092";
    static final String TOPIC = "person";


    @Override
    public String addPerson(Person person) {
       mapper.getMapper().save(person);
        Properties producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);

        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Person Data Added..!="+" "+person);
        kafkaProducer.send(record);
        kafkaProducer.close();

        EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info added "+person.getName()+", Your Person Id is "+person.getId(), person.getEmail()));
        return "Person saved successfully..!="+person.getId();
    }
    @Override
    public List<Person> getAllPerson(){
        Properties producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);

        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Get All Person Data...!="+" "+mapper.getMapper().scan(Person.class));
        kafkaProducer.send(record);
        kafkaProducer.close();
       return mapper.getMapper().scan(Person.class);

       // EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info updated "+Person.class.getName()+", Your Person Id is "+person.);
    }
@Override
    public Person findById(int id) {
    Properties producerProperties = new Properties();
    producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
    producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
    producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


    KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);

    ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Get Person Data by Id..!="+" "+mapper.getMapper().read(Person.class,id));
    kafkaProducer.send(record);
    kafkaProducer.close();

        return mapper.getMapper().read(Person.class, id);

    }
    @Override
    public String updatePerson(Person person, int id) {
        Person p = mapper.getMapper().read(Person.class,id);
           // p.setId(person.getId());
            p.setName(person.getName());
            p.setEmail(person.getEmail());
            p.setJoiningDate(person.getJoiningDate());
            p.setSal(person.getSal());
            p.setCategories(person.getCategories());


            mapper.getMapper().save(p);
        Properties producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);

        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Person Data Updated"+" "+person);
        kafkaProducer.send(record);
        kafkaProducer.close();
        EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info updated..!= "+person.getName()+", Your Person Id is "+person.getId(), person.getEmail()));
            return "Person Updated..!="+p.getId();
    }
    @Override
    public String deleteById(int id) {
        mapper.getMapper().delete(Person.class,id);
        Properties producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);


        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Person Data Deleted By Id..!="+id);
        kafkaProducer.send(record);
        kafkaProducer.close();
       // EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info Data Deleted "+Person.class.getName()+"Person deleted Id"+Person.class,deleteById(id)));
        return "Person Deleted By Id..!="+id;

    }
}
