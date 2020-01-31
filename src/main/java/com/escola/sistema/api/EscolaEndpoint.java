package com.escola.sistema.api;

import com.escola.sistema.model.Escola;
import com.escola.sistema.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/escolas")
public class EscolaEndpoint {

    private final EscolaService escolaService;

    @Autowired
    public EscolaEndpoint(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return escolaService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEscolaById(@PathVariable(value = "id") Integer id) {
        return escolaService.getEscolaById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Escola escola) {
        return escolaService.save(escola);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return escolaService.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Escola escola) {
        return escolaService.save(escola);
    }
}