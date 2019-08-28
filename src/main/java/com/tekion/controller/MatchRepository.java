package com.tekion.controller;

import com.tekion.beans.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query(value = "select * from cricket.match where match_id = ?1", nativeQuery = true)
    Match findByMatchId(int matchid);

    @Query(value = "select * from cricket.match where series_id = ?1", nativeQuery = true)
    List<Match> findBySeriesId(int seriesid);


}
