package com.tekion.controller;

import com.tekion.beans.PlayerBowling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerBowlingRepository extends JpaRepository<PlayerBowling, Integer> {

}
