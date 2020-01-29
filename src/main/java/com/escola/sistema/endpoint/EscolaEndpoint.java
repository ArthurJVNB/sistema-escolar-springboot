package com.escola.sistema.endpoint;

import com.escola.sistema.model.Escola;
import com.escola.sistema.repository.EscolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "escolas")
public class EscolaEndpoint {

    private final EscolaRepositorio escolaDAO;
    @Autowired
    public EscolaEndpoint(EscolaRepositorio escolaDAO) {
        this.escolaDAO = escolaDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(escolaDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEscolaById(@PathVariable(value = "id") Integer id) {
        Optional<Escola> escola = escolaDAO.findById(id);
        if (escola.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(escola.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Escola escola) {
        return new ResponseEntity<>(escolaDAO.save(escola), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Escola> escola = escolaDAO.findById(id);
        escola.ifPresent(escolaDAO::delete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Escola escola) {
        escolaDAO.save(escola);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}