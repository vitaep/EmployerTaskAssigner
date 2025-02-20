package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployerController {

    @GetMapping("/employeeRegister")
    public String helloWorld() {
        return "Hello World";
    }

}
