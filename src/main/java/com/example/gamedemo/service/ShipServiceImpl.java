package com.example.gamedemo.service;

import com.example.gamedemo.dao.ShipRepository;
import com.example.gamedemo.entity.ArmorType;
import com.example.gamedemo.entity.Ship;
import com.example.gamedemo.entity.Size;
import com.example.gamedemo.service.interfaces.ShipService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    ShipRepository shipRepository;

    @Override
    public Ship addNewShip(Ship ship) {
        return shipRepository.save(ship);
    }

    @Override
    public boolean removeShip(long id) {
        try {
            Ship ship = shipRepository.getShipById(id);
            shipRepository.delete(ship);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Ship> getAllShipsBySize(Size size) {
        return shipRepository.getShipBySize(size);
    }

    @Override
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    @Override
    public Ship getShipByName(String name) {
        return shipRepository.getShipByName(name);
    }


    @Override
    public Ship getShipById(long id) {
        return shipRepository.getShipById(id);
    }

    @Override
    public void updateShip(long id, Map<String, String> mapWithProps) {
        Ship shipToUpdate = getShipById(id);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "name":
                        shipToUpdate.setName(entry.getValue());
                        break;
                    case "attack":
                        shipToUpdate.setAttack(Double.parseDouble(entry.getValue()));
                        break;
                    case "speed":
                        shipToUpdate.setSpeed(Double.parseDouble(entry.getValue()));
                        break;
                    case "armor_type":
                        shipToUpdate.setArmorType(ArmorType.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        shipRepository.save(shipToUpdate);
    }
}
