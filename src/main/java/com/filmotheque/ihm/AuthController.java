package com.filmotheque.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"loggedUser"})
public class AuthController {

	@GetMapping("login")
	public String loginPage() {
		return "login-page";
	}
	
	@GetMapping("login-test")
	public String loginTest(Model model) {
		
		model.addAttribute("loggedUser", "Tata@gmail.com");
		
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	
}
