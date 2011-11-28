package weazzer.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainPanelActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void ApasaMaButtonClickEvent(View view)
    {
    	Toast.makeText(this, "Salutare Diana, Vali, Filip & Cosmin", Toast.LENGTH_SHORT).show();
    }
    
    public void TrollClickEvent(View view)
    {
        Intent userCreationIntent = new Intent(view.getContext(), LongTermActivity.class);
        startActivityForResult(userCreationIntent, 0);
    }
}