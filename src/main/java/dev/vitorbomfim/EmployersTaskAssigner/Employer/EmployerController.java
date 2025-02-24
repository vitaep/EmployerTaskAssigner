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
    public EmployerModel addEmployer(@RequestBody EmployerModel employerModel){
        return employerService.addEmployer(employerModel);
    }

    // Get all employers (READ)

    @GetMapping("/get")
    public List<EmployerModel> getEmployer(){
        return employerService.getEmployers();
    }

    // Search employer by id (READ)

    @GetMapping("/get/{id}")
    public EmployerModel getEmployerById(@PathVariable Long id){
            return employerService.listEmployerById(id);
    }

    // Update employer data (UPDATE)

    @PutMapping("/update/{id}")
    public EmployerModel updateEmployer(@PathVariable Long id, @RequestBody EmployerModel employerModel){
        return employerService.updateEmployer(id, employerModel);
    }

    // Delete employer (DELETE)

    @DeleteMapping("/delete/{id}")
    public void deleteEmployerById(@PathVariable Long id){
        employerService.deleteEmployerById(id);
    }

}
