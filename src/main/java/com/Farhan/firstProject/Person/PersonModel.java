package com.Farhan.firstProject.Person;

import java.util.Date;

public class PersonModel {

    private Long personID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role role;
    private Date enrollmentDate;  // Only applicable for students
    private Date hireDate;  // Only applicable for teachers
    private Long ProgramID;

    // Constructor with all fields
    public PersonModel(Long personID, String firstName, String lastName, String email, String phoneNumber, Role role, Date enrollmentDate, Date hireDate, Long ProgramID) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.enrollmentDate = enrollmentDate;
        this.hireDate = hireDate;
        this.ProgramID = ProgramID;
    }

    // Getters and Setters
    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Long getProgramID() {
        return ProgramID;
    }

    public void setProgramID(Long programID) {
        this.ProgramID = programID;
    }

    // Enum for Role
    public enum Role {
        STUDENT,
        TEACHER
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", enrollmentDate=" + enrollmentDate +
                ", hireDate=" + hireDate +
                ", ProgramID=" + ProgramID +
                '}';
    }
}