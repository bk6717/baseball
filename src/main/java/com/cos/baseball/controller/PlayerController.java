package com.cos.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.model.OutPlayer;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;
import com.cos.baseball.repository.OutPlayerRepository;
import com.cos.baseball.repository.PlayerRepository;
import com.cos.baseball.repository.TeamRepository;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private OutPlayerRepository outPlayerRepository;
	//선수 찾기
	@GetMapping("/player")
	public String findAll(Model model) {
		model.addAttribute("team", teamRepository.findAll());
		model.addAttribute("player", playerRepository.findAll());
		return "playerList";
		
	}
	//선수 등록 페이지 이동
	@GetMapping("/player/saveForm")
	public String saveForm(Model model) {
		model.addAttribute("team", teamRepository.findAll());
		return "playerSaveForm";
	}
	//선수등록 
	@PostMapping("/player/saveProc")
	public String saveProc(Model model,int teamId, Player player) {
		 
	  //System.out.println("player : "+player + "teamId : " + teamId);
		player.setTeam(Team.builder().id(teamId).build());
		
		playerRepository.save(player);
		
		model.addAttribute("player", playerRepository.findAll());
		
		return "redirect:/";
	}
	//선수 삭제
	@DeleteMapping("/player/delete/{id}")
	public @ResponseBody String deletePlayer(@PathVariable int id) {
		
		playerRepository.deleteById(id);
		return "성공";	
	}
	
	
	@PostMapping("/player/outPlayer")
	public String outPlayerSave(OutPlayer outPlayer, int id) {
		System.out.println("탐??");
		System.out.println(outPlayer+"000000000000000000000000000000000000");
		outPlayerRepository.save(outPlayer);
		playerRepository.findAll();
		
		return "teamPlayerList";	
	}
	
	
}
