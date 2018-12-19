package com.schaydulin.jhelp;

import com.schaydulin.jhelp.repo.TermsRepository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.InputStream;

public class InitializeDB {

    private DataSource dataSource;

    private TermsRepository termsRepository;

    public InitializeDB(DataSource dataSource, TermsRepository termsRepository) {
        this.dataSource = dataSource;
        this.termsRepository = termsRepository;
    }

    @PostConstruct
    private void init() {

        if (termsRepository.count() == 0)
            fillTables();

    }

    private void fillTables() {

        InputStream script = InitializeDB.class.getResourceAsStream("script.sql");

//        ScriptUtils
//        InputStreamResource

    }

}
