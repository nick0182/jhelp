package com.schaydulin.jhelp.orm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Terms")
public class Term {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String term;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Definition> definitions = new ArrayList<>();

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
        return term;
    }
}
