package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="client_fk")
	private Client client;

	@ManyToOne
	@JoinColumn(name="evt_fk")
	private Evenement evt;

	@Version
	private int version;

	// constructors
	public Reservation()
	{

	}
	public Reservation(Client client, Evenement evt) {
		this.client = client;
		this.evt = evt;
	}

	// getters-setters

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Evenement getEvt() {
		return evt;
	}
	public void setEvt(Evenement evt) {
		this.evt = evt;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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
