package br.com.sergio.teste.d3.teamlunchroulette.service.impl;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.RestaurantEntity;
import br.com.sergio.teste.d3.teamlunchroulette.io.entity.TeamEntity;
import br.com.sergio.teste.d3.teamlunchroulette.io.repository.RestaurantRepository;
import br.com.sergio.teste.d3.teamlunchroulette.io.repository.TeamRepository;
import br.com.sergio.teste.d3.teamlunchroulette.service.RestaurantService;
import br.com.sergio.teste.d3.teamlunchroulette.shared.Utils;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.RestaurantDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    Utils utils;



    @Override
    public void deleteRestaurant(String publicId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findByPublicId(publicId);

        if (restaurantEntity == null) {
            throw new RuntimeException("Restaurant not found");
        }

        restaurantRepository.delete(restaurantEntity);
    }
}
