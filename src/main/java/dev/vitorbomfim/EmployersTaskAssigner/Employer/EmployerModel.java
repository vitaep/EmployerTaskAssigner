package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import dev.vitorbomfim.EmployersTaskAssigner.Task.TaskModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_employer")
public class EmployerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //UNIQUE, BUT ADDED DIRECTLY TO DATABASE THIS CONFIG
    @Column(name = "document")
    private String document;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "function")
    private String function;

    @ManyToOne // um funcionário tem uma única tarefa.
    @JoinColumn(name = "task_id")
    private TaskModel task;

}
