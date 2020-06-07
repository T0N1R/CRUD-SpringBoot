package com.crudexample.crud1.api;

import com.crudexample.crud1.model.Person;
import com.crudexample.crud1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("hello/persons/lastname")
@RestController
public class LastNameController {

    private final PersonService personService;

    @Autowired
    public LastNameController(PersonService personService) {
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

    @GetMapping(path = "{apellido}")
    public  Person getPersonByLastName(@PathVariable("apellido") String apellido){
        return personService.getPersonByLastName(apellido).orElse(null);
    }

}
