package main.projeto_noname.candidato.service;


import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateJaExiste;
import main.projeto_noname.candidato.repository.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadidateService {
    private final CandidateRepository candidateRepository;
    public CadidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public ResponseEntity<Candidate> saveCadidate(Candidate candidate){
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) ->{
                    throw new CandidateJaExiste();
                });

        var cand = new Candidate(
                null, candidate.getName(),
                candidate.getUsername(), candidate.getEmail(),
                candidate.getPassword(), candidate.getDescription(),
                candidate.getCurriculum()
        );

        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.save(cand));

    }
}
