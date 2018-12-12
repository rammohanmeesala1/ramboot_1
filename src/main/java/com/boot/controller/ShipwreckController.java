package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
        public List<Shipwreck> list(){
         return shipwreckRepository.findAll();

    }

    @RequestMapping(value ="shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id){
        return shipwreckRepository.getOne(id);
    }

    @RequestMapping(value ="shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id){
        return ShipwreckStub.delete(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck put(@PathVariable long id, @RequestBody Shipwreck shipwreck){
        return ShipwreckStub.update(id, shipwreck);
    }
}
