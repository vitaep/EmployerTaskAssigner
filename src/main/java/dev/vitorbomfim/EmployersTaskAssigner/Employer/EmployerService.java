package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import dev.vitorbomfim.EmployersTaskAssigner.Task.TaskModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    private EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
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

    public EmployerModel addEmployer(EmployerModel model){
        return employerRepository.save(model);
    }

}
