package com.restapi;

import com.restapi.Controller.PersonController;
import com.restapi.Model.Categories;

import com.restapi.Model.Person;

import com.restapi.Repository.PersonRepositoryIml;


import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@MicronautTest
public class PersonControllerImlTest {
    @Inject
    private PersonRepositoryIml personRepositoryIml;

    @Inject
    private PersonController personController;
   // private CustomResponse Ok;

    @MockBean(PersonRepositoryIml.class)
    PersonRepositoryIml personRepositoryIml() {
        return mock(PersonRepositoryIml.class);
    }



    @Test
    public void getAllPerson(){
        when(personRepositoryIml.getAllPerson()).thenReturn(Stream.of(new Person(),
                new Person(),
                new Person()).collect(Collectors.toList()));

        Assertions.assertEquals(3,personController.getAllPerson().body().size());
    }
    @Test
    public void addPerson() {
        //arrange
        Categories categories = new Categories(12);
        Person person = new Person(12,"hrishi","hrishikesh22@gmail.com", 2345,"2012-09-26",categories,123456123);

     //when(personController.addPerson(person)).thenReturn(HttpResponse.ok(new CustomResponse(personController.addPerson(person))));

      String result = String.valueOf(personController.addPerson(person));
      System.out.println(" result : "+result);

        assertEquals(result,"200 Ok" );
    }
    @Test
    public void updatePerson(){
        Categories categories = new Categories(12);
        Person person = new Person(12,"hrishi","hrishikesh22@gmail.com",2345,"2023-09-12",categories,123456);
        person.setName("hrishi");
        Person newEmp= new Person("hrash","hrishikesh222@gmail.com",23145,"2022-05-12",categories,234222);

        //when(personController.updatePerson(person,12)).thenReturn("Person Updated..!=");

        String result = String.valueOf(personController.updatePerson(person,12));

        assertEquals(result,"200 Ok" );
    }
    @Test
    public void deleteById(){
        Categories categories = new Categories(12);
        Person person = new Person("hrishi","hrishikesh22@gmail.com",1234,"2022-03-22",categories,123333);
        person.setId(12);

        //when(personController.deleteById(12)).thenReturn("Person Deleted By Id..!=");

        String result = String.valueOf(personController.deleteById(12));

        assertEquals(result, "200 Ok");
    }
}
