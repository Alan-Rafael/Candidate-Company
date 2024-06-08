package main.projeto_noname.candidato.exceptions.exceptionNotValid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDto {
    private String message;
    private String field;
}
