package com.restapi.Repository;

import com.restapi.Model.Person;
import java.util.List;

/**
 * The interface Person repository.
 */
public interface PersonRepository {

    /**
     * Add person string.
     *
     * @param person the person
     * @return the string
     */
    public  String addPerson(Person person);

    /**
     * Gets all person.
     *
     * @return the all person
     */
    public List<Person> getAllPerson();

    /**
     * Find by id person.
     *
     * @param id the id
     * @return the person
     */
    public Person findById(int id);

    /**
     * Update person string.
     *
     * @param person the person
     * @param id     the id
     * @return the string
     */
    public String updatePerson(Person person, int id);

    /**
     * Delete by id string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteById(int id);


}


