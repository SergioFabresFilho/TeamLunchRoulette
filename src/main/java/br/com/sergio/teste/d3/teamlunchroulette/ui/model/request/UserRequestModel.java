package br.com.sergio.teste.d3.teamlunchroulette.ui.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRequestModel {

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
