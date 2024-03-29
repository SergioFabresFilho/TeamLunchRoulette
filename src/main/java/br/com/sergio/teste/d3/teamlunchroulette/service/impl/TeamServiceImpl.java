package br.com.sergio.teste.d3.teamlunchroulette.service.impl;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.RestaurantEntity;
import br.com.sergio.teste.d3.teamlunchroulette.io.entity.TeamEntity;
import br.com.sergio.teste.d3.teamlunchroulette.io.entity.UserEntity;
import br.com.sergio.teste.d3.teamlunchroulette.io.repository.RestaurantRepository;
import br.com.sergio.teste.d3.teamlunchroulette.io.repository.TeamRepository;
import br.com.sergio.teste.d3.teamlunchroulette.service.TeamService;
import br.com.sergio.teste.d3.teamlunchroulette.shared.Utils;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.RestaurantDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.TeamDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    Utils utils;

    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        TeamEntity teamEntity = new TeamEntity();
        BeanUtils.copyProperties(teamDTO, teamEntity);

        String publicId = utils.generatePublicId(50);
        teamEntity.setPublicId(publicId);

        TeamEntity storedeTeamDetails = teamRepository.save(teamEntity);

        TeamDTO returnValue = new TeamDTO();
        BeanUtils.copyProperties(storedeTeamDetails, returnValue);

        return returnValue;
    }

    @Override
    public TeamDTO getTeamById(String publicId) {
        TeamEntity teamEntity = teamRepository.findByPublicId(publicId);

        if (teamEntity == null) {
            throw new RuntimeException("No teams found");
        }

        TeamDTO returnValue = new TeamDTO();
        BeanUtils.copyProperties(teamEntity, returnValue);

        return returnValue;
    }

    @Override
    public TeamDTO addMember(UserDTO userDTO, String teamId) {
        TeamEntity teamEntity = teamRepository.findByPublicId(teamId);
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);

        List<UserEntity> members = teamEntity.getMembers();
        members.add(userEntity);
        teamEntity.setMembers(members);

        TeamEntity storedTeam = teamRepository.save(teamEntity);

        TeamDTO returnValue = new TeamDTO();
        BeanUtils.copyProperties(storedTeam, returnValue);

        return returnValue;
    }

    @Override
    public TeamDTO addRestaurant(RestaurantDTO restaurantDTO, String teamId) {
        TeamEntity teamEntity = teamRepository.findByPublicId(teamId);
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setPublicId(utils.generatePublicId(50));

        BeanUtils.copyProperties(restaurantDTO, restaurantEntity);
        RestaurantEntity storedRestaurant = restaurantRepository.save(restaurantEntity);

        List<RestaurantEntity> restaurants = teamEntity.getRestaurants();
        restaurants.add(storedRestaurant);
        teamEntity.setRestaurants(restaurants);
        TeamEntity storedTeam = teamRepository.save(teamEntity);

        TeamDTO returnValue = new TeamDTO();
        BeanUtils.copyProperties(storedTeam, returnValue);

        return returnValue;
    }

    @Override
    public void deleteTeam(String publicId) {
        TeamEntity teamEntity = teamRepository.findByPublicId(publicId);

        if (teamEntity == null) {
            throw new RuntimeException("No teams found");
        }

        teamRepository.delete(teamEntity);
    }
}
