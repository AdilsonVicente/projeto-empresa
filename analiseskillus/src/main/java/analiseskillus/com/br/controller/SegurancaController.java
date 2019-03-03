package analiseskillus.com.br.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SegurancaController {

	@GetMapping("/login")
	public String login(@AuthenticationPrincipal User user) {
		if(user != null) { 
			return "redirect:/usuarios/novo";
		}
		
		return "login";
	}
	
	@RequestMapping("/error-403")
	public String acessoNegado() {
		return "error-403";
	}
}
