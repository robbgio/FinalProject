package com.example;

public class JavaJokes {

    private String[] jokes = new String[]{
            "Q: What do ghosts eat for supper?\n\nA: Spooketi",
            "Q: What kind of exercise do lazy people do?\n\nA: Diddly-squats.",
            "Q: What's the worst thing about being lonely?\n\nA. Playing Frisbee.",
            "Q: Why did the physics teacher break up with the biology teacher?\n\nA: There was no chemistry.",
            "Q: Grandpa, why don't you have any life insurance?\n\nA: So you can all be really sad when I die.",
            "One state official to the other: I don't know what people have against us - We haven't done anything.",
            "Patient: Oh doctor, I'm just so nervous. This is my first operation.\n\nDoctor: Don't worry. Mine too.",
            "Q: Can a kangaroo jump higher than a house?\n\nA: Of course, a house doesn't jump at all.",
            "Q: Anton, do you think I'm a bad mother?\n\nA: My name is Paul.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away."
    };

    public static void main(String[] args) {
        JavaJokes test = new JavaJokes();
        String temp = test.getJoke();
        System.out.println(temp);
    }

    public String getJoke(){
        int jokeIndex = (int) (Math.random()*10);
        //return "Q: What do ghosts eat for supper?\n" +
        //        " A: Spooketi";
        //System.out.println("Joke Index: " + jokeIndex);
        return jokes[jokeIndex];
    }
}
