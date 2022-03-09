package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBiere;
import dao.DAOCommentaire;
import dao.DAONote;
import dao.DAOSnack;
import dao.IDAOBiere;
import dao.IDAOCommentaire;
import dao.IDAONote;
import dao.IDAOSnack;



public class Context {
	

private static Context _singleton=null;	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
private IDAOBiere daoBiere= new DAOBiere();
private IDAOCommentaire daoCommentaire= new DAOCommentaire();
private IDAONote daoNote= new DAONote();
private IDAOSnack daoSnack= new DAOSnack();




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


public void setEmf(EntityManagerFactory emf) {
	this.emf = emf;
}


public void close() {
	emf.close();
}


public IDAOBiere getDaoBiere() {
	return daoBiere;
}


public IDAOCommentaire getDaoCommentaire() {
	return daoCommentaire;
}


public IDAONote getDaoNote() {
	return daoNote;
}


public IDAOSnack getDaoSnack() {
	return daoSnack;
}







	

}
