package com.atguigu.testafinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import java.io.File;

public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void getDete(View view){
        FinalHttp fh = new FinalHttp();
        fh.get("https://github.com/yangfuhai/afinal", new AjaxCallBack(){

            @Override
            public void onLoading(long count, long current) { //每1秒钟自动被回调一次
                textView.setText(current+"/"+count);
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                textView.setText(o.toString());
            }

            @Override
            public void onStart() {
                //开始http请求的时候回调
            }

        });
    }

    public void downloadFile(View view){
        FinalHttp fh = new FinalHttp();
        fh.download("http://192.168.21.165:8080/oppo.mp4", "/mnt/sdcard/afinloop.mp4", new AjaxCallBack<File>() {
            @Override
            public void onSuccess(File file) {
                super.onSuccess(file);
                Toast.makeText(MainActivity.this,"下载成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public AjaxCallBack<File> progress(boolean progress, int rate) {
                return super.progress(progress, rate);
            }

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(MainActivity.this,"onStart",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public int getRate() {
                return super.getRate();
            }
        });

//
    }
}
