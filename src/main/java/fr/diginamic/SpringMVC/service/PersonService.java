package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.dto.PersonDto;
import fr.diginamic.springmvc.exception.EntityToCreateHasAnIdException;
import fr.diginamic.springmvc.mapper.PersonDtoMapper;
import fr.diginamic.springmvc.model.Person;
import fr.diginamic.springmvc.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();

    }

    public Person findById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));

    }

    public Person createPerson(@Valid Person createPerson) {
        if (createPerson.getId() != 0) {
            throw new EntityToCreateHasAnIdException("présence d’un ID ");
        }
        return personRepository.save(createPerson);
    }

    public Person updatePerson(@Valid Person updatePerson) {
        boolean idInUpdatePerson = personRepository.existsById(updatePerson.getId());
        if (updatePerson.getId() == 0) {
            throw new EntityToCreateHasAnIdException("non-présence d’un ID ");
        }
        if (idInUpdatePerson != false) {
            return personRepository.save(updatePerson);
        }
        throw new EntityNotFoundException("ID : " + updatePerson.getId() + " introuvable");
    }

    public Person deletePerson(Integer id) {
        Person personToDelete = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));
        if (personToDelete != null) {
            personRepository.deleteById(id);
        }
        return personToDelete;
    }

    public Page<PersonDto> findAll(Pageable pageable) {
        Page<Person> pagePerson = personRepository.findAll(pageable);
        return pagePerson.map((person) -> PersonDtoMapper.toDto(person));
    }

}
