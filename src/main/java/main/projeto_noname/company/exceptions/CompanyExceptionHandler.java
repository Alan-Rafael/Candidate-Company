package main.projeto_noname.company.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyExceptionHandler {


    @ExceptionHandler(CompanyNotFound.class)
    private ResponseEntity<CompanyRestErrorMessage> companyError(CompanyNotFound exception){
        CompanyRestErrorMessage restError = new CompanyRestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restError);
    }

    @ExceptionHandler(CompanyJaExiste.class)
    private ResponseEntity<CompanyRestErrorMessage> companyErrorExist(CompanyJaExiste exception){
        CompanyRestErrorMessage erro = new CompanyRestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
