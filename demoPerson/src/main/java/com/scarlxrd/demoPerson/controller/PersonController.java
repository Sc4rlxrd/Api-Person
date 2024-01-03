package com.scarlxrd.demoPerson.controller;

import com.scarlxrd.demoPerson.model.entity.Person;
import com.scarlxrd.demoPerson.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    List<Person>get(){
        return personService.get();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    Optional<Person> getById(@PathVariable Long id){
        return personService.getById(id);
    }
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    ResponseEntity<Person> create(@Validated @RequestBody Person person){
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person newPerson){
        return personService.update(id,newPerson);
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Person> delete(@PathVariable Long id){
        return personService.delete(id);
    }


}
