package main.projeto_noname.company.enitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String  username;

    @NotBlank(message = "O campo (EMAIL) é obrigatorio")
    @Email(message = "O campo (Email) deve conter um e-mail válido")
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve conter entre (8) a (100) caracters")
    @NotBlank(message = "O campo (password) não pode ser nula")
    private String password;
    private String website;

    @NotBlank(message = "O campo (name) não pode ser nulo")
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
