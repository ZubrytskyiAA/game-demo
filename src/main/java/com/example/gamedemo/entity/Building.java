package com.example.gamedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private long id;

    private String name;


    private int level = 0;
    @Column(nullable = true)
    private double metalCost = 0;
    @Column(nullable = true)
    private double mineralCost = 0;
    @Column(nullable = true)
    private double gazCost = 0;
    @Column(nullable = true)
    private double energyCost = 0;

    public Building() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMetalCost() {
        return metalCost;
    }

    public void setMetalCost(double metalCost) {
        this.metalCost = metalCost;
    }

    public double getMineralCost() {
        return mineralCost;
    }

    public void setMineralCost(double mineralCost) {
        this.mineralCost = mineralCost;
    }

    public double getGazCost() {
        return gazCost;
    }

    public void setGazCost(double gazCost) {
        this.gazCost = gazCost;
    }

    public double getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(double energyCost) {
        this.energyCost = energyCost;
    }
}
