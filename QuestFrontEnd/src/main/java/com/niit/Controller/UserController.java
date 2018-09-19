package com.niit.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.UserDAO;
import com.niit.Model.User;



@Controller
public class UserController 
{
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	public String checkUser(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session,Model model)
	{
		String page="UserHome";
		
		User userDetail=new User();
		userDetail.setUid(username);
		userDetail.setUpwd(password);
		
		
		User userDetail1=userDAO.getDetail(username.trim());
		
		
		if(userDetail1.getUpwd().equals(password))
		{
			session.setAttribute("username", userDetail1.getUid());
			session.setAttribute("role", userDetail1.getUname());
			session.setAttribute("loggedIn", true);
			if(userDetail1.getUname().equals("ROLE_USER"))
			{
				page="UserHome";
			}
			else
			{
				page="AdminHome";
			}
		}
		else
		{
			session.setAttribute("loggedIn",false);
			model.addAttribute("errorInfo", "The Username and Password is not Correct");
			page="Login";
		}
		
		return page;
	}
	
	@RequestMapping(value="/logout")
	public String loggingOut(HttpSession session,Model model)
	{
		model.addAttribute("errorInfo", "Successfully Loggged Out");
		session.invalidate();
		return "Login";
	}
	
}
