/**
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

/**
 * The Class ClothesSuggestion.
 *
 * @author didi
 */
public class ClothesSuggestion {

	// liste pentru fiecare din cele 4 categorii deja sortate
	/** The Top suggestions. */
	private ArrayList<ClothingArticle> TopSuggestions;
	
	/** The Bottom suggestions. */
	private ArrayList<ClothingArticle> BottomSuggestions;
	
	/** The Overcoat suggestions. */
	private ArrayList<ClothingArticle> OvercoatSuggestions;
	
	/** The Accessories suggestions. */
	private ArrayList<ClothingArticle> AccessoriesSuggestions;
	
	/** The Accessories select. */
	private ArrayList<Boolean> AccessoriesSelect;	

	/** The top index. */
	private int topIndex;
	
	/** The bottom index. */
	private int bottomIndex;
	
	/** The overcoat index. */
	private int overcoatIndex;

	/**
	 * Gets the accessories select.
	 *
	 * @return the accessories select
	 */
	public ArrayList<Boolean> getAccessoriesSelect() {
		return AccessoriesSelect;
	}

	/**
	 * Sets the accessories select.
	 *
	 * @param accessoriesSelect the new accessories select
	 */
	public void setAccessoriesSelect(ArrayList<Boolean> accessoriesSelect) {
		AccessoriesSelect = accessoriesSelect;
	}

	/**
	 * Gets the top suggestions.
	 *
	 * @return the topSuggestions
	 */
	public ArrayList<ClothingArticle> getTopSuggestions() {
		return TopSuggestions;
	}

	/**
	 * Sets the top suggestions.
	 *
	 * @param topSuggestions the topSuggestions to set
	 */
	public void setTopSuggestions(ArrayList<ClothingArticle> topSuggestions) {
		TopSuggestions = topSuggestions;
	}

	/**
	 * Gets the bottom suggestions.
	 *
	 * @return the bottomSuggestions
	 */
	public ArrayList<ClothingArticle> getBottomSuggestions() {
		return BottomSuggestions;
	}

	/**
	 * Sets the bottom suggestions.
	 *
	 * @param bottomSuggestions the bottomSuggestions to set
	 */
	public void setBottomSuggestions(
			ArrayList<ClothingArticle> bottomSuggestions) {
		BottomSuggestions = bottomSuggestions;
	}

	/**
	 * Gets the overcoat suggestions.
	 *
	 * @return the overcoatSuggestions
	 */
	public ArrayList<ClothingArticle> getOvercoatSuggestions() {
		return OvercoatSuggestions;
	}

	/**
	 * Sets the overcoat suggestions.
	 *
	 * @param overcoatSuggestions the overcoatSuggestions to set
	 */
	public void setOvercoatSuggestions(
			ArrayList<ClothingArticle> overcoatSuggestions) {
		OvercoatSuggestions = overcoatSuggestions;
	}

	/**
	 * Gets the accessories suggestions.
	 *
	 * @return the accessoriesSuggestions
	 */
	public ArrayList<ClothingArticle> getAccessoriesSuggestions() {
		return AccessoriesSuggestions;
	}

	/**
	 * Sets the accessories suggestions.
	 *
	 * @param accessoriesSuggestions the accessoriesSuggestions to set
	 */
	public void setAccessoriesSuggestions(
			ArrayList<ClothingArticle> accessoriesSuggestions) {
		AccessoriesSuggestions = accessoriesSuggestions;
	}

	/**
	 * Gets the top index.
	 *
	 * @return the topIndex
	 */
	public int getTopIndex() {
		return topIndex;
	}

	/**
	 * Sets the top index.
	 *
	 * @param topIndex the topIndex to set
	 */
	public void setTopIndex(int topIndex) {
		this.topIndex = topIndex;
	}

	/**
	 * Gets the bottom index.
	 *
	 * @return the bottomIndex
	 */
	public int getBottomIndex() {
		return bottomIndex;
	}

	/**
	 * Sets the bottom index.
	 *
	 * @param bottomIndex the bottomIndex to set
	 */
	public void setBottomIndex(int bottomIndex) {
		this.bottomIndex = bottomIndex;
	}

	/**
	 * Gets the overcoat index.
	 *
	 * @return the overcoatIndex
	 */
	public int getOvercoatIndex() {
		return overcoatIndex;
	}

	/**
	 * Sets the overcoat index.
	 *
	 * @param overcoatIndex the overcoatIndex to set
	 */
	public void setOvercoatIndex(int overcoatIndex) {
		this.overcoatIndex = overcoatIndex;
	}

}
