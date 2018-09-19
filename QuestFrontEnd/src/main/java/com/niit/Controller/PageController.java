package com.niit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{


	@RequestMapping("/index")
	public String showIndexPage()
	{
		return "index";
	}

	@RequestMapping("/login")
	public String showLoginPage()
	{
		return "login";
	}
	
	
	

}
