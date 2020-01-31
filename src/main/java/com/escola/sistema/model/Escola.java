package com.escola.sistema.model;

import javax.persistence.Entity;

@Entity
public class Escola extends EntidadeAbstrata {
    private String nome;

    public Escola() {
    }

    public Escola(String nome) {
        super();
        setNome(nome);
    }

    public Escola(Integer id, String nome) {
        super();
        setId(id);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
