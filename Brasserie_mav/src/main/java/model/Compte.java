package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	
	protected Integer id;
	protected String mail;
	protected String password;
	protected List<Produits> catalogue = new ArrayList<Produits>();
	
	// constructors
	public Compte(Integer id, String mail, String password, List<Produits> catalogue) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.catalogue = catalogue;
	}

	public Compte(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
	
	// getters-setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}
	public void setLogin(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Produits> getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(List<Produits> catalogue) {
		this.catalogue = catalogue;
	}
	
	// toString
	@Override
	public String toString() {
		return "Compte [id=" + id + ", mail=" + mail + ", password=" + password 
				+ ", catalogue=" + catalogue + "]";
	}
	
	// methods
	
}
