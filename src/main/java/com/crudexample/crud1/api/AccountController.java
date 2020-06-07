package com.crudexample.crud1.api;

import com.crudexample.crud1.model.Person;
import com.crudexample.crud1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("hello/persons")
@RestController
public class AccountController {

    private final PersonService personService;

    @Autowired
    public AccountController(PersonService personService) {
        this.personService = personService;
    }

    // va a ser un POST request -> agregar una persona al CRUD
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person persontUpdate){
        personService.updatePersonById(id, persontUpdate);
    }

    /*
    @GetMapping(path = "{nombre}")
    public Person getPersonById(@PathVariable("nombre") String nombre){
        return personService.getPersonByName(nombre).orElse(null);
    }

    @GetMapping(path = "{apellido}")
    public  Person getPersonByLastName(@PathVariable("apellido") String apellido){
        return personService.getPersonByLastName(apellido).orElse(null);
    }

     */


}
