package com.example.gamedemo.dao;

import com.example.gamedemo.entity.Planet;
import com.example.gamedemo.entity.PlanetType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanetRepository  extends CrudRepository<Planet, Long> {


    List<Planet> getPlanetByPlanetType(PlanetType planetType);

    Planet getPlanetById(long id);

    List<Planet> findAll();

    Planet save(Planet planet);

    void delete(Planet planet);

    Planet getPlanetByName(String name);
}
