package main.projeto_noname.candidato.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponseDto {
    private UUID id;
    private String name;
    private String username;
    private String email;

}
