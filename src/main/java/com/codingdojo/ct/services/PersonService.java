package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.Person;
import com.codingdojo.ct.repositories.PeopleRepository;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;
    
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    // returns all the persons
    public List<Person> allPeople() {
        return peopleRepository.findAll();
    }
    // creates a person
    public Person createPerson(Person b) {
        return peopleRepository.save(b);
    }
    
    // Updates a person
    public Person updatePerson(Person b) {
        return peopleRepository.save(b);
    }
    
    // retrieves a person
    public Person findPerson(Long id) {
        Optional<Person> optionalBook = peopleRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Deletes a person
    
	public void deletePerson(long id) {
		peopleRepository.deleteById(id);
	  }
}
