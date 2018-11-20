package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.service.BlogService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private BlogService blogService;
	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("welcome", "welcome");
		return "welcome";
	}
	@RequestMapping("/all")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", blogService.getAllUser());
		return "allAuthors";
	}
}
