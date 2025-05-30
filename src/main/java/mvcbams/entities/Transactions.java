package mvcbams.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fromaccount")
	private Accounts fromaccount;
	
	@ManyToOne
	@JoinColumn(name = "toaccount")
	private Accounts toaccount;

	private double amount;
	
	@Column(name = "timestamp", insertable = false, updatable = false, nullable = false)
	private Timestamp timestamp;

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", fromaccount=" + fromaccount + ", toaccount=" + toaccount + ", amount="
				+ amount + ", timestamp=" + timestamp + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Accounts getFromaccount() {
		return fromaccount;
	}

	public void setFromaccount(Accounts fromaccount) {
		this.fromaccount = fromaccount;
	}

	public Accounts getToaccount() {
		return toaccount;
	}

	public void setToaccount(Accounts toaccount) {
		this.toaccount = toaccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Transactions(int id, Accounts fromaccount, Accounts toaccount, double amount, Timestamp timestamp) {
		super();
		this.id = id;
		this.fromaccount = fromaccount;
		this.toaccount = toaccount;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public Transactions() {
		super();
	}


	
	
	
	

}
