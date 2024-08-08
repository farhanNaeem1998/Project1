package com.Farhan.firstProject.Program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ProgramDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProgramDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_PROGRAM_SQL =
            "INSERT INTO Program (ProgramName, ProgramDescription, Department) VALUES (?, ?, ?)";

    public Long addProgram(ProgramModel program){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_PROGRAM_SQL, new String[]{"ProgramID"});
                ps.setString(1, program.getProgramName());
                ps.setString(2, program.getProgramDescription());
                ps.setString(3, program.getDepartment());
                return ps;
            }

        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

}
