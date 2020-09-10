package com.cos.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.baseball.model.OutPlayer;

public interface OutPlayerRepository extends JpaRepository<OutPlayer, Integer>{
	
}