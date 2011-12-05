/*
 * Weazzer Android Application
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

import weazzer.wear.ClothingArticle.UserSex;

/**
 * The Class ClothesProvider that obtains various ArrayLists of existent ClothingArticles.
 */
public class ClothesProvider {
	
	/** The pants for women. */
	private ArrayList<ClothingArticle> pantsWomen;
	
	/** The pants for men. */
	private ArrayList<ClothingArticle> pantsMen;
	
	/** The shirts for women. */
	private ArrayList<ClothingArticle> shirtsWomen;
	
	/** The shirts for men. */
	private ArrayList<ClothingArticle> shirtsMen;
	
	/** The overcoats for women. */
	private ArrayList<ClothingArticle> overcoatsWomen;
	
	/** The overcoats for men. */
	private ArrayList<ClothingArticle> overcoatsMen;
	
	/** The accessories for men. */
	private ArrayList<ClothingArticle> accessoriesWomen;
	
	/** The accessories for women. */
	private ArrayList<ClothingArticle> accessoriesMen;
	
	
	/**
	 * Instantiates a new clothes provider.
	 */
	public ClothesProvider() {
		pantsWomen = new ArrayList<ClothingArticle>();
		pantsMen = new ArrayList<ClothingArticle>();
		shirtsMen = new ArrayList<ClothingArticle>();
		shirtsWomen = new ArrayList<ClothingArticle>();
		overcoatsMen = new ArrayList<ClothingArticle>();
		overcoatsWomen = new ArrayList<ClothingArticle>();
		accessoriesWomen = new ArrayList<ClothingArticle>();
		accessoriesMen = new ArrayList<ClothingArticle>();
		
		//TODO: Facut intializare hard-coded (sau din baza de date, desi mi se pare mai usor hardcodat)
		//pentru fiecare haina
		//Imaginile trebuie puse in res/drawable si in ClothingArticle trebuie pus fara extensie (vezi documentatia de acolo)
	}

	/**
	 * Gets the pants, according to the user's sex.
	 *
	 * @param userSex the user sex
	 * @return the pants
	 */
	public ArrayList<ClothingArticle> getPants(UserSex userSex) {
		if(userSex.equals(UserSex.Female))
			return pantsWomen;
		else
			return pantsMen;
	}

	/**
	 * Gets the shirts, according to the user's sex.
	 *
	 * @param userSex the user sex
	 * @return the shirts
	 */
	public ArrayList<ClothingArticle> getShirts(UserSex userSex) {
		if(userSex.equals(UserSex.Female))
			return shirtsWomen;
		else
			return shirtsMen;
	}

	/**
	 * Gets the overcoats, according to the user's sex.
	 *
	 * @param userSex the user sex
	 * @return the overcoats
	 */
	public ArrayList<ClothingArticle> getOvercoats(UserSex userSex) {
		if(userSex.equals(UserSex.Female))
			return overcoatsWomen;
		else
			return overcoatsMen;
	}

	/**
	 * Gets the accessories, according to the user's sex.
	 *
	 * @param userSex the user sex
	 * @return the accessories
	 */
	public ArrayList<ClothingArticle> getAccessories(UserSex userSex) {
		if(userSex.equals(UserSex.Female))
			return accessoriesWomen;
		else
			return accessoriesMen;
	}

}
