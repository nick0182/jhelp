package com.schaydulin.jhelp.orm;

import javax.persistence.*;

@Entity
@Table(name = "Definitions")
public class Definition {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String definition;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;

    public Definition() {}

    public Definition(String definition) {
        this.definition = definition;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return definition;
    }
}
