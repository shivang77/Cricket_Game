package com.tekion.resources;

import com.tekion.beans.Player;
import com.tekion.controller.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerResource {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/{playerId}")
    public Player getPlayerDetails(@PathVariable("playerId") int playerId){
        return playerRepository.findById(playerId).get();
    }
    @GetMapping("/teams/{teamId}")
    public List<Player> getPlayersForTeam(@PathVariable("teamId") int teamId){
        return playerRepository.findAllByTeam(teamId);
    }

    @GetMapping("/roles/{role}")
    public List<Player> getPlayersByRole(@PathVariable("role") String role){
        return playerRepository.findAllByRole(role.toUpperCase());
    }

    @GetMapping("/names/{name}")
    public Player getPlayersByName(@PathVariable("name") String name){
        return playerRepository.findByName(name.toLowerCase());
    }
}
