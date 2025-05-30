package mvcbams.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @OneToMany(mappedBy = "fromaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> sentTransactons;

    @OneToMany(mappedBy = "toaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> recievedTransactions;

	@Override
	public String toString() {
		return "Accounts [id=" + id + ", type=" + type + ", balance=" + balance + ", user=" + user
				+ ", sentTransactons=" + sentTransactons + ", recievedTransactions=" + recievedTransactions + "]";
	}

	public Accounts(int id, String type, double balance, Users user, List<Transactions> sentTransactons,
			List<Transactions> recievedTransactions) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.user = user;
		this.sentTransactons = sentTransactons;
		this.recievedTransactions = recievedTransactions;
	}

	public Accounts() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Transactions> getSentTransactons() {
		return sentTransactons;
	}

	public void setSentTransactons(List<Transactions> sentTransactons) {
		this.sentTransactons = sentTransactons;
	}

	public List<Transactions> getRecievedTransactions() {
		return recievedTransactions;
	}

	public void setRecievedTransactions(List<Transactions> recievedTransactions) {
		this.recievedTransactions = recievedTransactions;
	}


}
