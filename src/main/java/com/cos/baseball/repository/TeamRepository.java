package com.cos.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.baseball.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
