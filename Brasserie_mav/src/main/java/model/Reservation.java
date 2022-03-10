package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	//@OneToOne
	private transient Client client;
	// @OneToOne
	private transient Evenement evt;
	
	// constructors
	public Reservation()
	{
		
	}
	public Reservation(Client client, Evenement evt) {
		this.client = client;
		this.evt = evt;
	}

	// getters-setters
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Evenement getEvt() {
		return evt;
	}
	public void setEvts(Evenement evt) {
		this.evt = evt;
	}

	// toString
	@Override
	public String toString() {
		return "Reservation [client=" + client + ", evt=" + evt + "]";
	}
	
	// methods
	public void confirmerResa() {
		
	}
	
	public void annulerResa() {
		
	}
}
