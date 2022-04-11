package soprajc.Brasserie.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="note")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id_note;
	
	@OneToOne
	@JoinColumn(name="id_client", foreignKey = @ForeignKey(name="note_client_fk"), nullable = true)
	@JsonView(JsonViews.Note.class)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name= "id_biere", foreignKey = @ForeignKey(name="note_biere_fk"))
	@JsonView(JsonViews.Note.class)
	@NotNull
	private Biere biere;
	
	@JsonView(JsonViews.Common.class)
	@NotNull
	private Double note;
	
	@JsonView(JsonViews.Common.class)
	@Column(length=300)
	private String commentaire;
	
	@Version
	protected int version;
	
	public Note() {}
	
	public Note(Client client, Biere biere, Double note) 
	{
		this.client = client;
		this.biere= biere;
		this.note=note;
	}
	
	public Note(Client client, Biere biere, Double note, String commentaire) 
	{
		this.client = client;
		this.biere= biere;
		this.note=note;
		this.commentaire = commentaire;
	}

	public Integer getId_note() {
		return id_note;
	}

	public void setId_note(Integer id_note) {
		this.id_note = id_note;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Biere getBiere() {
		return biere;
	}

	public void setBiere(Biere biere) {
		this.biere = biere;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}
	
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(id_note, other.id_note);
	}
}
