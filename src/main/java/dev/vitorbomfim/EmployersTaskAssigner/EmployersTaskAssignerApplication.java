package dev.vitorbomfim.EmployersTaskAssigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "dev.vitorbomfim.EmployersTaskAssigner")
public class EmployersTaskAssignerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployersTaskAssignerApplication.class, args);
	}

}
