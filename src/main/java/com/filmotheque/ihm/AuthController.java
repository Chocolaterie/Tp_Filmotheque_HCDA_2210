package com.filmotheque.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.filmotheque.bo.Member;

@Controller
@SessionAttributes({"loggedUser"})
public class AuthController {

	@GetMapping("login")
	public String loginPage(Model model) {
		
		// Envoyer un membre vide par défaut dans le formulaire login
		// pour le th:object
		model.addAttribute("member", new Member());
		
		return "login-page";
	}
	
	@PostMapping("login")
	public String loginTest(@ModelAttribute("member") Member member, Model model) {
		// Controle de surface (ex: regex sur email)
		// Controle métier (si en base de donnée) (le service, donc le manager)
		
		// Envoyer une donnée en session
		model.addAttribute("loggedUser", member);
		
		return "redirect:/movies";
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	
}
