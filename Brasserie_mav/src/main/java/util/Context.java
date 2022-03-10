package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOEvenements;
import dao.IDAOEvenements;



public class Context {
	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserieConnection");

private static Context _singleton=null;	

private IDAOEvenements daoEvenements = new DAOEvenements();





private Context() {}


public static Context getSingleton() 
{
	if(_singleton==null) 
	{
		_singleton=new Context();
	}
	
	return _singleton;
}



public IDAOEvenements getDaoEvenements() {
	return daoEvenements;
}

public void setDaoEvenements(IDAOEvenements daoEvenements) {
	this.daoEvenements = daoEvenements;
	

}

public EntityManagerFactory getEmf() {
	return emf;
}

public void close() {emf.close();}

}