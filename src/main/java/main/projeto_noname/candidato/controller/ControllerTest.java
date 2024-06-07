package main.projeto_noname.candidato.controller;

import jakarta.validation.Valid;
import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.service.CadidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class ControllerTest {

    private final CadidateService candidateService;

    public ControllerTest(CadidateService candidateService) {
        this.candidateService = candidateService;
    }


    @PostMapping()
    public ResponseEntity<Candidate> insert (@RequestBody @Valid Candidate candidate){
        return candidateService.saveCadidate(candidate);
    }


}
