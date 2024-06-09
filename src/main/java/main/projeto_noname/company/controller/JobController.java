package main.projeto_noname.company.controller;

import jakarta.validation.Valid;
import main.projeto_noname.company.enitys.JobEntity;
import main.projeto_noname.company.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobEntity> addJob(@Valid @RequestBody JobEntity jobEntity){
        return ResponseEntity.status(HttpStatus.OK).body(this.jobService.execute(jobEntity));
    }
}
