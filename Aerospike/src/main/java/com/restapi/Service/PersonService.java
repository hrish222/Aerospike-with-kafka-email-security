package com.restapi.Service;

import com.restapi.Model.Person;
import io.micronaut.data.model.Page;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface PersonService {
   public String addPerson(Person person);
   public List<Person> getAllPerson();
  public Person getPersonById(int id);

  public String updatePerson(Person person , int id);
  public String deleteById(int id);
//
//    Page<Person> findEmployeesWithPagination(int pagenumber, int pageSize);
//
//    Page<Person> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field);
}


