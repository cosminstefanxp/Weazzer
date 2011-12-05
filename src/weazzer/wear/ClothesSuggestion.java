/**
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

/**
 * @author didi
 *
 */
public class ClothesSuggestion {
	
	//liste pentru fiecare din cele 4 categorii deja sortate
	ArrayList<ClothingArticle> TopSuggestions;
	ArrayList<ClothingArticle> BottomSuggestions;
	ArrayList<ClothingArticle> OvercoatSuggestions;
	ArrayList<ClothingArticle> AccessoriesSuggestions;
	
	int topIndex;
	int bottomIndex;
	int overcoatIndex;
	
	/**
	 * @return the topSuggestions
	 */
	public ArrayList<ClothingArticle> getTopSuggestions() {
		return TopSuggestions;
	}
	/**
	 * @param topSuggestions the topSuggestions to set
	 */
	public void setTopSuggestions(ArrayList<ClothingArticle> topSuggestions) {
		TopSuggestions = topSuggestions;
	}
	/**
	 * @return the bottomSuggestions
	 */
	public ArrayList<ClothingArticle> getBottomSuggestions() {
		return BottomSuggestions;
	}
	/**
	 * @param bottomSuggestions the bottomSuggestions to set
	 */
	public void setBottomSuggestions(ArrayList<ClothingArticle> bottomSuggestions) {
		BottomSuggestions = bottomSuggestions;
	}
	/**
	 * @return the overcoatSuggestions
	 */
	public ArrayList<ClothingArticle> getOvercoatSuggestions() {
		return OvercoatSuggestions;
	}
	/**
	 * @param overcoatSuggestions the overcoatSuggestions to set
	 */
	public void setOvercoatSuggestions(
			ArrayList<ClothingArticle> overcoatSuggestions) {
		OvercoatSuggestions = overcoatSuggestions;
	}
	/**
	 * @return the accessoriesSuggestions
	 */
	public ArrayList<ClothingArticle> getAccessoriesSuggestions() {
		return AccessoriesSuggestions;
	}
	/**
	 * @param accessoriesSuggestions the accessoriesSuggestions to set
	 */
	public void setAccessoriesSuggestions(
			ArrayList<ClothingArticle> accessoriesSuggestions) {
		AccessoriesSuggestions = accessoriesSuggestions;
	}
	/**
	 * @return the topIndex
	 */
	public int getTopIndex() {
		return topIndex;
	}
	/**
	 * @param topIndex the topIndex to set
	 */
	public void setTopIndex(int topIndex) {
		this.topIndex = topIndex;
	}
	/**
	 * @return the bottomIndex
	 */
	public int getBottomIndex() {
		return bottomIndex;
	}
	/**
	 * @param bottomIndex the bottomIndex to set
	 */
	public void setBottomIndex(int bottomIndex) {
		this.bottomIndex = bottomIndex;
	}
	/**
	 * @return the overcoatIndex
	 */
	public int getOvercoatIndex() {
		return overcoatIndex;
	}
	/**
	 * @param overcoatIndex the overcoatIndex to set
	 */
	public void setOvercoatIndex(int overcoatIndex) {
		this.overcoatIndex = overcoatIndex;
	}
	
	
	
	

}
