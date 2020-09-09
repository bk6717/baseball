package com.cos.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.baseball.repository.PlayerRepository;

@Controller
public class TeamPlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/teamPlayer")
	public String teamPlayer(Model model) {
		
		playerRepository.findAll();
		
		return "";
	}
}
