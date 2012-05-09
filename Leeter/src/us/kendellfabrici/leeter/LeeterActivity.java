package us.kendellfabrici.leeter;

import us.kendellfabrici.leeter.com.LeetCommunicator;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LeeterActivity extends Activity {
	
	private EditText etInput;
	private EditText etRes;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etInput = (EditText)findViewById(R.id.etInput);
        etRes = (EditText)findViewById(R.id.etRes);        
        
    }
    
    public void btTran_Click(View v) {
    	    	
    	String input = etInput.getText().toString();
    	new LeetCom().execute(input);
    }
    
    private class LeetCom extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... input) {
			LeetCommunicator com = new LeetCommunicator();
			return com.sendMessage(input[0]);
		}
		
		protected void onPostExecute(String result) {
			etRes.setText(result);
	    }
    	
    }
    
    
}