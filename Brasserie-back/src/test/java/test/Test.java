package test;

import java.util.List;

import model.Produits;
import util.Context;

public class Test {

	public static void main(String[] args) {
		List<Produits> test = Context.getSingleton().getDaoProduits().findAll();
		System.out.println(test);
	}

}
