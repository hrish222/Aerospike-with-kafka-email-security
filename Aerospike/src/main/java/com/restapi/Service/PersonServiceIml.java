package com.restapi.Service;

import com.restapi.Model.Person;
import com.restapi.Repository.PersonRepositoryIml;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * The type Person service iml.
 */
@Singleton
public class PersonServiceIml implements PersonService {
    /**
     * The Employee repository.
     */
    @Inject
    PersonRepositoryIml employeeRepository;



    @Override
    public String addPerson(Person person) {
        return employeeRepository.addPerson(person);
    }
    @Override
   public List<Person> getAllPerson(){

        return employeeRepository.getAllPerson();
   }

    @Override
    public Person getPersonById(int id) {

        return employeeRepository.findById(id);

    }

    @Override
    public String updatePerson(Person person, int id) {

        return employeeRepository.updatePerson(person, id);
    }
    @Override
    public String deleteById(int id){

        return employeeRepository.deleteById(id);
    }



}
