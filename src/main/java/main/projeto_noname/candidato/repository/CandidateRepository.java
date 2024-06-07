package main.projeto_noname.candidato.repository;

import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.exceptions.CandidateNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    Candidate findByUsernameOrEmail(String username, String email) throws CandidateNotFoundException;

}
