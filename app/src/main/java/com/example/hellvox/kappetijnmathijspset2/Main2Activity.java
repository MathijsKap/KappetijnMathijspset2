package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {
    Story tempStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        tempStory = (Story) intent.getSerializableExtra("theStory");

        EditText nextwordtype = (EditText) findViewById(R.id.editText);
        nextwordtype.setHint(tempStory.getNextPlaceholder());

        TextView wordsleft = (TextView) findViewById(R.id.wordsleft);
        int libsleft = tempStory.getPlaceholderRemainingCount();
        String temp = libsleft + " word(s) left";
        wordsleft.setText(temp);

    }
    public void goToThirdScreen(View View) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("finalStory", tempStory);

        startActivity(intent);
        finish();
    }
}
