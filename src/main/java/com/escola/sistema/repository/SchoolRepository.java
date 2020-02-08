package com.escola.sistema.repository;

import com.escola.sistema.model.School;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchoolRepository extends CrudRepository<School, Long> {
    List<School> findByName(String name);
}
