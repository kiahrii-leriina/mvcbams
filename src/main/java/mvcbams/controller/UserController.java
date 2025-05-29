package mvcbams.controller;

import javax.persistence.EntityManager;
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
			return mv;

		} catch (Exception e) {
			mv.setViewName("landing.jsp");
			mv.addObject("msg", "Invalid Email or Password");
			return mv;
		}
	}

	@PostMapping("/register")
	public ModelAndView register(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam long phone) {
		
		String jpql = "INSERT INTO Users ()";

		return null;
	}

}
