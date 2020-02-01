package com.escola.sistema.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
// Não é mapeada no BD, apenas será estendida
public class EntidadeAbstrata implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadeAbstrata that = (EntidadeAbstrata) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
