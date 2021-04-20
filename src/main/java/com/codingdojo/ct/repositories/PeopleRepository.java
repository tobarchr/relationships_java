package com.codingdojo.ct.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.ct.models.Person;

public interface PeopleRepository extends CrudRepository <Person, Long>{
    List<Person> findAll();

}
