package com.example.first_app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
//    public static final int SERVER_PORT = 65000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    /* FROM HERE OLD CODE
    /** Called when the user taps the Setup button to transfer the message*/

    public void enterSetup (View view) {
        Intent setup = new Intent(this, DisplayMessageActivity.class);
        startActivity(setup);
    }

    /**
     * background process for connecting to RPI and sending get request
     */



    private class Background_get extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params){
            try{
                /* Change IP to IP set in arduino sketch

                 */
                URL url = new URL("http://192.168.1.148/?" + params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    result.append(inputLine).append("\n");

                in.close();
                connection.disconnect();
                return result.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    /** Called when user taps the "workout" button*/
    public void enterWorkout (View view) {
        // enter new screen in response to button
        Intent workout = new Intent(this, Workout.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(workout);
    }

    public void enterHistory (View view) {
        Intent history = new Intent(this, History.class);
        startActivity(history);
    }



}
