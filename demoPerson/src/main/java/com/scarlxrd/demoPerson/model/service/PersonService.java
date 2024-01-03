package com.scarlxrd.demoPerson.model.service;

import com.scarlxrd.demoPerson.model.entity.Person;
import com.scarlxrd.demoPerson.model.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //return list de person
    public List<Person> get(){
        return personRepository.findAll();
    }
    //create person
    public ResponseEntity<Person> create(Person person){
        personRepository.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // return de person por id
    public Optional<Person> getById(Long id){
        Optional<Person> person = personRepository.findById(id);
        return person;
    }
    //Update de uma person
    public ResponseEntity<Person> update(Long id, Person newPerson){
        Optional<Person> oldPerson = personRepository.findById(id);
            if(oldPerson.isPresent()){
                Person person = oldPerson.get();
                person.setFirstName(newPerson.getFirstName());
                person.setSecondName(newPerson.getSecondName());
                person.setCpf(newPerson.getCpf());
                person.setAge(newPerson.getAge());
                personRepository.save(person);
                return  new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }
    //delete de person
    public ResponseEntity<Person> delete(Long id){
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(personRepository::delete);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
