package fr.diginamic.Spring_Data_JPA.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.Spring_Data_JPA.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PersonRepository personRepository ;

    @BeforeEach
    public void initData() {
        em.clear();
        Person p1 = new Person();
        p1.setFirstname("testfirst");
        p1.setLastname("testlast");
        p1.setAge(25);
        em.persist(p1);
        Person p2 = new Person();
        p2.setFirstname("test2first");
        p2.setLastname("test2last");
        p2.setAge(50);
        em.persist(p2);
        em.flush();
    }

    @Test
    public void findByAgeGreaterThanEqual_Test(){
        List<Person> test = this.personRepository.findByAgeGreaterThanEqual(26);
        Assertions.assertEquals(1, test.size());
    }

    @Test
    public void findAllPersonByAgeMiniAndAgeMax_Test(){
        List<Person> test = this.personRepository.findAllPersonByAgeMiniAndAgeMax(20,52);
                Assertions.assertEquals(2, test.size());
    }
}

