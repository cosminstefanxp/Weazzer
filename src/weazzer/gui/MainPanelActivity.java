package weazzer.gui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainPanelActivity extends Activity {
	
	String gender;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	getPrefs();
    	TextView t=(TextView)findViewById(R.id.main_title); 
    	t.setText("Hi you "+gender);
    }
    
    private void getPrefs() {
            // Get the xml/preferences.xml preferences
            SharedPreferences prefs = PreferenceManager
                            .getDefaultSharedPreferences(getBaseContext());
            gender = prefs.getString("genderPref", "male");            
    }
    
    public void ApasaMaButtonClickEvent(View view)
    {
    	Toast.makeText(this, "Salutare Diana, Vali, Filip & Cosmin", Toast.LENGTH_SHORT).show();
    }
    
    public void TrollClickEvent(View view)
    {
    	Intent settingsActivity = new Intent(getBaseContext(),
    			LongTermActivity.class);
    	startActivity(settingsActivity);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.settings_menu_button:
        	Intent settingsActivity = new Intent(getBaseContext(),
        			SettingsPanelActivity.class);
        	startActivity(settingsActivity);
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public void SettingsMenuButtonClickEvent(View view)
    {
    	Intent settingsActivity = new Intent(getBaseContext(),
    			SettingsPanelActivity.class);
    	startActivity(settingsActivity);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
   
}