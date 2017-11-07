package com.example.gamedemo.service.interfaces;

import com.example.gamedemo.entity.Planet;
import com.example.gamedemo.entity.PlanetType;

import java.util.List;
import java.util.Map;

public interface PlanetService {

    Planet addNewPlanet(Planet planet);

    boolean removePlanet(long id);


    List<Planet> getAllPlanetsByPlanetType(PlanetType planetType);

    List<Planet> getAllPlanets();

    Planet getPlanetByName(String name);

    Planet getPlanetById(long id);

    void updatePlanet(long id, Map<String, String> mapWithProps);


}
