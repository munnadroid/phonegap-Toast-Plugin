package com.phonegap.munnadroid.plugin;

import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LegacyContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import com.phonegap.api.Plugin;
import android.widget.Toast;

public class ToastPlugin extends Plugin {

	@Override 
	public PluginResult execute(String action, JSONArray data, String callback) {
		
		int tmpDuration;
		String tmpText = "none";f
		
		try {
			tmpText = data.getString(0);
		} catch (JSONException e) {
			return new PluginResult(Status.ERROR, "Parsing Text Exception");
		} 
		try {
			tmpDuration = data.getInt(1);
		} catch (JSONException e) {
			return new PluginResult(Status.ERROR, "Parsing Duration Exception");
		}
		
		final String Text = tmpText;
		final int Duration = tmpDuration;
		final CordovaInterface currentCtx = ctx;
		 
		
		Runnable runnable = new Runnable() { 
			public void run() {
				Toast.makeText(cordova.getActivity().getApplicationContext() ,Text, Duration).show();
			 }
		}; 
		
		cordova.getActivity().runOnUiThread(runnable);
		
		return new PluginResult(Status.OK);
	}

}
