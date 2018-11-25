package blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blog.exception.AuthorNotFoundException;
import blog.model.Author;
import blog.service.BlogService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	//TODO: realize constructor-based autowiring
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
	@RequestMapping("/author")
	public String getAuthorInfoByID(Model model, @RequestParam("id") long authorId){
		Author author = blogService.findAuthorById(authorId);
		System.out.println(author);
		model.addAttribute("author", author);
		return "authorInfo";
	}
	@ExceptionHandler(AuthorNotFoundException.class)
	public ModelAndView handleEror(HttpServletRequest request, AuthorNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidAuthorId", exception.getAuthorId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		mav.setViewName("authorNotFound");
		return mav;
	}
	
}
