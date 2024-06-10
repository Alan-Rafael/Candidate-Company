package main.projeto_noname.company.service;


import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateNotFoundException;
import main.projeto_noname.company.enitys.CompanyEnity;
import main.projeto_noname.company.repositories.CompanyRepository;
import main.projeto_noname.security.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {


    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    public CompanyService(CompanyRepository companyRepository, SecurityConfig securityConfig, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CompanyEnity saveCompany(CompanyEnity companyEnity){
       this.companyRepository
               .findByUsernameOrEmail(companyEnity.getUsername(), companyEnity.getEmail())
               .ifPresent((user) -> {
                   throw  new CandidateNotFoundException();
               });
       var password = passwordEncoder.encode(companyEnity.getPassword());
       companyEnity.setPassword(password);

       return this.companyRepository.save(companyEnity);

    }

}
