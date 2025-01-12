package com.test.persistence.repositories.local;

import org.springframework.stereotype.Repository;

import com.test.persistence.models.local.Person;
import com.test.persistence.repositories.config.AbstractRepository;

@Repository
public interface PersonRepository extends AbstractRepository<Person, Long> {

}
