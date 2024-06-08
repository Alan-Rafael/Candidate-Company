package main.projeto_noname.company.repositories;

import main.projeto_noname.candidato.Candidate;
import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateNotFoundException;
import main.projeto_noname.company.enitys.CompanyEnity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEnity, UUID> {
    Optional<CompanyEnity>findByUsernameOrEmail(String username, String email);

}
