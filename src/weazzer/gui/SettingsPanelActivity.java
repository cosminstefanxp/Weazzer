package weazzer.gui;
 
import android.os.Bundle;
import android.preference.PreferenceActivity;
 
public class SettingsPanelActivity extends PreferenceActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.layout.preferences);              
        }
}