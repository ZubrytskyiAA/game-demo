package com.example.gamedemo.controller;

import com.example.gamedemo.service.interfaces.ShipService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ships")
public class ShipListController {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private ShipService shipService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllShips() {

        return mapper.valueToTree(shipService.getAllShips());
    }

}
