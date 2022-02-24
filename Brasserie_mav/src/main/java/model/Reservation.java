package model;

public class Reservation {
	
	private Client client;
	private Evenement evt;
	
	// constructors
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
