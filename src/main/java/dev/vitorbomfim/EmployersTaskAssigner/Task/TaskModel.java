package dev.vitorbomfim.EmployersTaskAssigner.Task;

import dev.vitorbomfim.EmployersTaskAssigner.Employer.EmployerModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "tb_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany // UMA TASK PRA VÁRIOS FUNCIONÁRIOS
    @Column(name = "task")
    List<EmployerModel> employers;

}
