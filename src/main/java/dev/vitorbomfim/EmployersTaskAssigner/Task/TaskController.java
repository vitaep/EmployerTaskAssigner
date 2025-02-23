package dev.vitorbomfim.EmployersTaskAssigner.Task;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    // Add task (CREATE)

    @PostMapping("/add")
    public String addTask(){
        return "Task added";
    }

    // Get all tasks (READ)

    @GetMapping("/get")
    public String getTask(){
        return "Tasks";
    }

    // Search tasks by id (READ)

    @GetMapping("/getId")
    public String getTaskById(){
        return "Task by id";
    }

    // Update task data (UPDATE)

    @PutMapping("/update")
    public String updateTask(){
        return "Task updated";
    }

    // Delete task (DELETE)

    @DeleteMapping("/deleteId")
    public String deleteTaskById(){
        return "Task deleted by id";
    }


}
