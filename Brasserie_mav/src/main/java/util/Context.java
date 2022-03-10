package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBrasseur;
import dao.DAOClient;
import dao.DAOInfoReglement;
import dao.IDAOBrasseur;
import dao.IDAOClient;
import dao.IDAOInfoReglement;


public class Context {
	private static Context _singleton=null;	
	private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
	private IDAOBrasseur daoBrasseur= new DAOBrasseur();
	private IDAOClient daoClient = new DAOClient();
	private IDAOInfoReglement daoReglement = new DAOInfoReglement();



	private Context() {}


	public static Context getSingleton() 
	{
		if(_singleton==null) 
		{
			_singleton=new Context();
		}
		
		return _singleton;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDAOBrasseur getDaoBrasseur() {
		return daoBrasseur;
	}

	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public IDAOInfoReglement getDaoReglement() {
		return daoReglement;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void close() {
		emf.close();
	}


}
