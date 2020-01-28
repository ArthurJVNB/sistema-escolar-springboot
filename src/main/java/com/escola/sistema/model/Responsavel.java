package com.escola.sistema.model;

import java.util.List;

public class Responsavel {
    private String cpf;
    private String nome;
    private long idEscola;
    private String email;
    private String senha;
    // TODO lista temporária enquanto não tem BD
    private List<Aluno> alunos;

    public Responsavel(String cpf, String nome, long idEscola, String email, String senha, List<Aluno> alunos) {
        this.cpf = cpf;
        this.nome = nome;
        this.idEscola = idEscola;
        this.email = email;
        this.senha = senha;
        this.alunos = alunos;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
