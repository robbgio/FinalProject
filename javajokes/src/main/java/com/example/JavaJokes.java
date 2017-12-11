package com.example;

public class JavaJokes {

    private String[] jokes = new String[]{
            "Q: What do ghosts eat for supper?\n" + "A: Spooketi",
            "Q: What kind of exercise do lazy people do?\n" + "A: Diddly-squats."
    };

    //public static void main(String[] args) {
    //    JavaJokes test = new JavaJokes();
    //    String temp = test.getJoke();
    //    System.out.println(temp);
    //}

    public String getJoke(){
        int jokeIndex = (int) (Math.random()*2);
        //return "Q: What do ghosts eat for supper?\n" +
        //        " A: Spooketi";
        //System.out.println("Joke Index: " + jokeIndex);
        return jokes[jokeIndex];
    }
}
