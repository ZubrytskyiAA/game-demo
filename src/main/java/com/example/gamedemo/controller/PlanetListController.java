package com.example.gamedemo.controller;


import com.example.gamedemo.entity.PlanetType;
import com.example.gamedemo.service.interfaces.PlanetService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/planets")
public class PlanetListController {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private PlanetService planetService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllPlanets(@RequestParam("planetType") Optional<String> planets) {
        PlanetType planetType = PlanetType.valueOf(planets.orElse("GAZ"));
        return mapper.valueToTree(planetService.getAllPlanetsByPlanetType(planetType));
    }

}


