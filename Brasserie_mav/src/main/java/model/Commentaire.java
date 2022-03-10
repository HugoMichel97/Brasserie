package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity

public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_commentaire;
	@ManyToOne
	@JoinColumn(name= "id_biere")
	private Biere biere;
	private String commentaire;
	
	@Version
	protected int version;
	
	public Commentaire() {}
	
	public Commentaire(Biere biere, String commentaire)
	{
		this.biere = biere;
		this.commentaire = commentaire;
	}

	public Integer getId_commentaire() {
		return id_commentaire;
	}

	public void setId_commentaire(Integer id_commentaire) {
		this.id_commentaire = id_commentaire;
	}

	public Biere getBiere() {
		return biere;
	}

	public void setBiere(Biere biere) {
		this.biere = biere;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Commentaire [id_commentaire=" + id_commentaire + ", biere=" + biere + ", commentaire=" + commentaire
				+ "]";
	}
	
	
}
