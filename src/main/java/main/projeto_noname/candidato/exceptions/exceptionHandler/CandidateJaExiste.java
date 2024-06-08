package main.projeto_noname.candidato.exceptions.exceptionHandler;

public class CandidateJaExiste extends RuntimeException{
    public CandidateJaExiste(){
        super("Usuario já cadastrado");
    }
}
