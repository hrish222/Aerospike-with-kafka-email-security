package com.restapi.Repository;


import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Email.EmailDetails;
import com.restapi.Model.Person;
import com.restapi.Service.EmailService;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.IntegerSerializer;
//import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
//import java.util.Properties;
//
//import static org.apache.kafka.common.resource.ResourceType.TOPIC;

public class PersonRepositoryIml implements PersonRepository {
    @Inject
    aeroMapperConfig mapper;

    @Inject
    EmailService emailService;
    @Inject
    SendPersonNotification sendPersonNotification;
//    @Inject
//    SendEmailNotification sendEmailNotification;


    @Override
    public String addPerson(Person person) {
       mapper.getMapper().save(person);
         sendPersonNotification.sendPersonNotification("Person addded..!"+person);
        // sendEmailNotification.sendEmailNotification("dfhhadfhi"+person.getEmail(),"Person alerts!!");

        EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info added "+person.getName()+", Your Person Id is "+person.getId(), person.getEmail()));
        return "Person saved successfully..!="+person.getId();
    }
    @Override
    public List<Person> getAllPerson(){

        sendPersonNotification.sendPersonNotification("Get All Person Info..!"+mapper.getMapper().scan(Person.class));
       return mapper.getMapper().scan(Person.class);

       // EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info updated "+Person.class.getName()+", Your Person Id is "+person.);
    }
@Override
    public Person findById(int id) {
    sendPersonNotification.sendPersonNotification("Get Person Info By Id ..!"+mapper.getMapper().read(Person.class,id));
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
        sendPersonNotification.sendPersonNotification("Person Info Updated Successfully..!"+person);
        EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info updated..!= "+person.getName()+", Your Person Id is "+person.getId(), person.getEmail()));
            return "Person Updated..!="+p.getId();
    }
    @Override
    public String deleteById(int id) {
        mapper.getMapper().delete(Person.class,id);
        sendPersonNotification.sendPersonNotification("Person Deleted Successfully..!"+id);
        //EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info Data Deleted "+Person.class.getName()+"Person deleted Id"+mapper.getMapper().delete(Person.class)));
        return "Person Deleted By Id..!="+id;

    }
}
