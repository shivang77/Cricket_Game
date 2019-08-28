package com.tekion.resources;

import com.tekion.beans.Team;
import com.tekion.controller.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamResource {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable("teamId") int teamId){
        System.out.println(teamId);
        return teamRepository.getTeamById(teamId);
    }
}
