package br.com.dreamtravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erro")
public class ErrorController {

	@GetMapping("/403")
	public String error403() {
		return "/erro/403";
	}
}
