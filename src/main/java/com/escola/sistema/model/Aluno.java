package com.escola.sistema.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno extends Usuario {

    private String serie;
    @ManyToOne
    private Escola escola;
    @ManyToOne
    private Responsavel responsavel;

    public Aluno() {
    }

    public Aluno(String matricula, Escola escola, String nome, String serie) {
        this.id = matricula;
        this.escola = escola;
        this.nome = nome;
        this.serie = serie;
    }
}
