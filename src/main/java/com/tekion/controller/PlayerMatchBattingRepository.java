package com.tekion.controller;

import com.tekion.beans.PlayerMatchBatting;
import com.tekion.beans.PlayerMatchRecordPrimary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMatchBattingRepository extends JpaRepository<PlayerMatchBatting, PlayerMatchRecordPrimary> {

    @Query(value = "select * from match_batting where player_id like ?1 and match_id like ?2", nativeQuery = true)
    PlayerMatchBatting getByPlayerAndMatchId(int playerId, int matchId);
}
