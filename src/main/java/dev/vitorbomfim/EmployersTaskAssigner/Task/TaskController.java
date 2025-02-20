package dev.vitorbomfim.EmployersTaskAssigner.Task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    @GetMapping("/taskRegister")
    public String helloWorld() {
        return "Hello World";
    }

}
