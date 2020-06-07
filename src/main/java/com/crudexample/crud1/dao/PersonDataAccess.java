package com.crudexample.crud1.dao;

import com.crudexample.crud1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

// implementa los metodos de PersonRepository
@Repository(value = "personDA")
public class PersonDataAccess implements com.crudexample.crud1.dao.PersonRepository {

    // se define la lista que va a tener a las personas
    private static List<Person> DBPersonas = new ArrayList<>();

    // insertar personas en DBPersonas que es la "Base de datos"
    @Override
    public int insertPerson(UUID id, Person person) {
        DBPersonas.add(new Person(id, person.getNombre(), person.getApellido(), person.getFecha_nacimiento()));
        return 1;
    }

    @Override
    public List<Person> selectAll(){
        return DBPersonas;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DBPersonas.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Person> selectPersonByName(String nombre) {
        return DBPersonas.stream()
                .filter(person -> person.getNombre().equals(nombre))
                .findAny();
    }

    @Override
    public Optional<Person> selectPersonByLastName(String apellido) {
        return DBPersonas.stream()
                .filter(person -> person.getNombre().contains(apellido))
                .findAny();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> deletePerson = selectPersonById(id);
        if (deletePerson.isEmpty()){
            return 0;
        }
        DBPersonas.remove(deletePerson.get());
        return 1;

    }

    @Override
    public int updatePerson(UUID id, Person personUpdate) {
        return selectPersonById(id)
                .map(person -> {
                    int index = DBPersonas.indexOf(person);
                    if (index >= 0){
                        DBPersonas.set(index, new Person(id, personUpdate.getNombre(), personUpdate.getApellido(), personUpdate.getFecha_nacimiento()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
