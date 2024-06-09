package main.projeto_noname.company.controller;


import jakarta.validation.Valid;
import main.projeto_noname.company.enitys.CompanyEnity;
import main.projeto_noname.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Object> addCompany(@Valid @RequestBody CompanyEnity companyEnity){
       try {
           var result = companyService.saveCompany(companyEnity);
           return ResponseEntity.ok().body(result);
       }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
