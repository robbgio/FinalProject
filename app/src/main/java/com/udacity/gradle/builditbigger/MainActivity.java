package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.androidjokes.JokeActivity;
import com.example.rgiordano.myapplication.backendjokes.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements JokeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //public void launchJokeActivity(View view){
    //    Intent myIntent = new Intent(this, JokeActivity.class);
    //    String joke = new JavaJokes().getJoke();
    //    myIntent.putExtra("JOKE",joke);
    //    startActivity(myIntent);
    //}

    public void tellJoke(View view) {
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
        new EndpointsAsyncTask().execute(this);
        //launchJokeActivity(view);
    }


    @Override
    public void onReceived(String joke) {
        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra("JOKE", joke);
        this.startActivity(myIntent);
    }
}

class EndpointsAsyncTask extends AsyncTask<JokeListener, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private JokeListener jokeListener;

    @Override
    protected String doInBackground(JokeListener... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://robbjokes.appspot.com/_ah/api/");
                    //.setRootUrl("http://192.168.1.66:8080/_ah/api/")
                    //.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    //    @Override
                    //    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                    //        abstractGoogleClientRequest.setDisableGZipContent(true);
                    //    }
                    //});
            // end options for devappserver

            myApiService = builder.build();
        }

        jokeListener = params[0];

        try {
            //return myApiService.sayHi(name).execute().getData();
            return myApiService.getJokeGCEapi().execute().getJokeGCE();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokeListener.onReceived(result);
    }
}

