package main.projeto_noname.candidato.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.dto.CandidateResponseDto;
import main.projeto_noname.candidato.service.CadidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CadidateService candidateService;

    public CandidateController(CadidateService candidateService) {
        this.candidateService = candidateService;
    }


    @PostMapping()
    public ResponseEntity<Candidate> insert (@RequestBody @Valid Candidate candidate){
        return candidateService.saveCadidate(candidate);
    }
    @GetMapping()
    public ResponseEntity<Object> get(HttpServletRequest request){
        var idCandidate =request.getAttribute("candidate_id");
        try {
            var profile = this.candidateService
                    .getCandidate(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }


}
