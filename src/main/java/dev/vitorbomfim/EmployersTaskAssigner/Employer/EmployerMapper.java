package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.stereotype.Component;

@Component
public class EmployerMapper {

    public EmployerModel map(EmployerDTO employerDTO){

        EmployerModel employerModel = new EmployerModel();

        employerModel.setId(employerDTO.getId());
        employerModel.setName(employerDTO.getName());
        employerModel.setDocument(employerDTO.getDocument());
        employerModel.setImgUrl(employerDTO.getImgUrl());
        employerModel.setFunction(employerDTO.getFunction());
        employerModel.setTask(employerDTO.getTask());

        return employerModel;

    }

    public EmployerDTO map(EmployerModel employerModel){

        EmployerDTO employerDTO = new EmployerDTO();

        employerDTO.setId(employerModel.getId());
        employerDTO.setName(employerModel.getName());
        employerDTO.setDocument(employerModel.getDocument());
        employerDTO.setImgUrl(employerModel.getImgUrl());
        employerDTO.setFunction(employerModel.getFunction());
        employerDTO.setTask(employerModel.getTask());

        return employerDTO;
    }

}
