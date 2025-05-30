package mvcbams.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvcbams.entities.Accounts;
import mvcbams.entities.Transactions;
import mvcbams.entities.Users;

@Controller
public class UserController {

	@Autowired
	EntityManager em;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		String sql = "SELECT u FROM Users u WHERE u.email = :email AND u.password = :password";
		ModelAndView mv = new ModelAndView();

		try {
			TypedQuery<Users> q = em.createQuery(sql, Users.class);
			q.setParameter("email", email);
			q.setParameter("password", password);

			Users user = q.getSingleResult();

			if (user == null) {
				mv.setViewName("landing.jsp");
				mv.addObject("msg", "No user found");
				return mv;
			}

			mv.setViewName("profile");
			mv.addObject("user", user);

		} catch (Exception e) {
			mv.setViewName("landing");
			mv.addObject("msg", "Invalid Email or Password");
		}
		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView register(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam long phone, @RequestParam String accounttype, @RequestParam double deposit) {
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

			Accounts account = new Accounts();
			account.setType(accounttype);
			account.setBalance(deposit);
			account.setUser(user);
			em.merge(account);
			et.commit();

			if (user != null) {
				System.out.printf(
						"User saved succcessfully, "
								+ "Id: %d | Name: %s | Email: %s | Password: %s | Phone: %d | Account ID: %d\n",
						user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getPhone(),
						user.getAccount().getId());
			}

			mv.setViewName("landing");
			mv.addObject("msg", "User saved successfully, please login");
			
		} catch (Exception e) {
			mv.setViewName("register");
			mv.addObject("msg", "unable to save user try again");
		}
		return mv;

	}

	@RequestMapping("/account")
	public ModelAndView accountDetails(@RequestParam int id) {
		String jpql = "SELECT u FROM Accounts u WHERE u.user.id =: id";
		ModelAndView mv = new ModelAndView();

		try {
			TypedQuery<Accounts> q = em.createQuery(jpql, Accounts.class);
			q.setParameter("id", id);
			Accounts account = q.getSingleResult();
			mv.setViewName("account");
			mv.addObject("account", account);

		} catch (Exception e) {
			mv.setViewName("profile");
			mv.addObject("msg", "No account found");
		}
		return mv;
	}

	@RequestMapping("/transfer")
	public ModelAndView transferMoney(@RequestParam int fromaccountid, @RequestParam int toaccountid,
	                                  @RequestParam double amount) {

	    ModelAndView mv = new ModelAndView();
	    try {
	        Accounts fromaccount = em.find(Accounts.class, fromaccountid);
	        Accounts toaccount = em.find(Accounts.class, toaccountid);

	        if (fromaccount == null || toaccount == null) {
	            mv.setViewName("transfer");
	            mv.addObject("msg", "One or both accounts not found.");
	            return mv;
	        }

	        if (fromaccountid != toaccountid && fromaccount.getBalance() >= amount) {
	            EntityTransaction et = em.getTransaction();
	            et.begin();

	            fromaccount.setBalance(fromaccount.getBalance() - amount);
	            toaccount.setBalance(toaccount.getBalance() + amount);

	            Transactions transaction = new Transactions();
	            transaction.setFromaccount(fromaccount);
	            transaction.setToaccount(toaccount);
	            transaction.setAmount(amount);

	            em.persist(transaction);

	            et.commit();

	            mv.setViewName("success");
	            mv.addObject("transaction", transaction);
	        } else {
	            mv.setViewName("transfer");
	            mv.addObject("msg", "Transaction failed: same accounts or insufficient balance.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); 
	        mv.setViewName("transfer"); 
	        mv.addObject("msg", "Transfer failed, try again.");
	    }

	    return mv;
	}

	

	@RequestMapping("/history")
	public ModelAndView transactionHistory(@RequestParam int id) {
		
		ModelAndView mv = new ModelAndView();
		try {
	
			Accounts account = em.find(Accounts.class, id);
			List<Transactions> recievedtransactions = account.getRecievedTransactions();
			List<Transactions> sentTransactions = account.getSentTransactons();
			
			mv.setViewName("history");
			mv.addObject("received", recievedtransactions);
			mv.addObject("send", sentTransactions);
						
			
		}catch(Exception e) {
			mv.setViewName("account");
			mv.addObject("msg", "no transaction history found");
			
		}
		return mv;
	}

}
