package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<EmployerModel, Long> {
    @Query("SELECT e FROM EmployerModel e WHERE e.task.id = :taskId")
    Optional<EmployerModel> findEmployerByTaskId(long taskId);

    @Query("SELECT COUNT(e) > 0 FROM EmployerModel e WHERE e.task.id = :taskId")
    boolean existsByTaskId(@Param("taskId") Long taskId);

}
