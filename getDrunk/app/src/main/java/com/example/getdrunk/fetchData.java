package com.example.getdrunk;

import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.widget.RadioButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class fetchData extends AsyncTask<Void, Void, Void> {

    private String data = "";
    private String singleParsed = "";
    private String parsedDifficulty="";

    private String category;

    private JSONObject ob;
    private JSONArray jastandings;
    private JSONObject jo;
    private List<String> array = new ArrayList<String>();
    private String a1 = "";
    private String correct_answer;
    private Boolean whatcategory;
    private URL url;

    public void getCategory(String textradio) {

        if (textradio.equals("Any Category")) {
            whatcategory = false;
        }
        if (textradio.equals("Sports")) {
            category = "21";
            whatcategory = true;
        }
        if (textradio.equals("Celebrities")) {
            category = "26";
            whatcategory = true;
        }
        if (textradio.equals("Film")) {
            category = "11";
            whatcategory = true;
        }
        if (textradio.equals("General Knowledge")) {
            category = "9";
            whatcategory = true;
        }

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            if (whatcategory == false) {
                url = new URL("https://opentdb.com/api.php?amount=10&type=multiple");
            } else {
                url = new URL("https://opentdb.com/api.php?amount=10&category=" + category + "&type=multiple");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
                a1 = a1 + line;
            }

            jo = new JSONObject(data);

            jastandings = jo.getJSONArray("results");


            // jastandings= jostandinglist.getJSONArray("DriverStandings");

            ob = (JSONObject) jastandings.get(0);
            //JSONObject jteam= (JSONObject) ob.getJSONArray("Constructors").get(0);
            singleParsed = Html.fromHtml((String) ob.get("question")).toString() + "\n";
            parsedDifficulty=Html.fromHtml((String) ob.get("difficulty")).toString();
            array.add(Html.fromHtml((String) ob.get("correct_answer")).toString() + "\n");
            correct_answer = array.get(0);
            JSONArray incorrect_answers = ob.getJSONArray("incorrect_answers");
            array.add(Html.fromHtml((String) incorrect_answers.get(0)).toString() + "\n");
            array.add(Html.fromHtml((String) incorrect_answers.get(1)).toString() + "\n");
            array.add(Html.fromHtml((String) incorrect_answers.get(2)).toString() + "\n");

            Collections.shuffle(array);
            //Log.d("test",singleParsed);


            //dataParsed = dataParsed + singleParsed+"\n";


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        for (int i = 0; i <= 3; i++) {
            array.get(i);
        }

        QuestionsActivity.data.setText(singleParsed);
        QuestionsActivity.a1.setText(array.get(0));
        QuestionsActivity.a2.setText(array.get(1));
        QuestionsActivity.a3.setText(array.get(2));
        QuestionsActivity.a4.setText(array.get(3));

    }

    public String getDifficulty()
    {
        return parsedDifficulty;
    }


    public boolean check(RadioButton rb) {
        if (rb.getText().equals(correct_answer)) {

            return true;
        } else
            return false;
    }

    public void getCorrectAnswer() {
        if (QuestionsActivity.a1.getText().equals(correct_answer)) {
            QuestionsActivity.a1.setTextColor(Color.GREEN);
        }
        if (QuestionsActivity.a2.getText().equals(correct_answer)) {
            QuestionsActivity.a2.setTextColor(Color.GREEN);
        }
        if (QuestionsActivity.a3.getText().equals(correct_answer)) {
            QuestionsActivity.a3.setTextColor(Color.GREEN);
        }
        if (QuestionsActivity.a4.getText().equals(correct_answer)) {
            QuestionsActivity.a4.setTextColor(Color.GREEN);
        }
    }


}
