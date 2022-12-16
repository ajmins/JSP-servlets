package com.example.StudentManagementSystem.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.StudentManagementSystem.dao.RoleRepo;
import com.example.StudentManagementSystem.entity.Role;
import com.example.StudentManagementSystem.entity.Student;

@Controller
public class LoginController {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping("/")
	public String HomePage() {
		return "index";
	}
	 @GetMapping("/loginUser")
	 public String login(Model model) {
		 Role user = new Role();
		 model.addAttribute("userRole",user);
		 return "login";
	 }
	
	 @PostMapping("/userLogin")
	 public String loginUser(@ModelAttribute("userRole") Role user,RedirectAttributes redirectAttributes,@ModelAttribute("passData")String userName, Model model,HttpSession session) {
		 System.out.println(user.getUserName());
		 System.out.println(user.getPassword());
		 userName = user.getUserName();
		 String username = user.getUserName();
		 session.setAttribute(username, session);
		System.out.println(userName);
		
		 Role roleData = roleRepo.findByUserName(userName);
		 System.out.println(roleRepo.findByUserName(userName));
		 if(roleData.getRoleId()==1) {
			 if (user.getPassword().equals(roleData.getPassword())) {
				 System.out.println("Login success");
				 redirectAttributes.addFlashAttribute("fa", userName);
				 
				 System.out.println(userName);
				 return "redirect:/home";
			}
		 }
		 else if (roleData.getRoleId()==2) {
			 if (user.getPassword().equals(roleData.getPassword())) {
				 System.out.println("Login success");
				 redirectAttributes.addFlashAttribute("fa", userName);
				 System.out.println(userName);
				 return "redirect:/profile";
			}
		}
		 else {
			 System.out.println("Login failed");
			return "index";
		}
		return userName;

		 
	 }
	
		@GetMapping("/profile")
		public String ProfilePage(@ModelAttribute("fa")String userName, Model model, Role user) {
			
			model.addAttribute("fa",userName);
			System.out.println(userName);
			model.addAttribute("userName", userName);
			return "profile";
		}
	
	
		@GetMapping("/viewStudent")
		public String ViewStudentPage(HttpServletRequest request, HttpServletResponse response) {
			String name =request.getParameter("enteredName");
			
			 Role roleData = roleRepo.findByUserName(name);
			 System.out.println(roleRepo.findByUserName(name));
			return "view";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	@Autowired
//    private LoginService userService;
//	@Autowired
//	private RoleRepo roleRepo;
//	
//	Role role = new Role();
//	
//	@GetMapping("/")
//	public String HomePage() {
//		return "index";
//	}
//	
//	
//	@GetMapping("/login")
//	public ModelAndView UserLogin() {
//		ModelAndView mav = new ModelAndView("login");
//		mav.addObject("user",new Role());
//		return mav;
//	}
//	
//	@PostMapping("/login")
//	 public String login(Model model) {
//	
////	     Role authUser = userService.role(user.getUserName(), user.getPassWord(),user.getRoleId());
////	    
////	     System.out.print("LIST:"+authUser);
////	     if(Objects.nonNull(authUser))
////	     {
////	     return "redirect:/home";
////	    
////	    
////	     } else {
////	     return "redirect:/login";
////	    
////	    
////	     }
//		Optional<Role> authUser= roleRepo.findById(role.getId());
//		int r = authUser.get().getRoleId();
//		System.out.println(r);
//		if(r==1) {	
//			return "redirect:/home"; //return a view named students
//		}
//		 else {
//		     return "redirect:/login";
//		 }
//	 
//	}
//	    
////	    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
////	    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
////	    {
////	    
////	  
////	        return "redirect:/login";
////	    }
//	 
//	
}
