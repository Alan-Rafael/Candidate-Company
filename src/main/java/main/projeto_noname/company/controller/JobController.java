package main.projeto_noname.company.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import main.projeto_noname.company.dtos.CreateJobDto;
import main.projeto_noname.company.enitys.JobEntity;
import main.projeto_noname.company.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobEntity addJob(@Valid @RequestBody CreateJobDto createJobDto, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

        var job = JobEntity.builder()
                .benefits(createJobDto.getBenefics())
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDto.getDescription())
                .level(createJobDto.getLevel())
                .build();

        return this.jobService.execute(job);
    }
}
