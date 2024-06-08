package main.projeto_noname.company.service;


import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateNotFoundException;
import main.projeto_noname.company.enitys.CompanyEnity;
import main.projeto_noname.company.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {


    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyEnity saveCompany(CompanyEnity companyEnity){
       this.companyRepository
               .findByUsernameOrEmail(companyEnity.getUsername(), companyEnity.getEmail())
               .ifPresent((user) -> {
                   throw  new CandidateNotFoundException();
               });
       return this.companyRepository.save(companyEnity);

    }

}
