package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    //DEPENDENCIES INJECTION

    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

// Add employer (CREATE)

    @PostMapping("/post")
    public EmployerDTO addEmployer(@RequestBody EmployerDTO employerDTO){
        return employerService.addEmployer(employerDTO);
    }

    // Get all employers (READ)

    @GetMapping("/get")
    public List<EmployerDTO> getEmployer(){
        return employerService.getEmployers();
    }

    // Search employer by id (READ)

    @GetMapping("/get/{id}")
    public EmployerDTO getEmployerById(@PathVariable Long id){
            return employerService.listEmployerById(id);
    }

    // Update employer data (UPDATE)

    @PutMapping("/update/{id}")
    public EmployerDTO updateEmployer(@PathVariable Long id, @RequestBody EmployerDTO employerDTO){
        return employerService.updateEmployer(id, employerDTO);
    }

    // Delete employer (DELETE)

    @DeleteMapping("/delete/{id}")
    public void deleteEmployerById(@PathVariable Long id){
        employerService.deleteEmployerById(id);
    }

}
