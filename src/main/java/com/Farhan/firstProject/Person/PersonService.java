package com.Farhan.firstProject.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    private PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void addPerson(PersonModel person){

        personDAO.addPerson(person);
    }
    public List<PersonModel> getPerson(){
        return personDAO.getPerson();
    }
    public boolean deletePerson(Long id){
        return personDAO.deletePerson(id);
    }
}
