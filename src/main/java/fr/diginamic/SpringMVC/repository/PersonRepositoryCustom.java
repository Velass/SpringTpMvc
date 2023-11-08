package fr.diginamic.SpringMVC.repository;


public interface PersonRepositoryCustom {
    void deletePeopleWithoutAnimals();
    void createManyEntity(int count);
}
