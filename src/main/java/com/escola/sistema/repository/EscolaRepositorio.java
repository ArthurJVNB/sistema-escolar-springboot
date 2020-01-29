package com.escola.sistema.repository;

import com.escola.sistema.model.Escola;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EscolaRepositorio extends CrudRepository<Escola, Integer> {
    List<Escola> findByNome(String nome);
}
