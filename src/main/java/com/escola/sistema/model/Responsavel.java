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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(long idEscola) {
        this.idEscola = idEscola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
