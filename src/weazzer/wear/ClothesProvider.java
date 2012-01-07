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
				R.drawable.pants1m, -16.0f);
		pantsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pants2m, 0.0f);
		pantsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pants3m, 18.0f);
		pantsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pants4m, 30.0f);
		pantsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.pants5m, 35.0f);
		pantsMen.add(clothingArticle);
				
		// pants Female
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants1f, -16.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants2f, 0.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants3f, 10.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants4f, 20.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants5f, 27.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants6f, 30.0f);
		pantsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("pantalon",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.pants7f, 35.0f);
		pantsWomen.add(clothingArticle);
		
		// TOPS Male
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt1m, 0.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt2m, 5.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt3m, 10.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt4m, 20.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt5m, 27.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt6m, 28.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt7m, 30.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt8m, 33.0f);
		shirtsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Male,
				R.drawable.shirt9m, 36.0f);
		shirtsMen.add(clothingArticle);
		
		// tops Female
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt1f, 0.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt2f, 5.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt3f, 10.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt4f, 15.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt5f, 20.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt6f, 25.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt7f, 28.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt8f, 33.0f);
		shirtsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("tricou",
				ClothingArticle.Type.Pants, UserSex.Female,
				R.drawable.shirt9f, 37.0f);
		shirtsWomen.add(clothingArticle);
		
		// OVERCOAT Male
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat1m, -16.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat2m, -10.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat3m, 0.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat4m, 5.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat5m, 10.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat6m, 12.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat7m, 15.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat8m, 18.0f);
		overcoatsMen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Male,
				R.drawable.coat0m, 25.0f);
		overcoatsMen.add(clothingArticle);
		
		// Overcoat Female
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat1f, -16.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat2f, -10.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat3f, -5.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat4f, 10.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat5f, 15.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat6f, 20.0f);
		overcoatsWomen.add(clothingArticle);
		
		clothingArticle = new ClothingArticle("geaca",
				ClothingArticle.Type.Overcoat, UserSex.Female,
				R.drawable.coat0f, 25.0f);
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
