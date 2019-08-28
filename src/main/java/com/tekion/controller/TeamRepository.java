package com.tekion.controller;

import com.tekion.beans.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "select * from team where team_id = ?1", nativeQuery = true)
    Team getTeamById(int teamId);
}
