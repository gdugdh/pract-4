package com.example.pract_4;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v) {

        // Integer.parseInt(etInput.getText().toString());
        // tvInfo.setText(getResources().getString(R.string.ahead));

        if (!gameFinished) {
            if (etInput.getText().toString().equals("")) {
                tvInfo.setText(getResources().getString(R.string.error));
            } else {
                int num = Integer.parseInt(etInput.getText().toString());

                if (num > 100 || num < 0) {
                    tvInfo.setText(getResources().getString(R.string.error));
                } else {
                    if (num > guess) {
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    }
                    if (num < guess) {
                        tvInfo.setText(getResources().getString(R.string.behind));
                    }
                    if (num == guess) {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        gameFinished = true;
                    }
                }
            }

        } else {
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_goes));
            etInput.setText("");
            gameFinished = false;
        }
    }
}
