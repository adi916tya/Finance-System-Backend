package com.wipro.velocity.team8.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.wipro.velocity.ims.model.Dealer;
import com.wipro.velocity.team8.model.User;
import com.wipro.velocity.team8.service.ConsumerService;

@Controller
public class LoginController {

	
	@Autowired
	private ConsumerService cservice;
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	// Request --> FC --> Controller --> Response(views - jsp)
	@RequestMapping("/register")
	public String viewRegisterPage(Model model) {
		User consumer = new User();
		model.addAttribute("consumer",consumer);
		return "register"; // model+view
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model theModel) {
		return "login";
	}
	
	@PostMapping("/loginUser")
	public ModelAndView loginUser(HttpServletRequest req, @ModelAttribute("user") User user) {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		String pass2=encryptPass(pass);
		
		StringTokenizer st= new StringTokenizer(email,"@");
		String s2=st.nextToken();
		
		ModelAndView mav=null;
		User c=cservice.findByEmail(email);
		
		if(c==null) {
			mav=new ModelAndView("login");
			mav.addObject("error","User Doesn't Exists");
		}else if(email.equals(c.getEmail()) && pass2.equals(c.getPassword())) {
			
			req.getSession().setAttribute("user", s2);
			
			mav=new ModelAndView("products");
			mav.addObject("user", c);
			
//			List<Product> listProducts = new service.listAll();
//			mav.addObject("listProducts",listProducts);
			
		}else {
			mav=new ModelAndView("login");
			mav.addObject("error","Invalid Passord");
		}
		return mav;
	}
	
	private String encryptPass(String pass) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString=pass;
		String encodedString=encoder.encodeToString(
				normalString.getBytes(StandardCharsets.UTF_8));
		return encodedString;
	}
}
