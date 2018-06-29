package com.example.hjy.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNum();
    }

    public void randomNum(){
        Button leftBtn = (Button) findViewById(R.id.leftButton);
        Button rightBtn = (Button) findViewById(R.id.rightButton);

        Random rand = new Random();

        int num1 = 0;
        int num2 = 0;

        while (num1 == num2){
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
        }

        leftBtn.setText("" + num1);
        rightBtn.setText("" + num2);

        System.out.println("num1: " + num1 + " num2: " + num2);

    }

    public void leftBtnOnClick(View view) {
        Button btn = (Button) findViewById(R.id.leftButton);
        Toast.makeText(this,"Left Button Clicked", Toast.LENGTH_SHORT).show();
    }

    public void rightBtnOnClick(View view) {
        Button btn = (Button) findViewById(R.id.rightButton);
        Toast.makeText(this,"Right Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
