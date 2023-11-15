package fr.diginamic.springmvc.mapper;

import fr.diginamic.springmvc.dto.PersonDto;
import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.model.Person;

public class PersonDtoMapper {
    public static PersonDto toDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setAge(person.getAge());
        personDto.setName(person.getLastname().toUpperCase() + " " + person.getFirstname());
        if (person.getAnimals() != null) {
            String[] animalNames = person.getAnimals().stream()
                    .map(Animal::getName)
                    .toArray(String[]::new);

            personDto.setAnimals(animalNames);

        }
        return personDto;
    }
}
