package com.jairam.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.InputFragmentListener {

    private InputFragment inputFragment;
    private OutputFragment outputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.inputFragment, inputFragment)
                .replace(R.id.outputFragment, outputFragment)
                .commit();

    }

    @Override
    public void onInputBSent(CharSequence input) {

        outputFragment.updateTextView(input);



    }

}