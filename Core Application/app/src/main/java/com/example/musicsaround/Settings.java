package com.example.musicsaround;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;

import com.example.musicsaround.Login;


public class Settings extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_settings);

        setContentView(R.layout.activity_settings);

        // Get current user
        usersDB db = new usersDB();
        User curUser = db.getUser(Login.usern);

        Context c = getApplicationContext();
        Resources r = c.getResources();
        int icn_id = r.getIdentifier("my_profile_img", "drawable", c.getPackageName());
        Log.i("icn_id",""+icn_id);
        ImageView icn = (ImageView) findViewById(R.id.profilePic);
        icn.setImageResource(icn_id);

        // Show username
        TextView textView = (TextView) findViewById(R.id.userName);
        textView.setText(curUser.getUsername());

        // Show about
        TextView textViewAbout = (TextView) findViewById(R.id.About);
        textViewAbout.setText(curUser.getAbout());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
