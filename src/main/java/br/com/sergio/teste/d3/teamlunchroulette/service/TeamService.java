package br.com.sergio.teste.d3.teamlunchroulette.service;

import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.TeamDTO;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;

public interface TeamService {
    TeamDTO createTeam(TeamDTO teamDTO);
    TeamDTO getTeamById(String publicId);
    TeamDTO addMember(UserDTO userDTO, String teamId);
    void deleteTeam(String publicId);
}
