package com.example.getdrunk;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EndActivity extends AppCompatActivity {



    private String sieger;
    private String verlierer;
    private String punkte;
    private Button click;

    private TextView ergebnis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_end);


        Intent intent = getIntent();
        String text1 = intent.getStringExtra(QuestionsActivity.EXTRA_TEXT1);
        String text2 = intent.getStringExtra(QuestionsActivity.EXTRA_TEXT2);
        String text3 = intent.getStringExtra(QuestionsActivity.EXTRA_TEXT3);
        sieger=text1;
        verlierer=text2;
        punkte=text3;
        ergebnis=findViewById(R.id.Ergebnis);
        ergebnis.setText(verlierer+" Sie haben gewonnen mit "+punkte+"0 Punken mehr als "+sieger+"!! Folglich muss "+sieger+" "+punkte+" mal einen shot trinken!!!");
        click=findViewById(R.id.Main);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();

            }
        });
    }

    private void openActivity()
    {
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);
    }

}
