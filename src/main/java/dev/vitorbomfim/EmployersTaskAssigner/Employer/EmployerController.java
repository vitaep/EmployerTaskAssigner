package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employer")
public class EmployerController {

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

    @PutMapping("/update")
    public String updateEmployer(){
        return "Employer updated";
    }

    // Delete employer (DELETE)

    @DeleteMapping("/deleteId")
    public String deleteEmployerById(){
        return "Employer deleted by id";
    }

}
