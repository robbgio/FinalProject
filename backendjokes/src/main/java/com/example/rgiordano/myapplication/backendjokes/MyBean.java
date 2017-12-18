package com.example.rgiordano.myapplication.backendjokes;

import com.example.JavaJokes;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {
    private JavaJokes javajoke = new JavaJokes();
    private String myData;
    public String joke;

    public String getJokeGCE(){
        return javajoke.getJoke();
    }
}