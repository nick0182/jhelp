package com.schaydulin.jhelp.repo;

import com.schaydulin.jhelp.orm.Term;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TermsRepository extends CrudRepository<Term, Integer> {

    Optional<Term> findByTerm(String term);

}
