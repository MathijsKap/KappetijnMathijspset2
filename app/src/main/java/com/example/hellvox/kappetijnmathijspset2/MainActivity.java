package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    InputStream stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecondScreen(View View) {
        String story = "I wannabe a <job> when I grow up.\n" +
                "Just like my dad.\n" +
                "Life is <adjective> like that!";
        try {
            stream = new ByteArrayInputStream(story.getBytes(Charset.forName("UTF-8").name()));
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        Story newStory = new Story(stream);
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("theStory", newStory);
        startActivity(intent);
    }
}
