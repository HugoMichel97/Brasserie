package soprajc.Brasserie.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonView(JsonViews.Common.class)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="client_fk", foreignKey = @ForeignKey(name="reservation_client_fk"))
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private Client client;

	@ManyToOne
	@JoinColumn(name="evt_fk", foreignKey = @ForeignKey(name="reservation_evt_fk"))
	@NotNull
	@JsonView(JsonViews.Common.class)
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

	// method
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}

	public void confirmerResa() {

	}

	public void annulerResa() {

	}
}
