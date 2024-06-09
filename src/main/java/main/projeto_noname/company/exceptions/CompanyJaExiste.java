package main.projeto_noname.company.exceptions;

public class CompanyJaExiste extends RuntimeException{
    public CompanyJaExiste(){super("Company já existe");}
}
