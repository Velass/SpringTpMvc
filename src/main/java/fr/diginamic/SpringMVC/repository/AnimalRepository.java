package fr.diginamic.springmvc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.springmvc.enums.Sex;
import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.model.Species;


@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
        List<Animal> findBySpecies(Species species);
        List<Animal> findByColorIn(List<String> colors);

        @Query("SELECT COUNT(a) from Animal a where a.sex = :sex")
        Integer countBySex(@Param("sex") Sex m);

        @Query("SELECT CASE WHEN SIZE(a.persons) > 0 THEN true ELSE false END FROM Animal a WHERE a = :id")
        Boolean hasOwner(@Param("id") Animal id);

        List<Animal> findAll();
}
