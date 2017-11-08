package com.example.hellvox.kappetijnmathijspset2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    // Initialize variables
    String libsleftstring;
    int libsleft;
    Story tempStory;
    TextView wordsleft;
    EditText nextwordtype;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        tempStory = (Story) intent.getSerializableExtra("theStory");

        // Get all the correct elements into the variables.
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        nextwordtype = findViewById(R.id.editText);
        wordsleft = findViewById(R.id.wordsleft);

        // Create the toast messages
        Context context = getApplicationContext();
        CharSequence text = "Keep going!";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);
        CharSequence text2 = "That was the last one, click 'show story' for your story!";
        int duration2 = Toast.LENGTH_LONG;
        final Toast toast2 = Toast.makeText(context, text2, duration2);

        // Firsttime getting the variables to put on the screen.
        libsleft = tempStory.getPlaceholderRemainingCount();
        libsleftstring = libsleft + " word(s) left";
        wordsleft.setText(libsleftstring);
        nextwordtype.setHint(tempStory.getNextPlaceholder());

        // Function to get the user input to the story class.
        // Also remove/add elements when the last word is given.
        nextwordtype.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (tempStory.getPlaceholderRemainingCount() > 1) {
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            toast.show();
                            String text = nextwordtype.getText().toString();
                            tempStory.fillInPlaceholder(text);
                            nextwordtype.setText("");
                            libsleft = tempStory.getPlaceholderRemainingCount();
                            libsleftstring = libsleft + " word(s) left";
                            wordsleft.setText(libsleftstring);
                            nextwordtype.setHint(tempStory.getNextPlaceholder());
                        }
                    });
                }
                if (tempStory.getPlaceholderRemainingCount() == 1) {
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            toast2.show();
                            String text = nextwordtype.getText().toString();
                            tempStory.fillInPlaceholder(text);
                            nextwordtype.setText("");
                            button2.setVisibility(View.VISIBLE);
                            button.setVisibility(View.INVISIBLE);
                            nextwordtype.setVisibility(View.INVISIBLE);
                            wordsleft.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
    }

    // Code to go the the story screen.
    public void goToThirdScreen(View View) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("finalStory", tempStory);
        startActivity(intent);
        finish();
    }

    // Code to restore the element visibility for rotation.
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        button.setVisibility(savedInstanceState.getInt("Button Visibility"));
        nextwordtype.setVisibility(savedInstanceState.getInt("Wordtype Visibility"));
        wordsleft.setVisibility(savedInstanceState.getInt("Wordsleft Visibility"));
        button2.setVisibility(savedInstanceState.getInt("Button2 Visibility"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    // Code to save the element visibility for rotation.
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("Button Visibility", button.getVisibility());
        savedInstanceState.putInt("Wordtype Visibility", nextwordtype.getVisibility());
        savedInstanceState.putInt("Wordsleft Visibility", wordsleft.getVisibility());
        savedInstanceState.putInt("Button2 Visibility", button2.getVisibility());
        super.onSaveInstanceState(savedInstanceState);
    }
}
