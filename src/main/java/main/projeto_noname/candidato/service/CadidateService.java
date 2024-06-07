package main.projeto_noname.candidato.service;


import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.exceptions.CandidateJaExiste;
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
        var candidateExist = this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail());

        var cand = new Candidate(
                null, candidate.getName(),
                candidate.getUsername(), candidate.getEmail(),
                candidate.getPassword(), candidate.getDescription(),
                candidate.getCurriculum()
        );

        if(candidateExist != null){
            throw new CandidateJaExiste();
        }
        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.save(cand));

    }
}
