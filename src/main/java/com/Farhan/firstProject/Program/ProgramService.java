package com.Farhan.firstProject.Program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {

    ProgramDAO programDAO;

    @Autowired
    public ProgramService(ProgramDAO programDAO) {
        this.programDAO = programDAO;
    }

    public Long addProgram(ProgramModel program){
        return programDAO.addProgram(program);
    }

}
