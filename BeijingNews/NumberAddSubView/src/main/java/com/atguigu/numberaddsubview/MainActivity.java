package com.atguigu.numberaddsubview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private NumberAddSubView nunber_add_sub_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nunber_add_sub_view = (NumberAddSubView) findViewById(R.id.nunber_add_sub_view);
        nunber_add_sub_view.setOnNumberClickListener(new NumberAddSubView.OnNumberClickListener() {
            @Override
            public void onButtonSub(View view, int value) {
                Toast.makeText(MainActivity.this, "view==" + view + ",value==" + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onButtonAdd(View view, int value) {
                Toast.makeText(MainActivity.this, "view==" + view + ",value==" + value, Toast.LENGTH_SHORT).show();

            }
        });

//        nunber_add_sub_view.setValue(5);
//        nunber_add_sub_view.setMaxValue(13);
//        nunber_add_sub_view.setMinValue(2);
    }
}
