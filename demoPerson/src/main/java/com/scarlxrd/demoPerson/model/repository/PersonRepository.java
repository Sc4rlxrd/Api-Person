package com.scarlxrd.demoPerson.model.repository;

import com.scarlxrd.demoPerson.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
