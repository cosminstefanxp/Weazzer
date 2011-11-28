/*
 * Weazzer Android Application
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

import weazzer.weather.WeatherData;

/**
 * The Class SuggestionEngine that provides the best match for a clothing article, given the weather conditions.
 * For each of the four clothing categories (Pants, Shirt, Overcoat and Accessories), the SuggestionEngine should
 * keep different variables for the user's preferences.
 */
public abstract class SuggestionsEngine {
	
	/**
	 * Gets the suggestion for a specific type of article, based on the given articles list and 
	 * the weather information. 
	 *
	 * @param type the type of the article the suggestion is being made for
	 * @param articles the usable articles
	 * @param weather the weather
	 * @return the suggestion
	 */
	public ClothingArticle getSuggestion(ClothingArticle.Type type,
			ArrayList<ClothingArticle> articles, WeatherData weather) {
		// TODO: Implementation
		return null;
	}

	/**
	 * Gets the suggestion for matching accesories, based on the given articles list and 
	 * the weather information. 
	 *
	 * @param accesories the usable accesories
	 * @param weather the weather
	 * @return the recommended accesories
	 */
	public ArrayList<ClothingArticle> getAccesories(ArrayList<ClothingArticle> accesories,
			WeatherData weather) {
		// TODO: Implementation
		return null;
	}
	
	/**
	 * Updates the SuggestionEngine's internal variables according to the user choice for the weather. Clothing 
	 * type is obtained from the ClothingArticle.
	 *
	 * @param article the chosen article
	 * @param weather the weather
	 */
	public void updateUserChoice(ClothingArticle article, WeatherData weather)
	{
		//TODO: Implementation
	}

}
