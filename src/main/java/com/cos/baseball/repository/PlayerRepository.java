package com.cos.baseball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.baseball.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	
	List<Player> findByTeamId(int teamId);
}
