package br.com.sergio.teste.d3.teamlunchroulette.shared.dto;

import java.io.Serializable;

public class RestaurantDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String publicId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
