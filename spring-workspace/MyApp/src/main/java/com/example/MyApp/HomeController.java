package com.example.MyApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("home")
	//@ResponseBody
//	public String home(HttpServletRequest req) {
//		
////		String name = req.getParameter("name");
////		System.out.println("Hi" +name); //will display the name that we entered in browser url
////		return "home"; 
//		//by default this will not support jsp
//		//and duty is to send and receive req and resp
//		//so add @ResponseBody will display the contents from jsp file
//		//but we need jsp page, so remove Responsebody and add a dependency in pom.xml
//		//add Tomcat-Jasper dependency
//		
//		
//		//to get parameters from browser
//		//session object for passing name to home.jsp 
//		HttpSession session = req.getSession();
//		String name = req.getParameter("name");
//		System.out.println("Hi" +name); //will display the name that we entered in browser url
//		session.setAttribute("name", name); //key:"name", value: name that we got from url, eg;"Ajmi"
//		//URL: http://localhost:8080/home?name=Ajmi
//		return "home"; 
//	}
	//with the help of spring, we can make the above code simpler
	public String home(String name,HttpSession session) {
		System.out.println("Hi" +name);
		session.setAttribute("name", name);
		return "home";
		//so here, session object is used for holding the data and transfer it to home.jsp
		//home is the view and 
	}
	
	//another method: model and view technique
	
	
	
}
