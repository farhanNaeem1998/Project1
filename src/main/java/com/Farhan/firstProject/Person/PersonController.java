package com.Farhan.firstProject.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    //Endpoint to add a new person.
    @PostMapping("/person")
    public void addPerson(@RequestBody PersonModel person) {

        if(person != null) {
            personService.addPerson(person);
        }
    }
    @GetMapping("/person")
    public List<PersonModel> getPerson(){
        return personService.getPerson();
    }
    @DeleteMapping("/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable (required = false) Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().body("ID of the person is not provided");
        }
        boolean isDeleted = personService.deletePerson(id);
        if(isDeleted) {
            return ResponseEntity.ok("Person deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
