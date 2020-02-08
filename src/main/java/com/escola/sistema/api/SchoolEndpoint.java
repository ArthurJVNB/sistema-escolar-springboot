package com.escola.sistema.api;

import com.escola.sistema.model.School;
import com.escola.sistema.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/schools")
public class SchoolEndpoint {

    private final SchoolService service;

    @Autowired
    public SchoolEndpoint(SchoolService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable(value = "id") long id) {
        Optional<School> optional = service.getOptionalSchoolById(id);
        if (optional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @NotNull @RequestBody School school) {
        return new ResponseEntity<>(service.save(school), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @NotNull @RequestBody School school) {
        service.update(school);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}