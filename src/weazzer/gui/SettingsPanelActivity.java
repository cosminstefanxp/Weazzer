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
		EditTextPreference cityLocationPref = (EditTextPreference) findPreference("cityLocationPref");
		ListPreference finalLocationPref = (ListPreference) findPreference("locationPref");
		Preference searchLocationPref = (Preference) findPreference("searchLocationPref");

		// Set the title accordingly, if a selection was already made
		if (finalLocationPref.getValue()!=null) {
			//Get the selected value
			String[] locations=finalLocationPref.getValue().split("[ ,]");
			//Check if it's ok
			if(locations.length!=3)
			{
				Toast.makeText(getBaseContext(), "Illegal value for location! Resetting!", Toast.LENGTH_SHORT).show();
				finalLocationPref.setValue(null);
			}

			//Set stuff accordingly
			countryLocationPref.setText(locations[2]);
			cityLocationPref.setText(locations[0]);
			finalLocationPref.setSummary(locations[0] + ", " + locations[2]);
			finalLocationPref.setEnabled(true);
		}

		// Set Listeners
		finalLocationPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				// Get preferences for country and city
				EditTextPreference countryLocationPref = (EditTextPreference) findPreference("countryLocationPref");
				EditTextPreference cityLocationPref = (EditTextPreference) findPreference("cityLocationPref");
				ListPreference locationPref = (ListPreference) findPreference("locationPref");

				// Set accordingly
				String[] locations=((String)newValue).split("[ ,]");				
				countryLocationPref.setText(locations[2]);
				cityLocationPref.setText(locations[0]);	
				countryLocationPref.setTitle("Country - " + countryLocationPref.getText());
				cityLocationPref.setTitle("City - " + cityLocationPref.getText());
				locationPref.setSummary(locations[0] + ", " + locations[2]);

				return true;
			}
		});

		searchLocationPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				Toast.makeText(getBaseContext(), "Searching for your location!", Toast.LENGTH_SHORT).show();

				// Get preferences for country and city
				EditTextPreference countryLocationPref = (EditTextPreference) findPreference("countryLocationPref");
				EditTextPreference cityLocationPref = (EditTextPreference) findPreference("cityLocationPref");
				ListPreference locationPref = (ListPreference) findPreference("locationPref");

				// Search for the given suggestion
				WeatherProvider weatherProvider = new DummyProvider();
				SettingsPanelActivity.locations = weatherProvider.getSuggestedLocation(countryLocationPref
						.getText(), cityLocationPref.getText());

				if (SettingsPanelActivity.locations == null || SettingsPanelActivity.locations.isEmpty()) {
					Toast.makeText(getBaseContext(),
							"No location was found with the given country and city name. Please try again!",
							Toast.LENGTH_LONG).show();
				} else {
					String[] suggestedLocations = new String[SettingsPanelActivity.locations.size()];
					// Prepare the list of cities
					for (int i = 0; i < SettingsPanelActivity.locations.size(); i++) {
						suggestedLocations[i] = SettingsPanelActivity.locations.get(i).city+", "+SettingsPanelActivity.locations.get(i).country;
					}

					// Set the city list
					locationPref.setEntryValues(suggestedLocations);
					locationPref.setEntries(suggestedLocations);
					locationPref.setEnabled(true);
					locationPref.setValueIndex(0);
					locationPref.setSummary(suggestedLocations[0]);

					Toast.makeText(getBaseContext(), "Select the location from the list above!",
							Toast.LENGTH_LONG).show();
				}

				return true;
			}

		});
	}
}