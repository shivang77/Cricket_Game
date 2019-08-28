package com.tekion.resources;

import com.tekion.beans.Match;
import com.tekion.controller.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchesResource {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/{matchid}")
    public Match getMatchDetails(@PathVariable("matchid") int matchid){
        return matchRepository.findByMatchId(matchid);
    }
    @GetMapping("/series/{seriesid}")
    public List<Match> getMatchDetailsBySeries(@PathVariable("seriesid") int seriesid){
        return matchRepository.findBySeriesId(seriesid);
    }
}
