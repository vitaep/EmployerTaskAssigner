package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import dev.vitorbomfim.EmployersTaskAssigner.Task.TaskModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployerService {

    private EmployerMapper employerMapper;
    private EmployerRepository employerRepository;

    public EmployerService(EmployerMapper employerMapper, EmployerRepository employerRepository) {
        this.employerMapper = employerMapper;
        this.employerRepository = employerRepository;
    }

    // List all employers
    public List<EmployerDTO> getEmployers() {
        List<EmployerModel> employer = employerRepository.findAll();
        return employer.stream().map(employerMapper::map).collect(Collectors.toList());
    }

    // List ninja by id
    public EmployerDTO listEmployerById(Long id){
        Optional<EmployerModel> employerById = employerRepository.findById(id);
        return employerById.map(employerMapper::map).orElse(null);
    }


    // Add employer
    public EmployerDTO addEmployer(EmployerDTO employerDTO){
        EmployerModel employer = employerMapper.map(employerDTO);
        employer = employerRepository.save(employer);
        return employerMapper.map(employer);
    }

    // Delete employer
    public void deleteEmployerById(Long id){
            employerRepository.deleteById(id);
    }

    // Update employer
    public EmployerDTO updateEmployer(Long id, EmployerDTO employerDTO){
        Optional<EmployerModel> oldNinja = employerRepository.findById(id);
            if(oldNinja.isPresent()){
                EmployerModel updatedEmployer = employerMapper.map(employerDTO);
                updatedEmployer.setId(id);
                EmployerModel savedEmployer = employerRepository.save(updatedEmployer);
                return employerMapper.map(savedEmployer);

            }
        return null;
    }


}
