package com.crudexample.crud1.api;

import com.crudexample.crud1.model.Person;
import com.crudexample.crud1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("hello/persons/name")
@RestController
public class NamesController {

    private final PersonService personService;

    @Autowired
    public NamesController(PersonService personService) {
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

    /*
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

     */


    @GetMapping(path = "{nombre}")
    public Person getPersonById(@PathVariable("nombre") String nombre){
        return personService.getPersonByName(nombre).orElse(null);
    }

    /*
    @GetMapping(path = "{apellido}")
    public  Person getPersonByLastName(@PathVariable("apellido") String apellido){
        return personService.getPersonByLastName(apellido).orElse(null);
    }

     */
}
