package dao;

import model.Brasseur;

public interface IDAOBrasseur extends IDAO<Brasseur, Integer>{
	
	public Brasseur seConnecter(String mail,String password);

}
