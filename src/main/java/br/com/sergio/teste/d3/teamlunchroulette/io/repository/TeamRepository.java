package br.com.sergio.teste.d3.teamlunchroulette.io.repository;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
    TeamEntity findByName(String name);
    TeamEntity findByPublicId(String publicId);
}
