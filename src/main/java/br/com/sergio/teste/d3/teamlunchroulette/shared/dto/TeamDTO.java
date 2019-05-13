package br.com.sergio.teste.d3.teamlunchroulette.shared.dto;

import br.com.sergio.teste.d3.teamlunchroulette.io.entity.UserEntity;

import java.io.Serializable;
import java.util.List;

public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String publicId;
    private String name;
    private List<UserEntity> members;

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

    public List<UserEntity> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntity> members) {
        this.members = members;
    }
}
