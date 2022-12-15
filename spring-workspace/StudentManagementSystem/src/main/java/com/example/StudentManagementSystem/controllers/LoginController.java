package com.example.StudentManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.dao.RoleRepo;
import com.example.StudentManagementSystem.entity.Role;

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
	 public String loginUser(@ModelAttribute("userRole") Role user) {
		 System.out.println(user.getUserName());
		 System.out.println(user.getPassword());
		 String userName = user.getUserName();
		 Role roleData = roleRepo.findByUserName(userName);
		 System.out.println(roleRepo.findByUserName(userName));
		 if(roleData.getRoleId()==1) {
			 if (user.getPassword().equals(roleData.getPassword())) {
				 System.out.println("Login success");
				 return "home";
			}
		 }
		 else if (roleData.getRoleId()==2) {
			 if (user.getPassword().equals(roleData.getPassword())) {
				 System.out.println("Login success");
				 return "profile";
			}
		}
		 else {
			 System.out.println("Login failed");
			return "index";
		}
		return userName;

		 
	 }
	
		@GetMapping("/profile")
		public String ProfilePage() {
			return "profile";
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
