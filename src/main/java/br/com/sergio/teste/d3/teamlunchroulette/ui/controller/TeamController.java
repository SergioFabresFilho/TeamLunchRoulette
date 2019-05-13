package br.com.sergio.teste.d3.teamlunchroulette.ui.controller;

import br.com.sergio.teste.d3.teamlunchroulette.service.TeamService;
import br.com.sergio.teste.d3.teamlunchroulette.service.UserService;
import br.com.sergio.teste.d3.teamlunchroulette.shared.Utils;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.RestaurantDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.TeamDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.request.RestaurantRequestModel;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.request.TeamRequestModel;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.response.RestaurantResponse;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.response.TeamResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    UserService userService;

    @Autowired
    Utils utils;

    @PostMapping
    public TeamResponse createTeam(@RequestBody TeamRequestModel requestModel) throws RuntimeException {
        TeamResponse returnValue = new TeamResponse();

        TeamDTO teamDTO = new TeamDTO();
        BeanUtils.copyProperties(requestModel, teamDTO);

        TeamDTO creaatedTeam = teamService.createTeam(teamDTO);
        BeanUtils.copyProperties(creaatedTeam, returnValue);

        return returnValue;
    }

    @PostMapping(path = "/{id}/members")
    public TeamResponse addUser(@PathVariable String id) {
        UserDTO authenticaterUser = utils.getAuthenticatedUser();
        TeamDTO teamDTO = teamService.addMember(authenticaterUser, id);

        TeamResponse returnValue = new TeamResponse();
        BeanUtils.copyProperties(teamDTO, returnValue);

        return returnValue;
    }

    @PostMapping(path = "/{id}/restaurants")
    public TeamResponse addRestaurant(@RequestBody RestaurantRequestModel requestModel, @PathVariable String id) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        BeanUtils.copyProperties(requestModel, restaurantDTO);

        TeamDTO teamDTO = teamService.addRestaurant(restaurantDTO, id);

        TeamResponse returnValue = new TeamResponse();
        BeanUtils.copyProperties(teamDTO, returnValue);

        return returnValue;
    }

    @GetMapping(path = "/{id}/restaurants")
    public RestaurantResponse getRandomRestaurant(@PathVariable String id) {
        TeamDTO teamDTO = teamService.getTeamById(id);
        RestaurantDTO restaurantDTO = utils.getRandomRestaurant(teamDTO);

        RestaurantResponse returnValue = new RestaurantResponse();
        BeanUtils.copyProperties(restaurantDTO, returnValue);

        return returnValue;
    }
}
