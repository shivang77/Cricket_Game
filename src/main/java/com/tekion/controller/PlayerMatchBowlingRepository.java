package com.tekion.controller;

import com.tekion.beans.PlayerMatchBowling;
import com.tekion.beans.PlayerMatchRecordPrimary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMatchBowlingRepository extends JpaRepository<PlayerMatchBowling, PlayerMatchRecordPrimary> {

    @Query(value = "select * from match_bowling where player_id like ?1 and match_id like ?2", nativeQuery = true)
    PlayerMatchBowling getByPlayerAndMatchId(int playerId, int matchId);
}
