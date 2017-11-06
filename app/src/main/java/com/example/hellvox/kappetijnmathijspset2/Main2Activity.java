package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void goToThirdScreen(View View) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("ourText", text);

        startActivity(intent);
        finish();
    }
}
