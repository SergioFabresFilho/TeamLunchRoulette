package br.com.sergio.teste.d3.teamlunchroulette.service;

import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByEmail(String username);
    UserDTO getUserByPublicId(String userId);
    void deleteUser(String userId);
}
