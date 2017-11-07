package com.example.hellvox.kappetijnmathijspset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    InputStream stream;
    Spinner spinner;
    String story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        additemsonspinner();
        spinner.setOnItemSelectedListener(this);
    }

    public void additemsonspinner() {
        spinner = findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void goToSecondScreen(View View) {
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
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 0:
                story = "I wannabe a <job> when I grow up.\n" +
                        "Just like my dad.\n" +
                        "Life is <adjective> like that!";
                break;
            case 1:
                story = "One of the most <adjective> characters in fiction is named\n" +
                        "\"Tarzan of the <plural-noun> .\" Tarzan was raised by a/an\n" +
                        "<noun> and lives in the <adjective> jungle in the\n" +
                        "heart of darkest <place> . He spends most of his time\n" +
                        "eating <plural-noun> and swinging from tree to <noun> .\n" +
                        "Whenever he gets angry, he beats on his chest and says,\n" +
                        "\" <funny-noise> !\" This is his war cry. Tarzan always dresses in\n" +
                        "<adjective> shorts made from the skin of a/an <noun>\n" +
                        "and his best friend is a/an <adjective> chimpanzee named\n" +
                        "Cheetah. He is supposed to be able to speak to elephants and\n" +
                        "<plural-noun> . In the movies, Tarzan is played by <person's-name> .\n";
                break;
            case 2:
                story = "Our American universities offer students many <adjective>\n" +
                        "courses that will prepare them to become professional <plural-noun> .\n" +
                        "You can get a degree as a Bachelor of <plural-noun> or take a\n" +
                        "regular liberal <plural-noun> course. Or, if you want to become\n" +
                        "a/an <adjective> engineer, you can study <adjective> mathematics\n" +
                        "and differential <plural-noun> . Then, after <number> years, if\n" +
                        "you want to continue your studies you can write a/an <noun> and\n" +
                        "become a Doctor of <plural-noun> . \n" +
                        "\n" +
                        "When you get out into the <adjective> world, if you have a diploma \n" +
                        "from a university, you will be able to get a job easily as a/an <job-title> \n" +
                        "or even a/an <job-title> . If you don't have a diploma, you may have to take\n" +
                        "a job as a <noun> . \n" +
                        "\n" +
                        "Remember, it's important that you study hard in high school so you are able \n" +
                        "to do well on your college entrance <plural-noun> . It is true that \"a little \n" +
                        "learning is a/an <adjective> thing.\"";
                break;
            case 3:
                story = "<Male-Name> has announced that his <adjective>\n" +
                        "clothing store in the heart of downtown <CITY> is having\n" +
                        "a/an <adjective> sale of all merchandise, including\n" +
                        "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
                        "available. Men's cable-knit <plural-noun> , only $15.99.\n" +
                        "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
                        "breasted cashmere <plural-noun> , $50.00. Genuine imported\n" +
                        "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
                        "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
                        "This is a chance to get some really <Interesting-Adjective> bargains.\n";
                break;
            case 4:
                story = "Here's how you dance the Monstrosity. Stand with your feet together.\n" +
                        "Now, move your left foot <aDvErB> to the side. Now stamp your\n" +
                        "right foot <NUMBER> times and put your hands on your partner's\n" +
                        "<Plural-Noun> . Next, you both <verb> slowly to the right and bend\n" +
                        "your <body-part> backward. For the next eight counts,\n" +
                        "both of you <verb> <adverb> to the left. Next, you and\n" +
                        "your partner stand back to back and wiggle your <pluRAL-nOUN> and\n" +
                        "slap your <plural-noun> together. Don't forget to keep stamping\n" +
                        "your right foot. Now, face your partner again, put your <plural-noun>\n" +
                        "together and shout, \" <FUNNY-noise> !\" Now, <verb> backward\n" +
                        "and repeat the whole thing <Number> times. If you feel that you can't\n" +
                        "learn this dance, you can always <verB> the next one out.";
                break;
        }
    }
}
