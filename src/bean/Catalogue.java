package bean;

import java.util.HashMap;

public class Catalogue {

	private static Catalogue catalogue;
	private String nom;
	private HashMap<String, Produit> listProduit;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HashMap<String, Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(HashMap<String, Produit> listProduit) {
		this.listProduit = listProduit;
	}
public static Catalogue getInstance(){
	if(catalogue==null){
		catalogue=new Catalogue();
	}
	return catalogue;
	
	
}


}
