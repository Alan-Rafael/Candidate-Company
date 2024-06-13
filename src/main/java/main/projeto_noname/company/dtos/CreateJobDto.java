package main.projeto_noname.company.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDto {
    @NotBlank
    private String description;
    @NotBlank
    private String benefics;
    @NotBlank
    private String level;

}
