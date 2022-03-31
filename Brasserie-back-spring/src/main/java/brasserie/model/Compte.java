package brasserie.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonView(JsonViews.Common.class)
	protected Integer id;
	
	@NotEmpty
	@Column(unique=true)
	@JsonView(JsonViews.Common.class)
	protected String mail;
	
	@NotEmpty
	protected String password;
	
	@OneToMany(mappedBy = "id_client")
	@JsonView(JsonViews.ClientWithAchat.class)
	private List<Achat> achats;
	
	@Version
	private int version;
	
	// constructors
	public Compte() {}
	
	public Compte(Integer id, String mail, String password, List<Achat> achats) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.achats = achats;
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
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	// methods
	
}
