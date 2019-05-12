package br.com.sergio.teste.d3.teamlunchroulette.ui.controller;

import br.com.sergio.teste.d3.teamlunchroulette.service.UserService;
import br.com.sergio.teste.d3.teamlunchroulette.shared.dto.UserDTO;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.request.UserRequestModel;
import br.com.sergio.teste.d3.teamlunchroulette.ui.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")   // localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid UserRequestModel requestModel) throws RuntimeException {
        UserResponse returnValue = new UserResponse();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(requestModel, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
