package com.tekion.resources;

import com.tekion.beans.PlayerBowling;
import com.tekion.controller.PlayerBowlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players/bowling")
public class PlayerBowlingResource {

    @Autowired
    private PlayerBowlingRepository playerBowlingRepository;

    @GetMapping("/{playerId}")
    public PlayerBowling getPlayerBowlingRecord(@PathVariable("playerId") int playerId){
        return playerBowlingRepository.findById(playerId).get();
    }
}
