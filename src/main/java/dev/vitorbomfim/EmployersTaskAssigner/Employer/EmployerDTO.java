package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import dev.vitorbomfim.EmployersTaskAssigner.Task.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDTO {

    private Long id;
    private String name;
    private String document;
    private String imgUrl;
    private String function;
    private TaskModel task;

}
