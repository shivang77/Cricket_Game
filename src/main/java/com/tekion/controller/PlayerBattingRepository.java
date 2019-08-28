package com.tekion.controller;

import com.tekion.beans.PlayerBatting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerBattingRepository extends JpaRepository<PlayerBatting, Integer> {



}
