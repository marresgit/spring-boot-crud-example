package com.demo.springbootcrudexample.service;

import com.demo.springbootcrudexample.clients.OpenDotaClient;
import com.demo.springbootcrudexample.entity.Player;
import com.demo.springbootcrudexample.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;
    @Autowired
    private OpenDotaClient client;

    public Player savePlayer(Player player) {
        return repository.save(player);
    }
    public List<Player> savePlayers(List<Player> players) {
        return repository.saveAll(players);
    }
    public String getPlayers(){
//        return List.of(Player.builder().id(1).name("kalle").build());
        return repository.findAll();
    }
    public Player getPlayersById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Player getPlayersByName(String name) {
        return repository.findByName(name);
    }

    public String deletePlayer(int id){
        repository.deleteById(id);
        return "player removed: "+id;
    }

    public Player updatePlayer(Player player){
        Player existingPlayer=repository.findById(player.getId()).orElse(null);
        existingPlayer.setName(player.getName());
        return repository.save(existingPlayer);
    }

//  ################################################################################
//  # STEVE API
//  ################################################################################
    public String getSteve(String[] args){
        return client.getSteveAPI(62297546);
    }

}
