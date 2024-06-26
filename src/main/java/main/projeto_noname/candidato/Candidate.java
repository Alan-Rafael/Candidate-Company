package main.projeto_noname.candidato;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String username;

    @Email(message = "O campo (Email) deve conter um e-mail válido")
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve conter entre (8) a (100) caracters")
    private String password;

    private String description;
    private String curriculum;


}
