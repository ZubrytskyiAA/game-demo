package com.example.gamedemo.service;

import com.example.gamedemo.dao.PlanetRepository;
import com.example.gamedemo.entity.Planet;
import com.example.gamedemo.entity.PlanetType;
import com.example.gamedemo.service.interfaces.PlanetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanetServiceImpl implements PlanetService {


    @Autowired
    PlanetRepository planetRepository;

    @Override
    public Planet addNewPlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public boolean removePlanet(long id) {
        try {
            Planet planet = planetRepository.getPlanetById(id);
            planetRepository.delete(planet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Planet> getAllPlanetsByPlanetType(PlanetType planetType) {
        return planetRepository.getPlanetByPlanetType(planetType);
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public Planet getPlanetByName(String name) {
        return planetRepository.getPlanetByName(name);
    }

    @Override
    public Planet getPlanetById(long id) {
        return planetRepository.getPlanetById(id);
    }

    @Override
    public void updatePlanet(long id, Map<String, String> mapWithProps) {
        Planet planetToUpdate = getPlanetById(id);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "name":
                        planetToUpdate.setName(entry.getValue());
                        break;
                    case "temperature":
                        planetToUpdate.setTemperature(Integer.parseInt(entry.getValue()));
                        break;
                    case "planet_type":
                        planetToUpdate.setPlanetType(PlanetType.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        planetRepository.save(planetToUpdate);
    }
}
