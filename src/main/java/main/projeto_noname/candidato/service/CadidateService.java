package main.projeto_noname.candidato.service;


import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateJaExiste;
import main.projeto_noname.candidato.repository.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadidateService {
    private final CandidateRepository candidateRepository;

    private final PasswordEncoder passwordEncoder;

    public CadidateService(CandidateRepository candidateRepository, PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<Candidate> saveCadidate(Candidate candidate){
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) ->{
                    throw new CandidateJaExiste();
                });
        var password = passwordEncoder.encode(candidate.getPassword());
        candidate.setPassword(password);

        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.save(candidate));

    }
}
