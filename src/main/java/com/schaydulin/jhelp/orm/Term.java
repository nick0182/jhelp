package com.schaydulin.jhelp.orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Terms")
public class Term {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String term;

    public Term() {}

    public Term(String term) {
        this.term = term;
    }

    public void addDefinition(Definition definition) {
        definitions.add(definition);
        definition.setTerm(this);
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Definition> definitions = new ArrayList<>();

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
        return term;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term that = (Term) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
