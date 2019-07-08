package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	
	
	
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
	@RequestMapping("myName")
	public String myName(@RequestParam String name, Model model) {
		//petik 2 adalah satu parameter yang dikitrim ke html trus name ngisi name petik 2 tersebut di html
		model.addAttribute("name",name);
		return "myname";
		
	}

}
