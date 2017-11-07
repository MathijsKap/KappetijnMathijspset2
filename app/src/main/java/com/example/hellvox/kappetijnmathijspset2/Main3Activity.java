package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Story finalStory = (Story) intent.getSerializableExtra("finalStory");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(finalStory.toString());
    }

}
