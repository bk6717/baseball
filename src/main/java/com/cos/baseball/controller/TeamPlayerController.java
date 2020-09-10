package com.cos.baseball.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.model.Player;
import com.cos.baseball.repository.PlayerRepository;
import com.cos.baseball.repository.TeamRepository;

@Controller
public class TeamPlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/teamPlayer")
	public String teamPlayer(Model model) {
		
		model.addAttribute("player", playerRepository.findAll());
		
		return "teamPlayerList";
	}
	
	@GetMapping("/teamPlayer/release")
	public String release(Model model,Player player) {
		
		model.addAttribute("player", playerRepository.findAll());
		playerRepository.findById(player.getId()); 
		
		return "playerReleaseForm";
	}
	
	@GetMapping("/teamPlayer/{teamId}")
	public @ResponseBody List<Player> findTeam(@PathVariable int teamId) {
		
		
		
		return playerRepository.findByTeamId(teamId);
	}
}
