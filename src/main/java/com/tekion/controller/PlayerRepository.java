package com.tekion.controller;

import com.tekion.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select * from player where team_id = ?1", nativeQuery = true)
    List<Player> findAllByTeam(int teamId);

    @Query(value = "select * from player where player_role like ?1", nativeQuery = true)
    List<Player> findAllByRole(String role);

    @Query(value = "select * from player where player_name like ?1", nativeQuery = true)
    Player findByName(String name);
}
