package mvcbams.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvcbams.entities.Users;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	EntityManager em;

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		String sql = "SELECT u FROM Users u WHERE u.email = :email AND u.password = :password";
		ModelAndView mv = new ModelAndView();

		try {
			TypedQuery<Users> q = em.createQuery(sql, Users.class);
			q.setParameter("email", email);
			q.setParameter("password", password);

			Users rs = q.getSingleResult();

			if (rs == null) {
				mv.setViewName("landing.jsp");
				mv.addObject("msg", "No user found");
				return mv;
			}

			mv.setViewName("createaccount.jsp");

		} catch (Exception e) {
			mv.setViewName("landing.jsp");
			mv.addObject("msg", "Invalid Email or Password");
		}
		return mv;

	}


	@PostMapping("/register")
	public ModelAndView register(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam long phone) {
		ModelAndView mv = new ModelAndView();
		try {
			EntityTransaction et = em.getTransaction();
			Users user = new Users();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setPhone(phone);
			
			et.begin();
			user = em.merge(user);
			if(user != null) {
				System.out.printf("User saved succcessfully, "
						+ "Id: %d | Name: %s | Email: %s | Password: %s | Phone: %d\n");
			}
			
			mv.setViewName("landing.jsp");
			mv.addObject("msg", "User saved successfully, please login");
		}catch(Exception e) {
			mv.setViewName("register.jsp");
			mv.addObject("msg", "unable to save user try again");
		}
		return mv;

	}

}
