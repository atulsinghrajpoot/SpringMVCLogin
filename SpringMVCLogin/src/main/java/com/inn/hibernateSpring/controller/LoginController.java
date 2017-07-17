package com.inn.hibernateSpring.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inn.hibernateSpring.model.User;
import com.inn.hibernateSpring.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside showLogin()");
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login",new User());
	    return mav;
	  }
	
	@RequestMapping(value = "/loginProcess.htm", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
		System.out.println("Inside loginProcess()");
		
		ModelAndView  modelAndView = null;//new ModelAndView("home");
		String userName = user.getUsername();
		String password = user.getPassword();
		String view = "";

		// Note:
		if(userService.isValidLogin(userName,password))
		{
			view = "home";
			modelAndView = new ModelAndView(view , "login",user);
		}else{
			view ="login";
			modelAndView = new ModelAndView(view , "login",user);
			modelAndView.addObject("error", "Invalid credential");
			
		}
			
		return modelAndView;
	}

	public Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		System.out.println("formBackingObject() is called");
		User user = new User();
		user.setUsername("raj");
		user.setPassword("raj");
		return user;
	}
	

}
