package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Get the story from the previous activity
        Intent intent = getIntent();
        Story finalStory = (Story) intent.getSerializableExtra("finalStory");

        // Change the story to a String and put it on the screen.
        TextView textView = findViewById(R.id.textView);
        textView.setText(finalStory.toString());
    }

    // Code to get to the first screen and wipe all the previous screens.
    public void goToFirstScreen(View View) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
