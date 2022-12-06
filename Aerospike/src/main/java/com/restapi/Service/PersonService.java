package com.restapi.Service;
import com.restapi.Model.Person;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * The interface Person service.
 */
@Singleton
public interface PersonService {
    /**
     * Add person string.
     *
     * @param person the person
     * @return the string
     */
    public String addPerson(Person person);

    /**
     * Gets all person.
     *
     * @return the all person
     */
    public List<Person> getAllPerson();

    /**
     * Gets person by id.
     *
     * @param id the id
     * @return the person by id
     */
    public Person getPersonById(int id);

    /**
     * Update person string.
     *
     * @param person the person
     * @param id     the id
     * @return the string
     */
    public String updatePerson(Person person , int id);

    /**
     * Delete by id string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteById(int id);

}


