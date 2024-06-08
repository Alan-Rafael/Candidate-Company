package main.projeto_noname.candidato.exceptions.exceptionHandler;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(){
        super("Usuario nao encontrado");
    }
}
