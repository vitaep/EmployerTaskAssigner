package dev.vitorbomfim.EmployersTaskAssigner.Task;

import dev.vitorbomfim.EmployersTaskAssigner.Employer.EmployerDTO;
import dev.vitorbomfim.EmployersTaskAssigner.Employer.EmployerModel;
import dev.vitorbomfim.EmployersTaskAssigner.Employer.EmployerRepository;
import dev.vitorbomfim.EmployersTaskAssigner.Employer.EmployerService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployerService employerService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Add task (CREATE)

    @PostMapping("/post")
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskAdd){
        TaskDTO taskDTO = taskService.addTask(taskAdd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The task: " + taskDTO.getName() + " has been added with success in ID: " + taskDTO.getId());
    }

    // Get all tasks (READ)

    @GetMapping("/get")
    public ResponseEntity<List<TaskDTO>> getTask(){
        List<TaskDTO> taskDTO = taskService.getTask();
        return ResponseEntity.ok(taskDTO);
    }

    // Search tasks by id (READ)

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id){
        TaskDTO taskDTO = taskService.getTaskById(id);
        if (taskDTO != null){
            return ResponseEntity.ok(taskDTO);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ERROR! The task on ID: " + id + " does not exist.");
        }
    }

    // Update task data (UPDATE PUT)

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskDTO updatedTask){
        TaskDTO taskDTO = taskService.taskUpdate(id, updatedTask);
        if(taskDTO != null){
            return ResponseEntity.ok(taskDTO);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ERROR! The task on ID: " + id + " does not exist.");
        }
    }

    // Delete task (DELETE)

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {

        // VERIFY IF TASK EXISTS
        TaskDTO task = taskService.getTaskById(id);
        if (task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ERROR! The task on ID: " + id + " does not exist.");
        }

        //VERIFY IF THE TASK HAS ASSIGNER TO A EMPLOYER

            if (employerService.existByTaskId(id)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("ERROR! The task on ID: " + id + " is assigned to an employee. Please try again once they have completed the task.");
            }
                taskService.deleteTask(id);
                return ResponseEntity.ok("The task on ID:" + id + " is successful deleted.");
    }
}
