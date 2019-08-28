package com.tekion.resources;

import com.tekion.beans.PlayerMatchBatting;
import com.tekion.controller.PlayerMatchBattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players/{playerId}/matches/{matchId}/batting")
public class PlayerMatchBattingResource {

    @Autowired
    private PlayerMatchBattingRepository playerMatchBattingRepository;

    @GetMapping("/records")
    public PlayerMatchBatting getPlayerBattingRecordsForMatch(@PathVariable("playerId") int playerId, @PathVariable("matchId") int matchId){
        System.out.println(playerId+" "+matchId);
        return playerMatchBattingRepository.getByPlayerAndMatchId(playerId, matchId);
    }
}
