package com.escola.sistema.model;

import java.util.List;

public class Aluno {
    private String matricula;
    private String cpf;
    private String cpfResponsavel;
    private String idEscola;
    private String nome;
    private String serie;
    // TODO lista temporária de notas enquanto não tem BD
    private List<Nota> notas;

    public Aluno(String matricula, String cpf, String cpfResponsavel, String idEscola, String nome, String serie) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.cpfResponsavel = cpfResponsavel;
        this.idEscola = idEscola;
        this.nome = nome;
        this.serie = serie;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
