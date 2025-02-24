package dev.vitorbomfim.EmployersTaskAssigner.Task;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    // DEPENDENCIES INJECTION
    private TaskMapper taskMapper;
    private TaskRepository taskRepository;


    // List all tasks

    public List<TaskDTO> getTask(){
        List<TaskModel> taskModels = taskRepository.findAll();
        return taskModels.stream().map(taskMapper::map).collect(Collectors.toList());
    }

    // Get Task by ID
    public TaskDTO getTaskById(Long id){
        Optional<TaskModel> taskById = taskRepository.findById(id);
        return taskById.map(taskMapper::map).orElse(null);
    }

    // Add Task
    public TaskDTO addTask(TaskDTO taskDTO){
        TaskModel taskModel = taskMapper.map(taskDTO);
        taskModel = taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }

    // Delete Task

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    // Update Task
    public TaskDTO taskUpdate(Long id, TaskDTO taskDTO){
        Optional<TaskModel> taskOld = taskRepository.findById(id);
        if (taskOld.isPresent()){
            TaskModel taskUpdated = taskMapper.map(taskDTO);
            taskUpdated.setId(id);
            TaskModel newTask = taskRepository.save(taskUpdated);
            return taskMapper.map(newTask);
        }
        return null;
    }
}
