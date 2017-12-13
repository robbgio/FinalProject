package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by rgiordano on 12/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> implements JokeListener {

    private String joke;

    public EndpointsAsyncTaskTest(){
        super(Application.class);
    }

    @Test
    public void onPostExecute() throws ExecutionException, InterruptedException {
        new EndpointsAsyncTask().execute(this).get();
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
        Log.d("Joke:",joke);
    }
    @Override
    public void onReceived(String joke) {
        this.joke=joke;
    }
}