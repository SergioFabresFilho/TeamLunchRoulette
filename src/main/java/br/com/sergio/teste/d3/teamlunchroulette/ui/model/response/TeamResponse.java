package br.com.sergio.teste.d3.teamlunchroulette.ui.model.response;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.RestaurantEntity;

import java.util.List;

public class TeamResponse {

    private String publicId;
    private String name;
    private List<UserResponse> members;
    private List<RestaurantEntity> restaurants;

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserResponse> getMembers() {
        return members;
    }

    public void setMembers(List<UserResponse> members) {
        this.members = members;
    }

    public List<RestaurantEntity> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantEntity> restaurants) {
        this.restaurants = restaurants;
    }
}
