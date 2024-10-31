package com.example.pacak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ImageView> listaWidokowJablka = new ArrayList<>();
CountDownTimer countDownTimer;
int czas=10*1000;
int punkty;
TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView2);
        listaWidokowJablka.add(findViewById(R.id.imageView));
        listaWidokowJablka.add(findViewById(R.id.imageView2));
        listaWidokowJablka.add(findViewById(R.id.imageView3));
        listaWidokowJablka.add(findViewById(R.id.imageView4));
        listaWidokowJablka.add(findViewById(R.id.imageView5));
        listaWidokowJablka.add(findViewById(R.id.imageView6));
        listaWidokowJablka.add(findViewById(R.id.imageView7));
        listaWidokowJablka.add(findViewById(R.id.imageView8));
        listaWidokowJablka.add(findViewById(R.id.imageView9));

        ukryjJablka();
        pokazLosoweJablko();
        odliczanieCzasu();
    }
    private void pokazLosoweJablko(){
        int losowa=(int)(Math.random()*9);
        listaWidokowJablka.get(losowa).setVisibility(View.VISIBLE);
        listaWidokowJablka.get(losowa).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setVisibility(View.INVISIBLE);
                        punkty++;
                        textView.setText(String.valueOf(punkty));
                        countDownTimer.cancel();
                        odliczanieCzasu();
                    }
                }
        );
    }

    private void odliczanieCzasu(){
        countDownTimer=new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long l) {
                ukryjJablka();
                pokazLosoweJablko();
                czas=(int)l;
            }

            @Override
            public void onFinish() {
ukryjJablka();
            }
        };
        countDownTimer.start();
    }

    private void ukryjJablka(){
        for (int i = 0; i < listaWidokowJablka.size(); i++) {
            listaWidokowJablka.get(i).setVisibility(View.INVISIBLE);
        }
    }
}