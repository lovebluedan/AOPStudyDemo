package com.mzs.aopstudydemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by ldr
 * on 2020/1/8 9:35.
 */
public class MainJavaActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    Button button1;
    Button button2;
    Button button3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        threadTest();
                    }
                }).start();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepOn1();
                stepOn2("小明");
                stepOn3("小明", 18);
            }
        });
    }

    public void test() {
        System.out.println("Hello,I am LIN");
    }

    private void stepOn1() {
        System.out.println("stepOn1");
    }

    private void stepOn2(String name) {
        System.out.println("stepOn1");
    }

    private void stepOn3(String name, int i) {
        System.out.println("stepOn1");
    }

    public void threadTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休眠1秒");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainJavaActivity.this, "主线程弹出Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
