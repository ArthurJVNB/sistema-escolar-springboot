package com.escola.sistema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class School extends AbstractEntity {
    @NotBlank
    private String name;

    public School() {
    }

    public School(@JsonProperty("nome") String name) {
        super();
        this.name = name;
    }

    public School(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
