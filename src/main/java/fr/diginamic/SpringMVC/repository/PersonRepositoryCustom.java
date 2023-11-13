package fr.diginamic.springmvc.repository;


public interface PersonRepositoryCustom {
    void deletePeopleWithoutAnimals();
    void createManyEntity(int count);
}
