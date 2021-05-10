package ar.edu.unju.fi.tp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 
 * @author Karen Flores
 *
 */
@Controller
public class PrincipalController {
	
	@GetMapping("/principal")
	public String getIndexPage(Model model) {
		
		return "principal";
	}
	
}
