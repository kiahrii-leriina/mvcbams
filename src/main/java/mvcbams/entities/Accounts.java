package mvcbams.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double balance;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID")
	private Users user;
	
	@OneToMany(mappedBy = "fromaccount",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transactions> recievedTransactions;
	
	@OneToMany(mappedBy = "toaccount",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transactions> sentTransactons;

}
