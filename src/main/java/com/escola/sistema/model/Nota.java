package com.escola.sistema.model;

public class Nota {
    private String nomeMateria;
    private String periodo;
    private String nota;
    private String cpfAluno;

    public Nota(String nomeMateria, String periodo, String nota, String cpfAluno) {
        this.nomeMateria = nomeMateria;
        this.periodo = periodo;
        this.nota = nota;
        this.cpfAluno = cpfAluno;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }
}
