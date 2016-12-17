package com.example.p437.mapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends ActionBarActivity {

    TextView textView;
    Button butto;
    Animation anim = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.textView);
        butto = (Button) findViewById(R.id.btn6);

        textView.setText("Вы проиграли");
        registerForContextMenu(textView);
        anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
        textView.startAnimation(anim);

        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
