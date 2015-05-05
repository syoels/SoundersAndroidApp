package com.example.musicsaround;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView.OnEditorActionListener;
import android.view.*;
import android.app.DialogFragment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class Login extends ActionBarActivity {

    static String usern = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_login);



        setContentView(R.layout.activity_login);

        // Initilize users DB object
        final usersDB db = new usersDB();

        // Check if the user pressed the send button after filling in his password
        EditText editText = (EditText) findViewById(R.id.Password);



        editText.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                // Pressed send
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    // Get login values:
                    // Get username
                    EditText myEditTextUser = (EditText)findViewById(R.id.Username);
                    String username = myEditTextUser.getText().toString();
                    usern = username;


                    // Get password
                    EditText myEditTextPass = (EditText)findViewById(R.id.Password);
                    String password = myEditTextPass.getText().toString();

                    // Handle login
                    handleLogin(username, password, db);
                    handled = true;

                }

                return handled;
            }
        });
    }


    public boolean handleLogin(String username, String password, usersDB db){

        /// Dialog

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Problem with Login");
        alertDialog.setMessage("Wrong username or password");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // here you can add functions
            }
        });


        /// End dialog
        User curUser= db.getUser(username);

        // ERROR: Username does not exist in db or wrong password
        if ((curUser == null)||!(curUser.getPassword().equals(password))){
            alertDialog.show();
        }
        // Successful login, move to next page
        else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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