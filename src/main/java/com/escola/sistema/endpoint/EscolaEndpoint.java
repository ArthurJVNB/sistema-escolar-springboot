package com.escola.sistema.endpoint;

import com.escola.sistema.model.Escola;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(path = "escolas")
public class EscolaEndpoint {
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Escola.getRepositorio(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEscolaById(@PathVariable(value = "id") int id) {
        // TODO forma temporária antes do BD
        if (id < 0 || id > Escola.getRepositorio().size() - 1)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Escola.getRepositorio().get(id), HttpStatus.OK);
    }
}
