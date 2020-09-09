package com.cos.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.model.Stardium;
import com.cos.baseball.repository.StardiumRepository;

@Controller
public class stardiumController {

	@Autowired
	private StardiumRepository stardiumRepository;
	
	@GetMapping({"stardium","","/"})
	public String findStardium(Model model) {
		
		model.addAttribute("stardium", stardiumRepository.findAll());
		
		return "stardiumList";
	}
	
	//경기장 등록 페이지 이동 
	@GetMapping("/stardium/saveForm")
	public String stardiumSaveForm() {
		
		return "stardiumSaveForm";
		
	}
	
	//경기장 등록
	@PostMapping("/stardium/saveProc")
	public String stardiumSave(Model model, Stardium stardium) {
		System.out.println(stardium);
		System.out.println("이거안됨?");
		
		stardiumRepository.save(stardium);
		
		model.addAttribute("stardium", stardiumRepository.findAll());
		
		return "/stardiumList";
	}
	
	@DeleteMapping("/stardium/delete/{id}")
	public @ResponseBody String deleteStardium(@PathVariable int id) {
		
		stardiumRepository.deleteById(id);
		
		return "삭제성공";
	}
	
}
