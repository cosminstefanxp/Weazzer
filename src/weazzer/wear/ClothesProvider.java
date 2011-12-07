/*
 * Weazzer Android Application
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

import weazzer.gui.R;

import weazzer.wear.ClothingArticle.UserSex;

/**
 * The Class ClothesProvider that obtains various ArrayLists of existent
 * ClothingArticles.
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

		ClothingArticle clothingArticle;
		
		// PANTS Male
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pantalon1, 2.0f);
		pantsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pantalon2, 2.0f);
		pantsMen.add(clothingArticle);
				
		// pants Female
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.skirt1, 2.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.skirt2, 2.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pantalon2, 2.0f);
		pantsWomen.add(clothingArticle);
		
		// TOPS Male
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.tricou1m, 2.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.tricou2m, 2.0f);
		shirtsMen.add(clothingArticle);
		
		// tops Female
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.tricou1f, 2.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.tricou2f, 2.0f);
		shirtsWomen.add(clothingArticle);
		
		// OVERCOAT Male
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat1m, 2.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat2m, 2.0f);
		overcoatsMen.add(clothingArticle);
		
		// Overcoat Female
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat1f, 2.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat2f, 2.0f);
		overcoatsWomen.add(clothingArticle);
		
		// ACCESSORIES Male
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Male,
				R.drawable.glassesm, R.drawable.glassesm_g, 2.0f);
		accessoriesMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Male,
				R.drawable.hatm, R.drawable.hatm_g, 2.0f);
		accessoriesMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Male,
				R.drawable.umbrella, R.drawable.umbrella_g, 2.0f);
		accessoriesMen.add(clothingArticle);
		
		// Accessories Female
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Female,
				R.drawable.glassesf, R.drawable.glassesf_g, 2.0f);
		accessoriesWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Female,
				R.drawable.hatf, R.drawable.hatf_g, 2.0f);
		accessoriesWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("accesoriu",
				ClothingArticle.Type.Accessory, UserSex.Female,
				R.drawable.umbrella, R.drawable.umbrella_g, 2.0f);
		accessoriesWomen.add(clothingArticle);
		
	}

	/**
	 * Gets the pants, according to the user's sex.
	 * 
	 * @param userSex
	 *            the user sex
	 * @return the pants
	 */
	public ArrayList<ClothingArticle> getPants(UserSex userSex) {
		if (userSex.equals(UserSex.Female))
			return pantsWomen;
		else
			return pantsMen;
	}

	/**
	 * Gets the shirts, according to the user's sex.
	 * 
	 * @param userSex
	 *            the user sex
	 * @return the shirts
	 */
	public ArrayList<ClothingArticle> getShirts(UserSex userSex) {
		if (userSex.equals(UserSex.Female))
			return shirtsWomen;
		else
			return shirtsMen;
	}

	/**
	 * Gets the overcoats, according to the user's sex.
	 * 
	 * @param userSex
	 *            the user sex
	 * @return the overcoats
	 */
	public ArrayList<ClothingArticle> getOvercoats(UserSex userSex) {
		if (userSex.equals(UserSex.Female))
			return overcoatsWomen;
		else
			return overcoatsMen;
	}

	/**
	 * Gets the accessories, according to the user's sex.
	 * 
	 * @param userSex
	 *            the user sex
	 * @return the accessories
	 */
	public ArrayList<ClothingArticle> getAccessories(UserSex userSex) {
		if (userSex.equals(UserSex.Female))
			return accessoriesWomen;
		else
			return accessoriesMen;
	}

}
