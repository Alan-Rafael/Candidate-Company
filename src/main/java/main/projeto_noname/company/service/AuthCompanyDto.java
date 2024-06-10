package main.projeto_noname.company.service;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDto {
    private String name;
    private String password;
}
