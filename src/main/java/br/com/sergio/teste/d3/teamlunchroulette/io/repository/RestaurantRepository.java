package br.com.sergio.teste.d3.teamlunchroulette.io.repository;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
    RestaurantEntity findByPublicId(String publicId);
    RestaurantEntity findByName(String name);
}
