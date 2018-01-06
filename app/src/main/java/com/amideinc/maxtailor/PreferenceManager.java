package com.amideinc.maxtailor;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Dell on 1/3/2018.
 */

public class PreferenceManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        this.context = context;
        getSharedPerefence();

    }
    private void getSharedPerefence() {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_prefence), Context.MODE_PRIVATE);
    }
    public void writePrefence() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_prefence_key), "INIT_OK");
        editor.commit();
    }
    public  boolean checkPreference() {
        boolean status = false;
        if(sharedPreferences.getString(context.getString(R.string.my_prefence_key), "null").equals("null")) {

            status = false;
        } else {
            status = true;
        }
        return status;
    }
    public  void clearPrefence() {
        sharedPreferences.edit().clear().commit();
    }
}
