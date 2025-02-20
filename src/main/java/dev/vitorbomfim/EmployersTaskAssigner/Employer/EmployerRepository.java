package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<EmployerModel, Long> {
}
