package com.escola.sistema;

import com.escola.sistema.model.Escola;
import com.escola.sistema.dao.EscolaDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@SpringBootTest
public class EscolaDAOTests {
    @MockBean
    private EscolaDAO repositorio;
/*
    @BeforeEach
    void setRepositorioOutput() {
        when(repositorio.findById(1)).thenReturn(java.util.Optional.of(new Escola(1, "Primeira Escola")));

        List<Escola> escolas = asList(new Escola(1, "Primeira Escola"), new Escola(2, "Segunda Escola"));
        when(repositorio.findByNome("escola")).thenReturn(escolas);
    }
*/

    @BeforeEach
    void setRepositorioData() {
        repositorio.save(new Escola("Primeira Escola"));
        repositorio.save(new Escola("Segunda Escola"));
    }

    @Test
    void procurarPeloIdExistente_DeveRetornarUmaEscola() {
        Optional<Escola> escolaOptional = repositorio.findById(1);
        Assertions.assertTrue(escolaOptional.isPresent());
    }

    @Test
    void procurarPeloIdInexistente_DeveRetornarUmaEscolaVazia() {
        Optional<Escola> escolaOptional = repositorio.findById(3);
        Assertions.assertTrue(escolaOptional.isEmpty());
    }

    @Test
    void procurarPorNomeExistente_DeveRetornarUmaListaDeEscolas() {
        List<Escola> escolaList = repositorio.findByNome("escola");

        List<Escola> escolas = asList(new Escola(1, "Primeira Escola"), new Escola(2, "Segunda Escola"));
        Assertions.assertEquals(escolas.get(0), escolaList.get(0));
        Assertions.assertEquals(escolas.get(1), escolaList.get(1));
        Assertions.assertEquals(2, escolaList.size());
    }
}
