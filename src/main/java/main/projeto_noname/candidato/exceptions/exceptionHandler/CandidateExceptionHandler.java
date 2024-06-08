package main.projeto_noname.candidato.exceptions.exceptionHandler;

import main.projeto_noname.candidato.exceptions.exceptionNotValid.ErrorMessageDto;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CandidateExceptionHandler {
    private final MessageSource messageSource;
    public CandidateExceptionHandler(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDto>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErrorMessageDto>dto = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(err ->{
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDto error = new ErrorMessageDto(message, err.getField());
            dto.add(error);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CandidateNotFoundException.class)
    private ResponseEntity<RestErrorMessage> memberNotFountHandler(CandidateNotFoundException exception){
        RestErrorMessage responseError = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(CandidateJaExiste.class)
    private ResponseEntity<RestErrorMessage> candidateJaExiste(CandidateJaExiste exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }
}
