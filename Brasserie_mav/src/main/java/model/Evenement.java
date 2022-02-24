package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {
	
	private LocalDate date;
	private LocalTime heure;
	private String libelle;
	private double prix;
	private int ptsRequis = 0;
	private String description;
	private Brasseur brasseur;
	private Reservation resa;
	
	// constructors
	public Evenement(LocalDate date, LocalTime heure, String libelle, double prix, int ptsRequis,
			String description, Brasseur brasseur, Reservation resa) {
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.prix = prix;
		this.ptsRequis = ptsRequis;
		this.description = description;
		this.brasseur = brasseur;
		this.resa = resa;
	}
	
	public Evenement(LocalDate date, LocalTime heure, String libelle, double prix) {
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.prix = prix;
	}

	// getters-setters
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getPtsRequis() {
		return ptsRequis;
	}
	public void setPtsRequis(int ptsRequis) {
		this.ptsRequis = ptsRequis;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Brasseur getBrasseur() {
		return brasseur;
	}
	public void setBrasseur(Brasseur brasseur) {
		this.brasseur = brasseur;
	}

	public Reservation getResa() {
		return resa;
	}
	public void setResa(Reservation resa) {
		this.resa = resa;
	}
	
	// toString
	@Override
	public String toString() {
		return "Evenement [date=" + date + ", heure=" + heure + ", libelle=" + libelle + ", prix=" + prix
				+ ", ptsRequis=" + ptsRequis + ", description=" + description + ", brasseur=" + brasseur + ", resa="
				+ resa + "]";
	}
	
	// methods
	
}
