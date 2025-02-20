package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "document")
    private String document;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "function")
    private String function;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskModel task;

}
