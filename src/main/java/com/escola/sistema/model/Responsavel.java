package com.escola.sistema.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Responsavel extends Usuario {
    @Email
    private String email;
    @ManyToOne
    private Escola escola;
    @OneToMany(targetEntity = Aluno.class, mappedBy = "responsavel")
    private List<Aluno> alunos;

    public Responsavel() {
    }

    public Responsavel(String cpf, String nome, String email, String senha, Escola escola) {
        super(cpf, nome, senha);
        this.alunos = new ArrayList<>();
        this.email = email;
        this.escola = escola;
    }

    public Responsavel(String cpf, String nome, String email, String senha, Escola escola, List<Aluno> alunos) {
        new Responsavel(cpf, nome, email, senha, escola);
        this.alunos = alunos;
    }

    public String getCpf() {
        return super.getId();
    }

    public String getEmail() {
        return email;
    }

    public Escola getEscola() {
        return escola;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public void removeAluno(String id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
