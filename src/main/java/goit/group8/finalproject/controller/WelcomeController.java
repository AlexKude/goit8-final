package goit.group8.finalproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	//@Value("${welcome.message:test}")
	private String message = "Hello";

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

}