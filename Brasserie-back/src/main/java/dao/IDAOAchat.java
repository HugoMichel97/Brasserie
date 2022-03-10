package dao;

import java.util.List;

import model.Achat;

public interface IDAOAchat extends IDAO<Achat, Integer> {
	
	public List<Achat> findByIdClient(Integer id);

}
