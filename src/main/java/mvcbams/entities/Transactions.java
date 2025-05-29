package mvcbams.entities;

import java.security.Timestamp;

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
	private Transactions fromaccount;
	@ManyToOne
	@JoinColumn(name = "toaccount")
	private Transactions toaccount;

	private double amount;
	@Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", 
			insertable = false, updatable = false, nullable = false)
	private Timestamp timestamp;

}
