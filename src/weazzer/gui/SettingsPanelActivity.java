package weazzer.gui;

import java.util.ArrayList;

import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherLocation;
import weazzer.weather.WeatherProvider;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.widget.Toast;

public class SettingsPanelActivity extends PreferenceActivity {
	protected static ArrayList<WeatherLocation> locations;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.preferences);

		// Prepare preference selection for location selection
		EditTextPreference countryLocationPref = (EditTextPreference) findPreference("countryLocationPref");
		EditTextPreference tmpCityLocationPref = (EditTextPreference) findPreference("tmpCityLocationPref");
		ListPreference finalCityLocationPref = (ListPreference) findPreference("cityLocationPref");
		Preference searchLocationPref = (Preference) findPreference("searchLocationPref");
		
		//Set the title accordingly
		countryLocationPref.setTitle("Country - "+countryLocationPref.getText());
		tmpCityLocationPref.setTitle("City - "+finalCityLocationPref.getValue());
		finalCityLocationPref.setSummary(finalCityLocationPref.getValue()+", "+countryLocationPref.getText());
		
		//Set Listeners
		
		finalCityLocationPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				//Get preferences for country and city
				EditTextPreference countryLocationPref = (EditTextPreference) findPreference("countryLocationPref");
				EditTextPreference cityLocationPref = (EditTextPreference) findPreference("tmpCityLocationPref");
				ListPreference cityPref = (ListPreference) findPreference("cityLocationPref");
				
				//Set accordingly
				countryLocationPref.setText(SettingsPanelActivity.locations.get(0).country);
				cityLocationPref.setText((String) newValue);
				cityPref.setSummary(newValue+", "+countryLocationPref.getText());
				
				return true;
			}
		});
		
		countryLocationPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				preference.setTitle("Country - "+newValue);
				return true;
			}
		});
		
		tmpCityLocationPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				preference.setTitle("City - "+newValue);
				return true;
			}
		});

		searchLocationPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			
			public boolean onPreferenceClick(Preference preference) {
				Toast.makeText(getBaseContext(), "Searching for your location!",
						Toast.LENGTH_SHORT).show();

				//Get preferences for country and city
				EditTextPreference countryLocationPref = (EditTextPreference) findPreference("countryLocationPref");
				EditTextPreference cityLocationPref = (EditTextPreference) findPreference("tmpCityLocationPref");
				ListPreference cityPref = (ListPreference) findPreference("cityLocationPref");
				
				//Set the title accordingly
				countryLocationPref.setTitle("Country - "+countryLocationPref.getText());
				cityLocationPref.setTitle("City - "+cityLocationPref.getText());
				
				//Search for the given suggestion
				WeatherProvider weatherProvider=new DummyProvider();
				SettingsPanelActivity.locations=weatherProvider.getSuggestedLocation(countryLocationPref.getText(), cityLocationPref.getText());
				
				if(SettingsPanelActivity.locations==null || SettingsPanelActivity.locations.isEmpty())
				{
					Toast.makeText(getBaseContext(), "No location was found with the given country and city name. Please try again!",
							Toast.LENGTH_LONG).show();
				}
				else
				{
					String[] suggestedCities=new String[SettingsPanelActivity.locations.size()];
					//Prepare the list of cities
					for(int i=0; i<SettingsPanelActivity.locations.size(); i++)
					{
						suggestedCities[i]=SettingsPanelActivity.locations.get(i).city;
					}
					
					//Set the city list
					cityPref.setEntryValues(suggestedCities);
					cityPref.setEntries(suggestedCities);
					cityPref.setEnabled(true);
					cityPref.setValueIndex(0);
					
					Toast.makeText(getBaseContext(), "Select the city from the list above!",
							Toast.LENGTH_LONG).show();
				}
				
				return true;
			}

		});
	}
}