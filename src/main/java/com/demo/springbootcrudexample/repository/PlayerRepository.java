package com.demo.springbootcrudexample.repository;

import com.demo.springbootcrudexample.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer > {
    Player findByName(String name);
}
