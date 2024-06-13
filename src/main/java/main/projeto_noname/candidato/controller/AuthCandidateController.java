package main.projeto_noname.candidato.controller;

import main.projeto_noname.candidato.dto.AuthCandidateDto;
import main.projeto_noname.candidato.service.AuthCandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {
    private final AuthCandidateService service;
    public AuthCandidateController(AuthCandidateService service) {
        this.service = service;
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> ok(@RequestBody AuthCandidateDto authCandidateDto) throws AuthenticationException {
           try{
               var token = this.service.excute(authCandidateDto);
               return ResponseEntity.ok().body(token);
           }catch (Exception e){
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
           }

        }
}
