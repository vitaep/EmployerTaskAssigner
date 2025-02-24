package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import dev.vitorbomfim.EmployersTaskAssigner.Task.TaskModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    private EmployerMapper employerMapper;
    private EmployerRepository employerRepository;

    public EmployerService(EmployerMapper employerMapper, EmployerRepository employerRepository) {
        this.employerMapper = employerMapper;
        this.employerRepository = employerRepository;
    }

    // List all employers
    public List<EmployerModel> getEmployers() {
        return employerRepository.findAll();
    }

    // List ninja by id
    public EmployerModel listEmployerById(Long id){
        Optional<EmployerModel> employerById = employerRepository.findById(id);
        return employerById.orElse(null);
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
    public EmployerModel updateEmployer(Long id, EmployerModel updatedEmployer){
        if (employerRepository.existsById(id)) {
            updatedEmployer.setId(id);
            return employerRepository.save(updatedEmployer);
        }
        return null;
    }


}
