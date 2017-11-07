package com.example.gamedemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Planet {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private int galaxy;
    @NotNull
    private int system;
    @NotNull
    private int planet;
    @Enumerated(EnumType.ORDINAL)
    private PlanetType planetType;
    @NotNull
    private String name = "Colony";
    @NotNull
    private int temperature;
//    @Null
//    private User owner;


    public Planet() {
    }

    public Planet(int galaxy, int system, int planet, PlanetType planetType, String name, int temperature) {
        this.galaxy = galaxy;
        this.system = system;
        this.planet = planet;
        this.planetType = planetType;
        this.name = name;
    }


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(int galaxy) {
        this.galaxy = galaxy;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public int getPlanet() {
        return planet;
    }

    public void setPlanet(int planet) {
        this.planet = planet;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public void setPlanetType(PlanetType planetType) {
        this.planetType = planetType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
