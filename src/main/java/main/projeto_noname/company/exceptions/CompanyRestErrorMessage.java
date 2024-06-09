package main.projeto_noname.company.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class CompanyRestErrorMessage {
    private HttpStatus status;
    private String message;
}
