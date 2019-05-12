package br.com.sergio.teste.d3.teamlunchroulette.io.repository;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByPublicId(String publicId);
}
