package br.com.dreamtravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.User;
import br.com.dreamtravel.model.form.UserDto;
import br.com.dreamtravel.service.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login/admin")
	public ModelAndView loginAdmin() {
		
		ModelAndView mav = new ModelAndView("/form-login");
		mav.addObject("processingUrl", "/login_admin");
		mav.addObject("userCategory", "Admin");
		return mav;
	}
	
	@GetMapping("/cadastro/admin")
	public String cadastroAdminPage(Model mav) {
			
		mav.addAttribute("userDto", new UserDto());
		mav.addAttribute("processingUrl", "/cadastro/admin");
		mav.addAttribute("userCategory", "Admin");
		return "form-cadastro";
	}
	
	@PostMapping("/cadastro/admin")
	public String processaCadastroAdmin(
			@Valid UserDto userDto, 
			BindingResult result, 
			Model model) {
		
		return processRegister(userDto, result, model, "ROLE_ADMIN", "/cadastro/admin",
				"/cadastro/admin", "Admin");
	}

	private String processRegister(
			UserDto userDto, 
			BindingResult result, 
			Model model, 
			String role,
			String successUrl,
			String processingUrl,
			String userCategory) {
		
		User existingUser = userService.findByUsername(userDto.getUsername());
		
		boolean alreadyExists = existingUser != null;		
		if (alreadyExists) {
			result.rejectValue("username", null, "Username já existe");
		}
		
		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			model.addAttribute("processingUrl", processingUrl);
			model.addAttribute("userCategory", userCategory);
			return "form-cadastro";
		}
		
		userService.save(userDto, role);
		
		return "redirect:"+ successUrl +"?success";
	}

}
