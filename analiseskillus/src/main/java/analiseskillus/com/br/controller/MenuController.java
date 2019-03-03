package analiseskillus.com.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/menu/novo")
	public String novo() {
		return "/menu/CadastroMenu";
	}

	@RequestMapping("/menu")
	public String pesquisar() {
		return "/menu/PesquisaMenu";
	}
}
