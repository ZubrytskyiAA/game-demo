package com.example.gamedemo.controller;

import com.example.gamedemo.entity.Planet;
import com.example.gamedemo.service.interfaces.PlanetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/planet")
public class PlanetController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PlanetService planetService;


    @RequestMapping(method = RequestMethod.GET)
    public String getPlanetById(@RequestParam("id") long id) throws JsonProcessingException {
        Planet planetById = planetService.getPlanetById(id);
        return mapper.writeValueAsString(planetById);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewPlanet(@RequestBody JsonNode newPlanet) throws JsonProcessingException {
        Planet planet = mapper.treeToValue(newPlanet, Planet.class);
        if (planetService.addNewPlanet(planet) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removePlanet(@PathVariable("id") long id) {
        planetService.removePlanet(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updatePlanet(@PathVariable("id") long id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Map<String, String> mapWithProps = mapper.treeToValue(detailsToUpdate, Map.class);

        planetService.updatePlanet(id, mapWithProps);
    }


}
