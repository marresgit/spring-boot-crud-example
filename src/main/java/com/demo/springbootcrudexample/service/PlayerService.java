package com.demo.springbootcrudexample.service;

import com.demo.springbootcrudexample.clients.TodoClient;
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
    private TodoClient client;

    public Player savePlayer(Player player) {
        return repository.save(player);
    }
    public List<Player> savePlayers(List<Player> players) {
        return repository.saveAll(players);
    }

    public List<Player> getPlayers(){
        String todos = client.getTodos();
        System.out.println("--------------------------------");
        System.out.println(todos);
        System.out.println("--------------------------------");
        return List.of(Player.builder().id(1).name("kalle").build());
//        return todos;
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
}
