package com.example.calculator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button  zero, one, two, three ,four, five, six, seven, eight, nine, plus, minus, mul, percent, dot, divide, Ac, equal,brackets;
    ImageButton back;
    TextView textViewOut, textViewIn;
    String process,result;
    Boolean check = false;
    MediaPlayer mediaPlayer,mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.multiplication);
        percent = findViewById(R.id.percentage);
        dot = findViewById(R.id.dot);
        divide = findViewById(R.id.divide);
        Ac = findViewById(R.id.AllClear);
        equal = findViewById(R.id.equal);
        brackets = findViewById(R.id.brackets);
        back = findViewById(R.id.back);

        textViewIn = findViewById(R.id.input);
        textViewOut = findViewById(R.id.output);
        mediaPlayer = MediaPlayer.create(this,R.raw.click);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.clicko);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"0");
                mediaPlayer.start();

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"1");
                mediaPlayer.start();

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"2");
                mediaPlayer.start();

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"3");
                mediaPlayer.start();

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"4");
                mediaPlayer.start();

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"5");
                mediaPlayer.start();

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"6");
                mediaPlayer.start();

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"7");
                mediaPlayer.start();

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"8");
                mediaPlayer.start();

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process+"9");
                mediaPlayer.start();
            }
        });
        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewIn.setText("");
                textViewOut.setText("");
                mediaPlayer2.start();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "+");
                mediaPlayer2.start();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "-");
                mediaPlayer2.start();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "x");
                mediaPlayer2.start();
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "/");
                mediaPlayer2.start();
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + "%");
                mediaPlayer2.start();
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewIn.getText().toString();
                textViewIn.setText(process + ".");
                mediaPlayer.start();
            }
        });
        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
                process = textViewIn.getText().toString();
                if(check){
                    textViewIn.setText(process+")");
                    check = false;
                }
                else{
                    textViewIn.setText(process+"(");
                    check =true;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                try{
                    process=textViewIn.getText().toString();
                    process=process.substring(0,process.length()-1);
                    textViewIn.setText(process);
                }
                catch (Exception e){
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
                if (textViewIn.length() == textViewOut.length()) {
                    textViewOut.setText("");
                }
                else
                    {

                    process = textViewIn.getText().toString();
                    process = process.replace("x", "*");
                    process = process.replace("%", "/100*");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        result = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "...please check the value you entered", Toast.LENGTH_LONG).show();
                        result = "0";
                    }
                    textViewOut.setText(result);
                }
            }
        });
    }
}