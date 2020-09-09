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

import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;

@Controller
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/team")
	public String team(Model model) {
		
		model.addAttribute("team", teamRepository.findAll());
		return "teamList";
	}
	//팀 등록 페이지로 이동
	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		
		return "teamSaveForm";
	}
	
	@PostMapping("/team/saveProc")
	public String saveForm(Model model, Team team) {
		
		teamRepository.save(team);
		
		model.addAttribute("team",teamRepository.findAll());
		
		return "teamList";
	}
	
	@DeleteMapping("/team/delete/{id}")
	public @ResponseBody String deleteTeam(@PathVariable int id){
		teamRepository.deleteById(id);
		
		return "삭제성공";
	}
	
}
