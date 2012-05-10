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
    
    /**
     * This is the button click event, which kicks of the translation.
     * @param v
     */
    public void btTran_Click(View v) {
    	    	
    	String input = etInput.getText().toString();
    	new LeetCom().execute(input);
    }
    
    /**
     * This is the AsyncTask class.
     * @author kendell
     *
     */
    private class LeetCom extends AsyncTask<String, Void, String> {
    	
    	/**
    	 * The function that is run once the asynctask is kicked off.
    	 */
		@Override
		protected String doInBackground(String... input) {
			//The LeetCommunicator is where the socket communication happens.
			LeetCommunicator com = new LeetCommunicator();
			return com.sendMessage(input[0]);
		}
		
		/**
		 * The AsyncTask callback which handles marshalling the result to the main GUI thread.
		 */
		protected void onPostExecute(String result) {
			etRes.setText(result);
	    }
    	
    }
    
    
}