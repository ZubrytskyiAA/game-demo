package com.example.gamedemo.controller;


import com.example.gamedemo.entity.Ship;
import com.example.gamedemo.service.interfaces.ShipService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/ship")
public class ShipController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ShipService shipService;



//    @RequestMapping(method = RequestMethod.GET)
//    public String getShipByName(@RequestParam("name") String name ) throws JsonProcessingException {
//        Ship shipByName = shipService.getShipByName(name);
//        return mapper.writeValueAsString(shipByName);
//    }


    @RequestMapping(method = RequestMethod.GET)
    public String getShipById(@RequestParam("id") long id) throws JsonProcessingException {
        Ship shipById = shipService.getShipById(id);
        return mapper.writeValueAsString(shipById);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewShip(@RequestBody JsonNode newShip) throws JsonProcessingException {
        Ship ship = mapper.treeToValue(newShip, Ship.class);
        if (shipService.addNewShip(ship) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeShip(@PathVariable("id") long id) {
        shipService.removeShip(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateShip(@PathVariable("id") long id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Map<String, String> mapWithProps = mapper.treeToValue(detailsToUpdate, Map.class);

        shipService.updateShip(id, mapWithProps);
    }


}
