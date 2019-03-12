package tw.com.liwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String home() {
		System.out.println("home");
		return "home";
	}
	@RequestMapping(value="/loginSuccess")
	public String loginSuccess() {
		System.out.println("home");
		return "loginSuccess";
	}
}
