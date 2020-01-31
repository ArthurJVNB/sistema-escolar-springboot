package com.escola.sistema;

import com.escola.sistema.endpoint.EscolaEndpoint;
import com.escola.sistema.model.Escola;
import com.escola.sistema.repository.EscolaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EscolaEndpointTests {
    @Autowired
    private EscolaEndpoint endpoint;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private EscolaRepositorio repositorio;

    @BeforeEach
    void setRepositorioOutput() {
        when(repositorio.findById(1)).thenReturn(java.util.Optional.of(new Escola(1, "Primeira Escola")));

        List<Escola> escolas = asList(new Escola(1, "Primeira Escola"), new Escola(2, "Segunda Escola"));
        when(repositorio.findByNome("escola")).thenReturn(escolas);
        when(repositorio.findAll()).thenReturn(escolas);
    }

    @Test
    void salvarEscola_DeveRetornarHttpStatus200() {

        //Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void procurarEscolaComIdExistente_DeveRetornarHttpStatus200() {
        ResponseEntity<?> responseEntity = restTemplate.getForEntity("/escolas/{id}", null, 1);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void procurarEscolaComIdInexistente_DeveRetornarHttpStatus404() {
        ResponseEntity<?> responseEntity = endpoint.getEscolaById(3);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
}
