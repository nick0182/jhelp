package com.schaydulin.jhelp;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    private DataSource dataSource;

    public Test(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void init() throws SQLException {

        Connection connection = dataSource.getConnection();

    }

}
