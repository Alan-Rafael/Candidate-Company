package main.projeto_noname.company.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import main.projeto_noname.company.exceptions.CompanyNotFound;
import main.projeto_noname.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyService {

    @Value("${security.token.secret}")
    private String secretKey;

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthCompanyService(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String execute(AuthCompanyDto authCompanyDto) throws AuthenticationException{
        var company = this.companyRepository.findByUsername(authCompanyDto.getName()).orElseThrow(
                CompanyNotFound::new
        );
        var passwordMatches = this.passwordEncoder.matches(authCompanyDto.getPassword(), company.getPassword());
        if(!passwordMatches){
            throw new AuthenticationException();
        }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("javavagas")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(company.getId()
                        .toString())
                .sign(algorithm);
        return token;
    }
}
