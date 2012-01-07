/*
 * Weazzer Android Application
 * 
 */
package weazzer.wear;

import java.util.ArrayList;

import weazzer.wear.ClothingArticle.UserSex;
import weazzer.weather.WeatherData;

/**
 * The Class SuggestionEngine that provides the best match for a clothing
 * article, given the weather conditions. For each of the four clothing
 * categories (Pants, Shirt, Overcoat and Accessories), the SuggestionEngine
 * should keep different variables/parameters for the user's preferences.
 */
public class SuggestionsEngine {
	
	/** The pants heat factor. */
	private int pantsHF;
	
	/** The shirts heat factor. */
	private int shirtsHF;
	
	/** The overcoat heat factor. */
	private int overcoatHF;
	
	/** The accessories heat factor. */
	private int accessoriesHF;

	/**
	 * Gets the suggestion for a specific type of article, based on the given
	 * articles list and the weather information.
	 *
	 * @param weather the weather
	 * @param gender the gender
	 * @return the suggestion
	 */
	public ClothesSuggestion getSuggestion(WeatherData weather, UserSex gender) {
		ClothesProvider clothesProvider = new ClothesProvider();
		ClothesSuggestion CS = new ClothesSuggestion();
		CS.setBottomSuggestions(clothesProvider.getPants(gender));
		CS.setTopSuggestions(clothesProvider.getShirts(gender));
		CS.setOvercoatSuggestions(clothesProvider.getOvercoats(gender));
		CS.setAccessoriesSuggestions(clothesProvider.getAccessories(gender));
		CS.setTopIndex(0);
		CS.setBottomIndex(0);
		CS.setOvercoatIndex(0);
		ArrayList<Boolean> accesoriesSelect = new ArrayList<Boolean>();
		accesoriesSelect.add(true);
		accesoriesSelect.add(false);
		accesoriesSelect.add(true);
		CS.setAccessoriesSelect(accesoriesSelect);		
		return CS;
	}

	/**
	 * Updates the SuggestionEngine's internal variables according to the user
	 * choice for the weather.
	 *
	 * @param currentWeatherData the current weather data
	 * @param clothesSuggestion the clothes suggestion
	 */
	public void updateUserChoice(WeatherData currentWeatherData, ClothesSuggestion clothesSuggestion) {
		// TODO implementation		
	}
	
	/**
	 * Resets the AI internal parameters for clothing suggestions to factory settings.
	 */
	public void resetFactorySettings()
	{
		//TODO: implementation
	}

}
