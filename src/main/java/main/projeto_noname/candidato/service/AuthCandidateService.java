package main.projeto_noname.candidato.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import main.projeto_noname.candidato.dto.AuthCandidateDto;
import main.projeto_noname.candidato.dto.AuthCandidateResponseDto;
import main.projeto_noname.candidato.exceptions.exceptionHandler.CandidateNotFoundException;
import main.projeto_noname.candidato.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCandidateService {

    private final CandidateRepository candidateRepository;

    private final PasswordEncoder passwordEncoder;


    @Value("${security.token.secret.candidate}")
    private String secretKey;


    public AuthCandidateService(CandidateRepository candidateRepository, PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public AuthCandidateResponseDto excute(AuthCandidateDto authCandidateDto) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidateDto.username())
                .orElseThrow(()->{
                    throw new CandidateNotFoundException();
                });

        var passwordMatches = this.passwordEncoder
                .matches(authCandidateDto.password(), candidate.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
                .withIssuer("javavagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", Arrays.asList("candidate"))
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
                .sign(algorithm);
        var authCandidate = AuthCandidateResponseDto.builder()
                .acess_token(token)
                .build();
        return authCandidate;
    }
}
