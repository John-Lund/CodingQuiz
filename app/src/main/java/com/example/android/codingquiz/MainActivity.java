package com.example.android.codingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View v) {
        // setting score variable and mistake string to initial states
        int score = 6;
        String mistakes = "";

        // finds if the user selected the third option in question 1 "it's an object"
        RadioButton question1Answer1 = findViewById(R.id.radioButton3);
        if (!(question1Answer1.isChecked())) {
            score--;
            mistakes += " Question 1: it's an object.";
        }

        // finds if the user selected the right answers for question 2
        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);
        if (!(checkBox1.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !checkBox2.isChecked() && !checkBox4.isChecked())) {
            score--;
            mistakes += " Question 2: \"continue\", \"switch\" and \"float\" can't be used.";
        }

        // finds if the user wrote the correct form of the variable for question 3
        EditText answer3Text = (EditText) findViewById(R.id.question3Text);
        if (!(answer3Text.getText().toString().equals("numberOfCoffeesOrdered"))) {
            score--;
            mistakes += " Question 3: it should read \"numberOfCoffeesOrdered\".";
        }

        //  finds if the user chose the correct option for question 4
        RadioButton question4Answer2 = findViewById(R.id.radioButton5);
        if (!question4Answer2.isChecked()) {
            score--;
            mistakes += " Question 4: \"ScrollView\" was the right answer. ";
        }

        //  finds if the user chose the correct option for question 5
        RadioButton question5Answer2 = findViewById(R.id.radioButton8);
        if (!question5Answer2.isChecked()) {
            score--;
            mistakes += " Question 5: the hex code for white is #FFFFFF. ";
        }

        //  finds if the user chose the correct option for question 6
        RadioButton question6Answer3 = findViewById(R.id.radioButton12);
        if (!question6Answer3.isChecked()) {
            score--;
            mistakes += " Question 5: 'double' was the right answer. ";
        }

        // displays congratulatory toast if user gets everything right
        if (score == 6) {
            Toast.makeText(this, " You scored 6 out of 6\n" + "You got it all right!  Well done!", Toast.LENGTH_LONG).show();
        } else {
            // creates and displays toast message to explain mistakes and chooses correct form of verb "to be"
            String toastMessage = (score != 5) ? " The ones you missed were:" : " The one you missed was:";
            Toast.makeText(this, " You scored " + score + " out of 6\n" + toastMessage + mistakes, Toast.LENGTH_LONG).show();
        }
    }
}
