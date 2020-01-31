package com.escola.sistema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Escola extends EntidadeAbstrata {
    @NotBlank
    private String nome;

    public Escola() {
    }

    public Escola(@JsonProperty("nome") String nome) {
        super();
        this.nome = nome;
    }

    public Escola(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
