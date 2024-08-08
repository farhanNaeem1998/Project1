package com.Farhan.firstProject.Program;

public class ProgramModel {

    private Long programID;
    private String programName;
    private String programDescription;
    private String department;

    public ProgramModel() {}

    public ProgramModel(Long programID, String programName, String programDescription, String department) {
        this.programID = programID;
        this.programName = programName;
        this.programDescription = programDescription;
        this.department = department;
    }

    public Long getProgramID() {
        return programID;
    }

    public void setProgramID(Long programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ProgramModel{" +
                "programID=" + programID +
                ", programName='" + programName + '\'' +
                ", programDescription='" + programDescription + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}