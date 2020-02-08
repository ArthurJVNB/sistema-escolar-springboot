package com.escola.sistema.service;

import com.escola.sistema.repository.SchoolRepository;
import com.escola.sistema.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> listAll() {
        List<School> schoolList = new ArrayList<>();
        Iterable<School> escolas = schoolRepository.findAll();
        for (School school : escolas) {
            schoolList.add(school);
        }
        return schoolList;
    }

    public Optional<School> getOptionalSchoolById(long id) {
        return schoolRepository.findById(id);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public void update(School school) {
        schoolRepository.save(school);
    }

    public void delete(long id) {
        Optional<School> escolaOptional = getOptionalSchoolById(id);
        escolaOptional.ifPresent(schoolRepository::delete);
    }
}
