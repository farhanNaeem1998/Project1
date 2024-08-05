package com.Farhan.firstProject.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_OR_UPDATE_PERSON_SQL =
            "INSERT INTO person (FirstName, LastName, Email, PhoneNumber, Role, EnrollmentDate, HireDate, ProgramID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "FirstName = VALUES(FirstName), " +
                    "LastName = VALUES(LastName), " +
                    "Email = VALUES(Email), " +
                    "PhoneNumber = VALUES(PhoneNumber), " +
                    "Role = VALUES(Role), " +
                    "EnrollmentDate = VALUES(EnrollmentDate), " +
                    "HireDate = VALUES(HireDate), " +
                    "ProgramID = VALUES(ProgramID)";

    @Transactional
    public void addPerson(PersonModel person) {
        jdbcTemplate.update(INSERT_OR_UPDATE_PERSON_SQL,
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhoneNumber(),
                person.getRole().name(),
                person.getEnrollmentDate(),
                person.getHireDate(),
                person.getProgramID());
    }

    public List<PersonModel> getPerson() {
        return jdbcTemplate.query("SELECT * FROM person",
                (rs, rowNum) -> new PersonModel(
                        rs.getLong("PersonID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        PersonModel.Role.valueOf(StringUtils.upperCase(rs.getString("Role"))), // Convert string to enum
                        rs.getDate("EnrollmentDate"),
                        rs.getDate("HireDate"),
                        rs.getLong("ProgramID")
                ));
    }
    public boolean deletePerson(Long id){
        int result = jdbcTemplate.update("DELETE FROM person WHERE PersonID =?", id);
        return result == 1;
    }
}
