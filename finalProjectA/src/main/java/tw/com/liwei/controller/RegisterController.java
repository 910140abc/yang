package tw.com.liwei.controller;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.com.liwei.register.model.MemberBean;
import tw.com.liwei.register.service.MemberService;

@Controller
public class RegisterController {
	@Autowired
	MemberService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String prepareRegister(Model model) {
		MemberBean mb = new MemberBean();
		model.addAttribute("memberBean", mb);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("memberBean") MemberBean mb) {
		System.out.println(mb.getAccountId());
//		Blob photo1 = mb.getPhoto1();
		service.addMember(mb);
		return "redirect:register";
	}
	
	
}
