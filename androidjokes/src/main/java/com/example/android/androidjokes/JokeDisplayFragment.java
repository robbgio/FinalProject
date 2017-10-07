package com.example.android.androidjokes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeDisplayFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String joke = getActivity().getIntent().getStringExtra("JOKE");
        View root = inflater.inflate(R.layout.fragment_joke_display, container, false);
        TextView jokeView = (TextView) root.findViewById(R.id.joke_text);
        jokeView.setText(joke);
        return root;
    }
}
