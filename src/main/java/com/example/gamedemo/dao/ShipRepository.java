package com.example.gamedemo.dao;

import com.example.gamedemo.entity.ArmorType;
import com.example.gamedemo.entity.Ship;
import com.example.gamedemo.entity.Size;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShipRepository extends CrudRepository<Ship, Long> {

    List<Ship> getShipBySize(Size size);

    List<Ship> getShipByArmorType(ArmorType armorType);

    Ship getShipById(long id);

    List<Ship> findAll();

    Ship save(Ship ship);

    void delete(Ship ship);

    Ship getShipByName(String name);
}
