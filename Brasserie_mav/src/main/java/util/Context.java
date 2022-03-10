package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOAchat;
import dao.DAOBiere;
import dao.DAOBrasseur;
import dao.DAOClient;
import dao.DAOCommentaire;
import dao.DAOInfoReglement;
import dao.DAOIngredient;
import dao.DAONote;
import dao.DAOSnack;
import dao.IDAOAchat;
import dao.IDAOBiere;
import dao.IDAOBrasseur;
import dao.IDAOClient;
import dao.IDAOCommentaire;
import dao.IDAOInfoReglement;
import dao.IDAOIngredient;
import dao.IDAONote;
import dao.IDAOSnack;
import dao.DAOEvenements;
import dao.IDAOEvenements;




public class Context {


	private static Context _singleton=null;	
	private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("demoJPA");
	private IDAOBiere daoBiere= new DAOBiere();
	private IDAOCommentaire daoCommentaire= new DAOCommentaire();
	private IDAONote daoNote= new DAONote();
	private IDAOSnack daoSnack= new DAOSnack();
	private IDAOIngredient daoIngredient = new DAOIngredient();
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOBrasseur daoBrasseur = new DAOBrasseur();
	private IDAOClient daoClient = new DAOClient();
	private IDAOInfoReglement daoReglement = new DAOInfoReglement();
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


	public IDAOIngredient getDaoIngredient() {
		return daoIngredient;
	}


	public IDAOAchat getDaoAchat() {
		return daoAchat;
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
	
	public IDAOEvenements getDaoEvenements() {
		return daoEvenements;
	}
}
