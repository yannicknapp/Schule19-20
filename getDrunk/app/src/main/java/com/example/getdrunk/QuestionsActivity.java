package com.example.getdrunk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {


    public static final String EXTRA_TEXT1 ="com.example.application.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 ="com.example.application.example.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 ="com.example.application.example.EXTRA_TEXT3";
    public static final String EXTRA_RADIO ="com.example.application.example.EXTRA_RADIO";

    public static TextView data;
    public static TextView a1;
    public static TextView a2;
    public static TextView a3;
    public static TextView a4;

    private int max=100;
    private TextView spieler;
    private RadioGroup rg;
    private RadioButton rb;
    private TextView antwort;
    private Button weiter;
    private Button click;
    private String tex1;
    private String tex2;
    private String textradio;
    public static int team;
    public static int punkteteam1;
    public static int punkteteam2;
    private TextView streak;
    static int count1;
    static int count2;
    private TextView clock;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_questions);


        Intent intent = getIntent();
        String text1 = intent.getStringExtra(MainActivity.EXTRA_TEXT1);
        String text2 = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        String textradio = intent.getStringExtra(MainActivity.EXTRA_RADIO);
        tex1=text1;
        tex2=text2;
        this.textradio=textradio;
        data = (TextView) findViewById(R.id.Fragen);
        a1 = (TextView) findViewById(R.id.checkBox);
        a2 = (TextView) findViewById(R.id.checkBox1);
        a3 = (TextView) findViewById(R.id.checkBox2);
        a4 = (TextView) findViewById(R.id.checkBox3);
        clock=findViewById(R.id.Timer);
        weiter = findViewById(R.id.weiter);
        antwort = findViewById(R.id.righanswer);
        streak=findViewById(R.id.Streak);
        spieler=findViewById(R.id.spieler);
        spielerAktuell();
        //TextView textView1= findViewById(R.id.Fragen);
        //textView1.setText(text1);

        System.out.println(this.textradio);
        final fetchData process = new fetchData();
        process.getCategory(this.textradio);
        process.execute();
        rg = findViewById(R.id.rgroup);
        click = findViewById(R.id.submitquest);

        final CountDownTimer Timer;
        Timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                clock.setText(""+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                click.setEnabled(false);
                weiter.setEnabled(true);
                int radiobuttonid = rg.getCheckedRadioButtonId();
                rb = findViewById(radiobuttonid);
                process.getCorrectAnswer();
                antwort.setText("Frage wurde zu spät beantwortet trinkt 3 shots!!!");
                if(0 == team % 2)
                {
                    team+=1;
                    count1+=1;
                    onStreak(count1,1);
                }else
                {
                    team+=1;
                    count2+=1;
                    onStreak(count2,2);
                }

            }
        }.start();

        radioGroup=findViewById(R.id.rgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                click.setEnabled(true);

            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer.cancel();
                click.setEnabled(false);
                weiter.setEnabled(true);
                int radiobuttonid = rg.getCheckedRadioButtonId();
                rb = findViewById(radiobuttonid);
                checkAnswer(process);

            }
        });




        weiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionsActivity();
            }
        });
    }

    private void spielerAktuell() {
        if (0==team%2)
        {
            spieler.setText(tex1+" Sie sind am zug");
        }else
        {
            spieler.setText(tex2+" Sie sind am zug");
        }
    }


    public void openQuestionsActivity() {

        Intent intent= new Intent(this, QuestionsActivity.class);
        intent.putExtra(EXTRA_TEXT1, tex1);
        intent.putExtra(EXTRA_TEXT2, tex2);
        intent.putExtra(EXTRA_RADIO, this.textradio);
        startActivity(intent);

    }


    private void checkAnswer(fetchData process) {


        if (process.check(rb)) {
            if (0== team % 2) {
                punkteteam1 += 10;
                antwort.setText("Du hast die Frage richtig beantwortet!!"+"\n"+tex1+" hat "+punkteteam1+" Punkte!");
                team+=1;
                count1=0;
                if (punkteteam1>=max)
                {
                    openEndActivity(tex1,tex2, punkteteam2);
                    punkteteam2=0;
                }
            } else {
                punkteteam2 += 10;
                antwort.setText("Du hast die Frage richtig beantwortet!!"+"\n"+tex2+" hat "+punkteteam2+" Punkte!");
                team+=1;
                count2=0;
                if (punkteteam2>=max)
                {
                    openEndActivity(tex2,tex1,punkteteam1);
                    punkteteam1=0;
                }
            }


        } else {
            if (0 == team % 2) {
                process.getCorrectAnswer();
                if(process.getDifficulty().equals("easy"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie 3 Schlücke!!!"+"\n"+"Sie haben "+punkteteam1+" Punkte!");
                }
                if(process.getDifficulty().equals("medium"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie 2 Schlücke!!!"+"\n"+"Sie haben "+punkteteam1+" Punkte!");
                }
                if(process.getDifficulty().equals("hard"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie einen Schluck!!!"+"\n"+"Sie haben "+punkteteam1+" Punkte!");
                }
                team+=1;
                count1+=1;
                onStreak(count1,1);

            } else {
                process.getCorrectAnswer();
                if(process.getDifficulty().equals("easy"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie 3 Schlücke!!!"+"\n"+"Sie haben "+punkteteam2+" Punkte!");
                }
                if(process.getDifficulty().equals("medium"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie 2 Schlücke!!!"+"\n"+"Sie haben "+punkteteam2+" Punkte!");
                }
                if(process.getDifficulty().equals("hard"))
                {
                    antwort.setText("Dies war leider falsch, machen Sie einen Schluck!!!"+"\n"+"Sie haben "+punkteteam2+" Punkte!");
                }
                team+=1;
                count2+=1;
                onStreak(count2,2);
            }

        }

    }

    public void onStreak(int count,int team)
    {
        if(count>=3)
        {
            streak.setText("Sie haben 3 Fragen hintereinander falsch beantwortet trinken Sie 3 Shots!!!");
            if(team==1)count1=0;
            if(team==2)count2=0;
        }
    }

    private void openEndActivity(String tverlierer, String tsieger, int punkte)
    {
        int p=(max-punkte)/10;
        String punkt=""+p+"";
        Intent intent= new Intent(this, EndActivity.class);
        intent.putExtra(EXTRA_TEXT1, tsieger);
        intent.putExtra(EXTRA_TEXT2, tverlierer);
        intent.putExtra(EXTRA_TEXT3, punkt);
        startActivity(intent);
    }


}
