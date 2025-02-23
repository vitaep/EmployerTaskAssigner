package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployerController {

    @GetMapping("/employeeRegister")
    public String helloWorld() {
        return "Hello World";
    }

    // Add employer (CREATE)

    @PostMapping("/add")
    public String addEmployer(){
        return "Employer added";
    }

    // Get all employers (READ)

    @GetMapping("/get")
    public String getEmployer(){
        return "Employers";
    }

    // Search employer by id (READ)

    @GetMapping("/getId")
    public String getEmployerById(){
        return "Employers by id";
    }

    // Update employer data (UPDATE)

    @PutMapping("/updateEmployer")
    public String updateEmployer(){
        return "Employer updated";
    }

    // Delete employer (DELETE)

    @DeleteMapping("/deleteId")
    public String deleteEmployerById(){
        return "Employer deleted by id";
    }

}
