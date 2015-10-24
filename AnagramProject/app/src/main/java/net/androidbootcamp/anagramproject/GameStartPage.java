package net.androidbootcamp.anagramproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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



public class GameStartPage extends AppCompatActivity{
    public final static String EXTRA_MESSAGE = "anagramproject.MESSAGE";
    public int NumScreens = 10;
    public int TotalScreens = 1;
    public int NumRightAnswers = 0;
    public int NumSkipped = 0;
    public int DictItem = 0;
    public Toast correctToast;
    public Toast incorrectToast;


    public int game_difficulty = DifficultyPage.difficulty;


    public String[][] MainArray = {
            {"estrngi" , "stinger", "Think Bee (1 word)"},
            {"ydasrmade", "daydream", "Something you do in class (1 word)"},
            {"covryitv", "victory", "Such a sweet taste (1 word)"},
            {"taprie", "pirate", "Beware the sea (1 word)"},
            {"toblet", "bottle", "Vessel of sorts (1 word)"},
            {"reclea", "cereal", "Think morning (1 word)"},
            {"keepsar", "speaker", "♪♪♪ (1 word)"},
            {"meraca", "camera", "Selfie (1 word)"},
            {"kibrc", "brick", "She's mighty mighty.. (1 word)"},
            {"reniwt", "winter", "It's coming (1 word)"},
            {"magrpro", "program", "I am your creator (1 word)"},
            {"girefd", "fridge", "I am NOT running (1 word)"},
            {"letebe", "beetle", "Let it be (1 word)"},
            {"cajk dan lijl" , "jack and jill", "we just wanted some water.. (3 words)"},
            {"radht davre", "darth vader", "we can rule the universe together (2 words)"},
            {"og emoh", "go home", "What you want to do right now (2 words)"},
            {"wro oyur otab", "row your boat", "life is but a dream (3 words)"},
            {"epitar hisp", "pirate ship", "stolen, but still awesome (2 words)"},
            {"starkeafb", "breakfast", "most important meal (1 word)"},
            {"moxobob", "boombox", "portable and loud (1 word)"},
            {"fliese itskc", "selfie stick", "don't bring on a roller-coaster (2 words)"},
            {"tranima", "martian", "we come in peace (1 word)"},
            {"ride flow", "dire wolf", "fluffy and dangerous (2 words)"},
            {"icosal tob", "social bot", "you have a friend request (2 words)"},
            {"hawssidhre", "dishwasher", "dirty or clean? (2 words)"},
            {"rashgerpospe", "grasshopper", "spits 'blood'  (1 word)"},
            {"Tom Marvolo Riddle", "i am lord voldemort", "Famous phrase in Harry Potter (4 words)"},
            {"Old West Action", "clint eastwood", "Make my day... (3 words)"},
            {"They see", "the eyes", "Most people have two (2 words)"},
            {"A Gentlemen", "elegant man", "Very similar (2 words)"},
            {"The Detectives", "detect thieves", "It's what they do (2 words)"},
            {"Debit Card" , "bad credit", "If you aren't careful (2 words)"},
            {"Schoolmaster", "the classroom", "Where they belong (2 words)"},
            {"Listen", "silent", "what you must be for it to work (1 word)"},
            {"Eleven Plus Two", "twelve plus one", "thirteen (3 words)"}};

    public String[][] EasyArray = {{"estrngi" , "stinger", "Think Bee \n(1 word)", "unread"},
            {"ydasrmade", "daydream", "Something you do in class \n(1 word)", "unread"},
            {"covryitv", "victory", "Such a sweet taste \n(1 word)", "unread"},
            {"taprie", "pirate", "Beware the sea \n(1 word)", "unread"},
            {"toblet", "bottle", "Vessel of sorts \n(1 word)", "unread"},
            {"reclea", "cereal", "Think morning \n(1 word)", "unread"},
            {"keepsar", "speaker", "♪♪♪ \n(1 word)", "unread"},
            {"meraca", "camera", "Selfie \n(1 word)", "unread"},
            {"kibrc", "brick", "She's mighty mighty.. \n(1 word)", "unread"},
            {"reniwt", "winter", "It's coming \n(1 word)", "unread"},
            {"magrpro", "program", "I am your creator \n(1 word)", "unread"},
            {"girefd", "fridge", "I am NOT running \n(1 word)", "unread"},
            {"letebe", "beetle", "Let it be \n(1 word)", "unread"}};

