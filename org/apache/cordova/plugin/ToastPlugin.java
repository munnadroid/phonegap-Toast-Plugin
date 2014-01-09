package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.widget.Toast;

/**
 *
 * @author munnadroid
 *
 */
public class ToastPlugin extends CordovaPlugin {

    final String TAG = ToastPlugin.class.getSimpleName();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        final String toastString = args.getString(0);
        final int toastDuration = args.getInt(1);
        final CallbackContext ctx = callbackContext;

        Runnable runnable = new Runnable() {
            public void run() {
                Toast.makeText(cordova.getActivity().getApplicationContext(), toastString, toastDuration).show();
                ctx.success();
            }
        };

        cordova.getActivity().runOnUiThread(runnable);

        return true;
    }


}
