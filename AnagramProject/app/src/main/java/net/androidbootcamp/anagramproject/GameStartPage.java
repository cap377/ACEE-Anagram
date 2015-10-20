package net.androidbootcamp.anagramproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

//http://stackoverflow.com/questions/8065532/how-to-randomly-pick-an-element-from-an-array
//https://developer.android.com/
//http://www.anagramgenius.com/gem1.html
//http://stackoverflow.com/questions/8894258/fastest-way-to-iterate-over-all-the-chars-in-a-string

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;



public class GameStartPage extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "anagramproject.MESSAGE";
    public int NumScreens = 10;
    public int TotalScreens = 1;
    public int NumRightAnswers = 0;
    public int NumSkipped = 0;
    public int DictItem = 0;
    public String[][] MainArray = {{"Tom marvolo riddle", "i am lord voldemort", "Famous phrase in Harry Potter"},
            {"The best things in life are free", "nail biting refreshes the feet", "Keep yo toes out of yo mouth!"},
            {"The end of the world is nigh", "down this hole frightened", "Dig your way out!"},
            {"The meaning of life", "the fine game of nil", "Error - null pointer exception"},
            {"Public relations", "crap built on lies", "Speaks for itself"},
            {"estrngi" , "stinger", "Think Bee"},
            {"ydasrmade", "daydream", "Something you do in class"},
            {"covryitv", "victory", "Such a sweet taste"},
            {"taprie", "pirate", "Beware the sea"},
            {"toblet", "bottle", "Vessel of sorts"},
            {"reclea", "cereal", "Think morning"},
            {"keepsar", "speaker", "♪♪♪"},
            {"meraca", "camera", "Selfie"},
            {"kibrc", "brick", "She's mighty mighty.."},
            {"reniwt", "winter", "It's coming"},
            {"hena cojn", "john cena", "HIS NAME IS"},
            {"magrpro", "program", "I am your creator"},
            {"girefd", "fridge", "I am NOT running"},
            {"letebe", "beetle", "Let it be"}};

    public EditText timer;
    public CountDownTimer myTimer;



    public void createTimer(){

         myTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Time Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                View view = findViewById(R.id.button2);
                goToNextPage(view);
            }


        }.start();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start_page);


        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("Question: " + TotalScreens + "/" + NumScreens);

        DictItem = new Random().nextInt(MainArray.length);
        TextView textView1 = (TextView) findViewById(R.id.textView7);
        textView1.setText("Anagram: " + MainArray[DictItem][0]);

        TextView textView2 = (TextView) findViewById(R.id.textView8);
        textView2.setText("Hint: " + MainArray[DictItem][2]);

        createTimer();

        timer = (EditText) findViewById(R.id.timer);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_start_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void checkIfRight(View view){

        EditText editText = (EditText) findViewById(R.id.textView9);
        String answer = editText.getText().toString();

        if(MainArray[DictItem][1].equals(answer)) {
            NumRightAnswers += 1;
            goToNextPage(view);
            Toast.makeText(GameStartPage.this,"Congrats!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(GameStartPage.this,"That was not the correct answer", Toast.LENGTH_SHORT).show();

    }

    public void skipPage(View view){
        NumSkipped += 1;

        goToNextPage(view);
    }

    public void goToNextPage(View view) {
        if (TotalScreens >= NumScreens) {

            Intent intent = new Intent(GameStartPage.this, GameEndPage.class);
            intent.putExtra(EXTRA_MESSAGE, NumRightAnswers + "|" + NumScreens);
            myTimer.cancel();
            startActivity(intent);
        } else {
            TotalScreens += 1;
            TextView textView = (TextView) findViewById(R.id.textView6);
            textView.setText("Question: " + TotalScreens + "/" + NumScreens);

            DictItem = new Random().nextInt(MainArray.length);
            TextView textView1 = (TextView) findViewById(R.id.textView7);
            textView1.setText("Anagram: " + MainArray[DictItem][0]);

            TextView textView2 = (TextView) findViewById(R.id.textView8);
            textView2.setText("Hints: " + MainArray[DictItem][2]);

            TextView textView3 = (TextView) findViewById(R.id.wordsFound);
            textView3.setText("Words Found: " + NumRightAnswers);

            TextView textView4 = (TextView) findViewById(R.id.wordsSkipped);
            textView4.setText("Words Skipped: " + NumSkipped);

            EditText editText = (EditText) findViewById(R.id.textView9);
            editText.setText("");
            editText.setHint("Insert Answer Here");
            myTimer.cancel();
            createTimer();
        }
    }

}
