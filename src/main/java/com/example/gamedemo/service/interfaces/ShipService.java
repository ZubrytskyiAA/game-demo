package com.example.gamedemo.service.interfaces;

import com.example.gamedemo.entity.Ship;
import com.example.gamedemo.entity.Size;

import java.util.List;
import java.util.Map;

public interface ShipService {
    Ship addNewShip(Ship ship);

    boolean removeShip(long id);


    List<Ship> getAllShipsBySize(Size size);

    List<Ship> getAllShips();

    Ship getShipByName(String name);

    Ship getShipById(long id);

    void updateShip(long id, Map<String, String> mapWithProps);


}
