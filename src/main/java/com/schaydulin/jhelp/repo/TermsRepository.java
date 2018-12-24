package com.schaydulin.jhelp.repo;

import com.schaydulin.jhelp.orm.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TermsRepository extends JpaRepository<Term, Integer> {

    Optional<Term> findByTerm(String term);

}
