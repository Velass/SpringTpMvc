package fr.diginamic.springmvc.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.diginamic.springmvc.model.Person;
import fr.diginamic.springmvc.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/person")
public class PersonRestController {
    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Integer id) {
        return personService.findById(id);
    }

    @PostMapping()
    public Person createPerson(@RequestBody @Valid Person createPerson) {
        return personService.createPerson(createPerson);
    }

    @PutMapping()
    public Person updatePerson(@RequestBody @Valid Person updatePerson) {
        return personService.updatePerson(updatePerson);
    }

    @DeleteMapping("/delete/{id}")
    public Person deletePerson(@PathVariable("id") Integer id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/findPage")
    public Page<Person> findPage(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        return personService.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
