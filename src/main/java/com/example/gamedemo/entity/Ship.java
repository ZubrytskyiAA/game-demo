package com.example.gamedemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Ship {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @Column(name = "attack", nullable = false)
    private double attack;
    @Column(name = "speed", nullable = false)
    private double speed;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @Enumerated(EnumType.ORDINAL)
    private ArmorType armorType;
    private double fuelCosts;
    private double capacity;


    public Ship() {
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

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public double getFuelCosts() {
        return fuelCosts;
    }

    public void setFuelCosts(double fuelCosts) {
        this.fuelCosts = fuelCosts;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
