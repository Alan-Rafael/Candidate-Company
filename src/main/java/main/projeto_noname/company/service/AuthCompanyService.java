package main.projeto_noname.company.service;

import main.projeto_noname.company.exceptions.CompanyNotFound;
import main.projeto_noname.company.repositories.CompanyRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthCompanyService(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(AuthCompanyDto authCompanyDto) throws AuthenticationException{
        var company = this.companyRepository.findByUsername(authCompanyDto.getName()).orElseThrow(
                CompanyNotFound::new
        );
        var passwordMatches = this.passwordEncoder.matches(authCompanyDto.getPassword(), company.getPassword());
        if(!passwordMatches){
            throw new AuthenticationException();
        }else{

        }
    }
}
