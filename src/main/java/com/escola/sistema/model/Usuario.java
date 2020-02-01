package com.escola.sistema.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Usuario extends EntidadeAbstrata {
    @NotBlank @NotNull
    protected String nome;
    @NotBlank @NotNull
    protected String senha;

    public Usuario() {
    }

    protected Usuario(String id, String nome, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    protected String getSenha() {
        return senha;
    }

    public boolean isSenhaCorreta(String senhaParaTestar) {
        return this.senha.equals(senhaParaTestar);
    }
}
