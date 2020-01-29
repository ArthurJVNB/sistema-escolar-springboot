package com.escola.sistema.endpoint;

import com.escola.sistema.model.Escola;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "escolas")
public class EscolaEndpoint {
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Escola.repositorio, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEscolaById(@PathVariable(value = "id") int id) {
        // TODO forma temporária antes do BD
        if (id < 0 || id > Escola.repositorio.size() - 1)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Escola.repositorio.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Escola escola) {
        // TODO forma temporária antes do BD
        Escola.repositorio.add(escola);
        return new ResponseEntity<>(escola, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Escola escola) {
        // TODO forma temporára antes do BD
        Escola.repositorio.remove(escola);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Escola escola) {
        // TODO forma temporára antes do BD
        Escola.repositorio.set(Escola.repositorio.indexOf(escola), escola);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}