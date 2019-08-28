package com.tekion.resources;

import com.tekion.beans.PlayerMatchBowling;
import com.tekion.controller.PlayerMatchBowlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players/{playerId}/matches/{matchId}/bowling")
public class PlayerMatchBowlingResource {

    @Autowired
    private PlayerMatchBowlingRepository playerMatchBowlingRepository;

    @GetMapping("/records")
    public PlayerMatchBowling getPlayerBowlingRecordsForMatch(@PathVariable("playerId") int playerId, @PathVariable("matchId") int matchId){
        return playerMatchBowlingRepository.getByPlayerAndMatchId(playerId, matchId);
    }

}
