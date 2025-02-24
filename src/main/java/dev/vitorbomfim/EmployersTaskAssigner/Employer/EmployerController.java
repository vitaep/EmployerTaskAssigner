package dev.vitorbomfim.EmployersTaskAssigner.Employer;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    //DEPENDENCIES INJECTION

    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

// Add employer (CREATE)

    @PostMapping("/post")
    public ResponseEntity<String> addEmployer(@RequestBody EmployerDTO employerDTO){
      EmployerDTO employerDT = employerService.addEmployer(employerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The employer: " + employerDT.getName() + " has beed added with sucess, with ID: " + employerDT.getId());
    }

    // Get all employers (READ)

    @GetMapping("/get")
    public ResponseEntity<List<EmployerDTO>> getEmployer(){
        List<EmployerDTO> getEmployer = employerService.getEmployers();
        return ResponseEntity.ok(getEmployer);
    }

    // Search employer by id (READ)

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployerById(@PathVariable Long id){
            EmployerDTO employerDTO = employerService.listEmployerById(id);

            if (employerDTO != null) {
                return ResponseEntity.ok(employerDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ERROR! The Employer with ID: " + id + " has not found.");
            }
    }

    // Update employer data (UPDATE)

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployer(@PathVariable Long id, @RequestBody EmployerDTO employerUpdated){
        EmployerDTO employerDTO = employerService.updateEmployer(id, employerUpdated);

        if (employerDTO != null){
            return ResponseEntity.ok(employerDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ERROR! The Employer with ID: " + id + " has not been found.");
        }
    }

    // Delete employer (DELETE)

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployerById(@PathVariable Long id){

        if (employerService.listEmployerById(id) != null){
            employerService.deleteEmployerById(id);
            return ResponseEntity.ok()
                    .body("The Employer with ID: " + id + " deleted with success" );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ERROR! The Employer with ID: " + id + " has not been found");
        }

    }

}
