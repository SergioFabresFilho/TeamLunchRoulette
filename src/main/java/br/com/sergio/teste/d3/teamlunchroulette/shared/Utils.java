package br.com.sergio.teste.d3.teamlunchroulette.shared;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.RestaurantEntity;
import br.com.sergio.teste.d3.teamlunchroulette.service.UserService;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.RestaurantDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.TeamDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxys";

    @Autowired
    UserService userService;

    public String generatePublicId(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public UserDTO getAuthenticatedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        return userService.getUserByEmail(email);
    }

    public RestaurantDTO getRandomRestaurant(TeamDTO teamDTO) {
        List<RestaurantEntity> restaurants = teamDTO.getRestaurants();
        RestaurantEntity restaurantEntity = restaurants.get(RANDOM.nextInt(restaurants.size()));

        RestaurantDTO returnValue = new RestaurantDTO();
        BeanUtils.copyProperties(restaurantEntity, returnValue);

        return returnValue;
    }
}
