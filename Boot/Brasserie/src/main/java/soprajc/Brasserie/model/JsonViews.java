package soprajc.Brasserie.model;

public class JsonViews {

	public static class Common{}

	public static class Compte extends Common{}
	
	public static class Client extends Compte{}
	
	public static class Evenement extends Common{}
	
	public static class Reservation extends Compte {}
	
	public static class ReservationEvt extends Common {}
	
	public static class Ingredient extends Common {}
	
	public static class Produit extends Common {}

	public static class Achat extends Compte {}
	
	public static class Note extends Common {}
	
	public static class InfoReglement extends Common{}

}

