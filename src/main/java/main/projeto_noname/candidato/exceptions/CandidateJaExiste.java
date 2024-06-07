package main.projeto_noname.candidato.exceptions;

public class CandidateJaExiste extends RuntimeException{
    public CandidateJaExiste(){
        super("Usuario já cadastrado");
    }
}
