//package com.cos.baseball.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.cos.baseball.model.Player;
//import com.cos.baseball.repository.PlayerRepository;
//import com.cos.baseball.repository.StardiumRepository;
//
//@Controller
//public class TestController {
//
//	@Autowired
//	private PlayerRepository playerRepository;
//	
//	@Autowired
//	private StardiumRepository stardiumRepository;
//	
//	//선수 목록 가져오기 테스트
//	@GetMapping({"","/"})
//	public String test(Model model){
//		model.addAttribute("player", playerRepository.findAll());
//		
//		return "playerList";
//	}
//	
//	@GetMapping("test")
//	public @ResponseBody List<Player> test() {
//		List<Player> player = playerRepository.findAll();
//		
//		return player;
//	}
//		
//	
//	//경기장 목록
////	@GetMapping("stardium")
////	public String stardium(Model model) {
////		model.addAttribute("stardium", stardiumRepository.findAll());
////		
////		return "stardiumList";
////	}
	
//}
