package main.projeto_noname;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Gestao de Vagas",
                description = "API responsevel pela gestão de vagas"
        )
)

public class ProjetoNoNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoNoNameApplication.class, args);
    }

}
