package io.interfaz.training.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(HttpSession session) {
		session.removeAttribute("name");
		return "web/home";
	}
	
}
