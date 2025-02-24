package dev.vitorbomfim.EmployersTaskAssigner.Task;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel map(TaskDTO taskDTO){

        TaskModel taskModel = new TaskModel();

        taskModel.setId(taskDTO.getId());
        taskModel.setName(taskDTO.getName());

        return taskModel;

    }

    public TaskDTO map(TaskModel taskModel){

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(taskModel.getId());
        taskDTO.setName(taskModel.getName());

        return taskDTO;

    }

}
