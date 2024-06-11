package main.projeto_noname.company.controller;


import main.projeto_noname.company.service.AuthCompanyDto;
import main.projeto_noname.company.service.AuthCompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    private final AuthCompanyService authCompanyService;

    public AuthCompanyController(AuthCompanyService authCompanyService) {
        this.authCompanyService = authCompanyService;
    }

    @PostMapping("/company")
    public String create(@RequestBody AuthCompanyDto authCompanyDto) throws AuthenticationException {
        return this.authCompanyService.execute(authCompanyDto);
    }
}
