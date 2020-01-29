package com.example.getdrunk;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT1 ="com.example.application.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 ="com.example.application.example.EXTRA_TEXT2";
    public static final String EXTRA_RADIO ="com.example.application.example.EXTRA_RADIO";
    RadioGroup rg;
    RadioButton rb;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        rg =findViewById(R.id.rgroup);

        click= findViewById(R.id.submit);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionsActivity();
            }
        });

    }

    public void rClick(View v)
    {
        int radiobuttonid=rg.getCheckedRadioButtonId();
        rb=findViewById(radiobuttonid);

    }

    public void openQuestionsActivity()
    {
        EditText etext1= findViewById(R.id.Team1);
        EditText etext2= findViewById(R.id.Team2);
        String text1 = etext1.getText().toString();
        String text2 = etext2.getText().toString();



        Intent intent= new Intent(this, QuestionsActivity.class);
        intent.putExtra(EXTRA_TEXT1, text1);
        intent.putExtra(EXTRA_TEXT2, text2);
        intent.putExtra(EXTRA_RADIO, rb.getText());
        startActivity(intent);
    }

}
