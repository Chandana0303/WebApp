package com.fis.webapp.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyFirstController {

	public MyFirstController() {
		super();
		System.out.println("Inside Web Controller - default constructor called");
	}
	
	@RequestMapping("/")
	public String showHomePage()
	{
		return "homepage";
	}
	
	@RequestMapping("/userpage")
	public String displayuser()
	{
		
		return "Emailpage";
	}
	
	@RequestMapping(value = "/doPrint", method= RequestMethod.POST)
	public String printUserandDomain(HttpServletRequest req,Model model)
	{
		String email = req.getParameter("email");
		String username = email.substring(0,email.lastIndexOf("@"));
		String domain = email.substring(email.indexOf("@")+1,email.indexOf("."));
		
		
		model.addAttribute("email" ," "+email);
		model.addAttribute("username" ," "+username);
		model.addAttribute("domain"," "+domain);
		
		System.out.println("----> username"+username);
		System.out.println("----> domain"+domain);
		
		return "UserandDomain";
	
	}

}
