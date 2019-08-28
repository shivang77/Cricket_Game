package com.tekion.resources;

import com.tekion.beans.PlayerBatting;
import com.tekion.controller.PlayerBattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players/batting")
public class PlayerBattingResource {

    @Autowired
    private PlayerBattingRepository playerBattingRepository;

    @GetMapping("/{playerId}")
    public PlayerBatting getPlayerBattingRecord(@PathVariable("playerId") int playerId){
        return playerBattingRepository.findById(playerId).get();
    }

}
