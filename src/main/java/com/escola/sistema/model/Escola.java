package com.escola.sistema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Escola {
    private long id;
    private String nome;
    private static ArrayList<Escola> repositorio;

    static {
        // TODO temporário enquanto não tem BD
        repositorio = new ArrayList<>();
        repositorio.add(new Escola(1, "Escola Mazzarelo"));
        repositorio.add(new Escola(2, "Escola Amanhecer"));
        repositorio.add(new Escola(3, "Escola Escolha"));
    }

    public Escola(long id, String nome) {
        // TODO id temporário
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Escola> getRepositorio() {
        return repositorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escola escola = (Escola) o;
        return id == escola.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
