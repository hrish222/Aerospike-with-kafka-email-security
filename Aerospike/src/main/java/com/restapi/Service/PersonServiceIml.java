package com.restapi.Service;

import com.restapi.Model.Person;
import com.restapi.Repository.PersonRepositoryIml;
import com.restapi.kafka.SendPersonNotification;
import io.micronaut.data.model.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.kafka.common.protocol.Message;

import java.util.List;

@Singleton
public class PersonServiceIml implements PersonService {
    @Inject
    PersonRepositoryIml employeeRepository;
@Inject
EmailService emailRepository;
@Inject
    SendPersonNotification sendPersonNotification;
    @Override
    public String addPerson(Person person) {
        return employeeRepository.addPerson(person);
    }
   public List<Person> getAllPerson(){
        return employeeRepository.getAllPerson();
   }

    @Override
    public Person getPersonById(int id) {
        String Message = "dfggnmdbvjbvvcbh";
        return employeeRepository.findById(id);

    }


    @Override
    public String updatePerson(Person person, int id) {
        return employeeRepository.updatePerson(person, id);
    }
    public String deleteById(int id){
     return employeeRepository.deleteById(id);
    }

//
//@Override
//    		 public Page<Person> findEmployeesWithPagination(int pagenumber, int pageSize){
//		        Page<Person> person = employeeRepository.getAllPerson(pa.of(pagenumber, pageSize));
//		        return  person;
//		    }
//@Override
//		    public Page<Person> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field){
//		        Page<Person> employee = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//		        return  employee;
//		    }

}
