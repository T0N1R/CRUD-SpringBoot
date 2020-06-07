package com.crudexample.crud1.dao;

import com.crudexample.crud1.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {

    // va a ser 1 si se envia una persona, 0 si no
    int insertPerson(UUID id, Person person);

    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAll();

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);

    Optional<Person> selectPersonByName(String nombre);

    Optional<Person> selectPersonByLastName(String apellido);
}
