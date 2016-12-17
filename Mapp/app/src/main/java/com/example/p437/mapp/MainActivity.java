package com.example.p437.mapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button butto;
    Button butto2;
    EditText name;
    Toast toast;
    SharedPreferences sPref;
    SharedPreferences sPref2;
    SharedPreferences sPref3;
    int i=0;

    final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT2 = "saved_text2";
    final String SAVED_TEXT3 = "saved_text3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.etN);
        butto2 = (Button) findViewById(R.id.button);
        butto = (Button) findViewById(R.id.btnAdd);
        Num.namber=6;
        Num.rand = 1 + (int) (Math.random() * 10);

        loadText();
        butto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = new String();
                String m = new String();

                if(Num.rand==1) s = "Mexico";
                if(Num.rand==2) s = "Russia";
                if(Num.rand==3) s = "Pakistan";
                if(Num.rand==4) s = "Korea";
                if(Num.rand==5) s = "England";
                if(Num.rand==6) s = "Japan";
                if(Num.rand==7) s = "Arab Emirates";
                if(Num.rand==8) s = "Italia";
                if(Num.rand==9) s = "Egypt";
                if(Num.rand==10) s = "India";

                m = String.valueOf(name.getText());
                if (m.equals(s)) {
                    Num.bal++;
                        toast = Toast.makeText(MainActivity.this, Integer.toString(Num.bal), Toast.LENGTH_LONG);
                        toast.show();
                    Num.rand = 1 + (int) (Math.random() * 10);
                    Num.namber = 6;
                    name.setText("");
                    }

                else {
                    Num.namber--;
                    toast = Toast.makeText(MainActivity.this, Integer.toString(Num.namber), Toast.LENGTH_LONG);
                    toast.show();
                }

                if (Num.namber==0){
                    sendMessage2();
                    Num.bal=0;
                    Num.namber=6;
                }

                saveText();
            }
        });

       /* Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);*/
    }

    public void sendMessage() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void sendMessage2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    private void saveText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        sPref2 = getSharedPreferences("MyPref2", MODE_PRIVATE);
        sPref3 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        SharedPreferences.Editor ed2 = sPref2.edit();
        SharedPreferences.Editor ed3 = sPref3.edit();
        ed.putInt(SAVED_TEXT, Num.bal);
        ed2.putInt(SAVED_TEXT2, Num.namber);
        ed3.putInt(SAVED_TEXT3, i);
        ed.commit();
        ed2.commit();
        ed3.commit();
        i++;
      //  Toast.makeText(MainActivity.this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        sPref2 = getSharedPreferences("MyPref2", MODE_PRIVATE);
        sPref3 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        int savedText = sPref.getInt(SAVED_TEXT,1);
        int savedText2 = sPref2.getInt(SAVED_TEXT2,1);
        int savedText3 = sPref3.getInt(SAVED_TEXT3,1);
       // etText.setText(savedText);
       // Toast.makeText(MainActivity.this, "Text loaded", Toast.LENGTH_SHORT).show();
        i = savedText3;
        Num.bal = savedText;
        if(i==0)
            Num.namber =12;
        if (i>0)
        Num.namber = savedText2;
       // Num.rand = savedText3;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
