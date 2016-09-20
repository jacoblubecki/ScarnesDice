package com.ahn.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // UI Elements
    TextView text;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
    }

    public void roll(View view) {
        int rolledNumber = (int) (Math.random() * 6) + 1;

        text.setText(String.valueOf(rolledNumber));
        // text.setText(rolledNumber + "");
    }
}
