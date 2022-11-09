package com.restapi.Controller;

import com.restapi.Model.CustomResponse;
import com.restapi.Model.Person;
import com.restapi.Service.PersonService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

import static org.apache.logging.log4j.LogManager.*;


@Controller("/Person")

@Tag(name = "Person Details")
@SecurityRequirement(name="Authorization")
@Secured({SecurityRule.IS_AUTHENTICATED})

public class PersonController {
    private static Logger logger = (Logger) LogManager.getLogger(PersonController.class.getName());
    @Inject
    PersonService employeeService;


    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> addPerson(@Body Person person){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> addPerson(@Body Person person)");
        return HttpResponse.ok(new CustomResponse( employeeService.addPerson(person)));
    }
    @Get(value = "/GetallPerson")
    public  HttpResponse<List<Person>> getAllPerson(){
        logger.info(getClass().getName() + " .HttpResponse<List<Person>> getAllPerson()");
        List<Person> person = employeeService.getAllPerson();

        if (person.size() >= 0) {
            return HttpResponse.ok().body(person);
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Get(value = "/getperson/{id}")
    public HttpResponse <Person> getPersonById(@PathVariable("id") int id){
        logger.info(getClass().getName() + " .HttpResponse <Person> getPersonById(@PathVariable(id) int id)");
        Person person = employeeService.getPersonById(id);

        if(person != null){
            return HttpResponse.ok().body(person);
        }
        else
            return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    @Put(value = "/update/{id}")
    public HttpResponse<CustomResponse> updatePerson(@Body Person person ,@PathVariable("id") int id ){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> updatePerson(@Body Person person ,@PathVariable(id) int id)");
        return HttpResponse.ok(new CustomResponse(employeeService.updatePerson(person, id)));

    }
    @Delete(value = "/delete/{id}")
    public HttpResponse<CustomResponse> deleteById(int id){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> deleteById(int id)");

        return HttpResponse.ok(new CustomResponse(employeeService.deleteById(id)));
    }



}
