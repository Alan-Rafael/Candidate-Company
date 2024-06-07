package main.projeto_noname.candidato.exceptions;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(){
        super("Usuario nao encontrado");
    }
}