    public String[][] MediumArray = {{"cajk dan lijl" , "jack and jill", "we just wanted some water.. (3 words)", "unread"},
            {"radht davre", "darth vader", "we can rule the universe together (2 words)", "unread"},
            {"og emoh", "go home", "What you want to do right now (2 words)", "unread"},
            {"wro oyur otab", "row your boat", "life is but a dream (3 words)", "unread"},
            {"epitar hisp", "pirate ship", "stolen, but still awesome (2 words)", "unread"},
            {"starkeafb", "breakfast", "most important meal (1 word)", "unread"},
            {"moxobob", "boombox", "portable and loud (1 word)", "unread"},
            {"fliese itskc", "selfie stick", "don't bring on a roller-coaster (2 words)", "unread"},
            {"tranima", "martian", "we come in peace (1 word)", "unread"},
            {"ride flow", "dire wolf", "fluffy and dangerous (2 words)", "unread"},
            {"icosal tob", "social bot", "you have a friend request (2 words)", "unread"},
            {"hawssidhre", "dishwasher", "dirty or clean? (2 words)", "unread"},
            {"rashgerpospe", "grasshopper", "spits 'blood'  (1 word)", "unread"}};

    public String[][] HardArray = {{"Tom Marvolo Riddle", "i am lord voldemort", "Famous phrase in Harry Potter (4 words)", "unread"},
            {"Old West Action", "clint eastwood", "Make my day... (2 words)", "unread"},
            {"They see", "the eyes", "Most people have two (2 words)", "unread"},
            {"A Gentlemen", "elegant man", "Very similar (2 words)", "unread"},
            {"The Detectives", "detect thieves", "It's what they do (2 words)", "unread"},
            {"Debit Card" , "bad credit", "If you aren't careful (2 words)", "unread"},
            {"Schoolmaster", "the classroom", "Where they belong (2 words)", "unread"},
            {"Listen", "silent", "What you must be for it to work (1 word)", "unread"},
            {"Eleven Plus Two", "twelve plus one", "Thirteen (3 words)", "unread"},
            {"Coins Kept", "in pocket", "The perfect spot (2 words)", "unread"}};


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

        //create anagram dictionary based on difficulty value
        if (game_difficulty == 1){
            MainArray = EasyArray;
        }
        if (game_difficulty == 2){
            MainArray = MediumArray;
        }
        if (game_difficulty == 3){
            MainArray = HardArray;
        }

        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("Question: " + TotalScreens + "/" + NumScreens);

        // anagram grabbed randomly from dictionary
        getAnagram();

        //DictItem = new Random().nextInt(MainArray.length);
        TextView textView1 = (TextView) findViewById(R.id.textView7);
        textView1.setText("Anagram: " + MainArray[DictItem][0]);

        TextView textView2 = (TextView) findViewById(R.id.textView8);
        textView2.setText("Hint: " + MainArray[DictItem][2]);

        createTimer();
        timer = (EditText) findViewById(R.id.timer);
    }

    public void getAnagram(){
        DictItem = new Random().nextInt(MainArray.length);
        if (MainArray[DictItem][3].equals("read")){
            getAnagram();
        }
        else{
            MainArray[DictItem][3] = "read";
        }
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

            correctToast = Toast.makeText(GameStartPage.this,"Correct!", Toast.LENGTH_SHORT);
            correctToast.setGravity(Gravity.CENTER,0,0);
            correctToast.show();
            return;
        }
        incorrectToast = Toast.makeText(GameStartPage.this,"Incorrect! Try Again!", Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.CENTER,0,0);
        incorrectToast.show();
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
            getAnagram();
            TotalScreens += 1;
            TextView textView = (TextView) findViewById(R.id.textView6);
            textView.setText("Question: " + TotalScreens + "/" + NumScreens);

            //DictItem = new Random().nextInt(MainArray.length);
            TextView textView1 = (TextView) findViewById(R.id.textView7);
            textView1.setText("Anagram: " + MainArray[DictItem][0]);

            TextView textView2 = (TextView) findViewById(R.id.textView8);
            textView2.setText("Hint: " + MainArray[DictItem][2]);

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
