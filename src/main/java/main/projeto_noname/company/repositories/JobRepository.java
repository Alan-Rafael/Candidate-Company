package main.projeto_noname.company.repositories;

import main.projeto_noname.company.enitys.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
