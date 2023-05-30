package com.demo.springbootcrudexample.controller;


import com.demo.springbootcrudexample.entity.Player;
import com.demo.springbootcrudexample.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player) {
        return service.savePlayer(player);
    }

    @PostMapping("/addPlayers")
    public List<Player> addPlayer(@RequestBody List<Player> players){
        return service.savePlayers(players);
    }

    @GetMapping
    public String findAllPlayers(){
        return service.getPlayers();
    }

    @GetMapping("/Steve")
    public String getSteveAPI(){
        return service.getSteve();
    }

    @GetMapping("/player/{id}")
    public Player findPlayerById(@PathVariable int id){
        return service.getPlayersById(id);
    }
    @GetMapping("/player/{name}")
    public Player findPlayerByName(@PathVariable String name){
        return service.getPlayersByName(name);
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player) {
        return service.updatePlayer(player);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id){
        return service.deletePlayer(id);
    }

}
