package com.escola.sistema.service;

import com.escola.sistema.dao.EscolaDAO;
import com.escola.sistema.model.Escola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EscolaService {
    private final EscolaDAO escolaDAO;

    @Autowired
    public EscolaService(EscolaDAO escolaDAO) {
        this.escolaDAO = escolaDAO;
    }

    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(escolaDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getEscolaById(Integer id) {
        Optional<Escola> escolaOptional = escolaDAO.findById(id);
        if (escolaOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(escolaOptional.get(), HttpStatus.OK);
    }

    public ResponseEntity<?> save(Escola escola) {
        return new ResponseEntity<>(escolaDAO.save(escola), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Escola escola) {
        escolaDAO.save(escola);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Integer id) {
        Optional<Escola> escolaOptional = escolaDAO.findById(id);
        escolaOptional.ifPresent(escolaDAO::delete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
