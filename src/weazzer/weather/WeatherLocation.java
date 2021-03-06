/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

/**
 * The Class WeatherLocation.
 */
public class WeatherLocation {

	/** The city. */
	public String city = "";

	/** The country. */
	public String country = "";
	
	/**
	 * Instantiates a new weather location.
	 * 
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param country
	 *            the state            
	 */
	public WeatherLocation(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	/**
	 * Instantiates a new weather location.
	 */
	public WeatherLocation() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("WeatherLocation [city=%s, country=%s]", city, country);
	}
}
