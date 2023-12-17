package br.com.dreamtravel.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AdminUsuarioController {

	@GetMapping 
	public ResponseEntity<String> user() {
		return ResponseEntity.ok().body("CADE PO");
	}
}
