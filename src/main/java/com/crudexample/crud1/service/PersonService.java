package com.crudexample.crud1.service;

import com.crudexample.crud1.dao.PersonRepository;
import com.crudexample.crud1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(@Qualifier("personDA") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int addPerson(Person person){
        return personRepository.addPerson(person);
    }

    public List<Person> getAll(){
        return personRepository.selectAll();
    }

    public Optional<Person> getPersonById(UUID id){
        return personRepository.selectPersonById(id);
    }

    public Optional<Person> getPersonByName(String nombre){
        return personRepository.selectPersonByName(nombre);
    }

    public Optional<Person> getPersonByLastName(String apellido){
        return personRepository.selectPersonByLastName(apellido);
    }

    public int deletePerson(UUID id){
        return personRepository.deletePerson(id);
    }

    public int updatePersonById(UUID id, Person personModificado){
        return personRepository.updatePerson(id, personModificado);
    }

}
