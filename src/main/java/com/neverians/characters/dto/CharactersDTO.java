package com.neverians.characters.dto;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.neverians.characters.entities.Characters;
import org.springframework.beans.BeanUtils;

public class CharactersDTO {

    private Long id;
    private String name;
    private Integer age;
    private String race;
    private String kinship;
    private String abilities;
    private String shortDescription;
    private String longDescription;
    private String img;

    public CharactersDTO(Characters entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
