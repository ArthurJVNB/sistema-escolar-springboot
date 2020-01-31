package com.escola.sistema.dao;

import com.escola.sistema.model.Escola;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EscolaDAO extends CrudRepository<Escola, Integer> {
    List<Escola> findByNome(String nome);
}
