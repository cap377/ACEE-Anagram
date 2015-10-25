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
import android.widget.ImageView;
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

import com.vstechlab.easyfonts.EasyFonts;

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

    public String[][] MediumArray = {{"cajk dan lijl" , "jack and jill", "we just wanted some water.. \n(3 words)", "unread"},
            {"radht davre", "darth vader", "we can rule the universe together \n(2 words)", "unread"},
            {"og emoh", "go home", "What you want to do right now \n(2 words)", "unread"},
            {"wro oyur otab", "row your boat", "life is but a dream \n(3 words)", "unread"},
            {"epitar hisp", "pirate ship", "stolen, but still awesome \n(2 words)", "unread"},
            {"starkeafb", "breakfast", "most important meal \n(1 word)", "unread"},
            {"moxobob", "boombox", "portable and loud \n(1 word)", "unread"},
            {"fliese itskc", "selfie stick", "don't bring on a roller-coaster \n(2 words)", "unread"},
            {"tranima", "martian", "we come in peace \n(1 word)", "unread"},
            {"ride flow", "dire wolf", "fluffy and dangerous \n(2 words)", "unread"},
            {"icosal tob", "social bot", "you have a friend request \n(2 words)", "unread"},
            {"hawssidhre", "dishwasher", "dirty or clean? \n(2 words)", "unread"},
            {"rashgerpospe", "grasshopper", "spits 'blood'  \n(1 word)", "unread"}};

    public String[][] HardArray = {{"Tom Marvolo Riddle", "i am lord voldemort", "Famous phrase in Harry Potter \n(4 words)", "unread"},
            {"Old West Action", "clint eastwood", "Make my day... \n(2 words)", "unread"},
            {"They see", "the eyes", "Most people have two \n(2 words)", "unread"},
            {"A Gentlemen", "elegant man", "Very similar \n(2 words)", "unread"},
            {"The Detectives", "detect thieves", "It's what they do \n(2 words)", "unread"},
            {"Debit Card" , "bad credit", "If you aren't careful \n(2 words)", "unread"},
            {"Schoolmaster", "the classroom", "Where they belong \n(2 words)", "unread"},
            {"Listen", "silent", "What you must be for it to work \n(1 word)", "unread"},
            {"Eleven Plus Two", "twelve plus one", "Thirteen \n(3 words)", "unread"},
            {"Coins Kept", "in pocket", "The perfect spot \n(2 words)", "unread"},
            {"Alloy immure wry", "will you marry me", "THE question \n(3 words)", "unread"},
            {"Violence Only You", "you only live once", "The motto \n(4 words)", "unread"},
            {"Guise Yon Root", "i got your nose", "Childhood trickery \n(4 words)", "unread"},
            {"Theme Ye Ill Witty", "with my little eye", "I spy \n(4 words)", "unread"},
            {"Eery Ooh Suits", "tie your shoes", "Childhood lesson \n(3 words)", "unread"},
            {"Impugned Step", "stepped in gum", "A sticky mess \n(3 words)", "unread"},
            {"Holder Do Tho", "hold the door", "An act of kindness \n(3 words)", "unread"},
            {"Beating Eh Moo", "the boogie man", "Nighttime terror \n(3 words)", "unread"},
            {"Beside Demon Yo", "i need somebody", "Help! \n(3 words)", "unread"},
            {"Cat Revoke", "take cover", "Attack incoming \n(2 words)", "unread"},
            {"Tat Orb El Wet", "water bottle", "Popular sport accessory \n(2 words)", "unread"},
            {"A Back Boa Ram", "barack obama", "President \n(2 words)", "unread"},
            {"See TVs Job", "steve jobs", "Tech Genius \n(2 words)", "unread"},
            {"Eh Lone Ion", "hole in one", "Golfer's dream \n(3 words)", "unread"},
            {"Dam Gnarls", "grand slam", "4 man score \n(2 words)", "unread"},
            {"Knocked I Is", "on side kick", "Risky football maneuver \n(3 words)", "unread"},
            {"Fibril Depth", "flip the bird", "Hand signal \n(3 words)", "unread"},
            {"Cab Yak Groups", "pack your bags", "We're going on vacation \n(3 words)", "unread"},
            {"Green Ole Tv", "never let go", "Hold on \n(3 words)", "unread"},
            {"Ray Hid Uh Iron", "harry houdini", "Famous magician \n(2 words)", "unread"}};


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

        TextView questionNumber = (TextView) findViewById(R.id.textView6);
        questionNumber.setTypeface(EasyFonts.caviarDreamsBold(this));
        questionNumber.setText("Question: " + TotalScreens + "/" + NumScreens);

        // anagram grabbed randomly from dictionary
        getAnagram();

        //DictItem = new Random().nextInt(MainArray.length);
        TextView anagramText = (TextView) findViewById(R.id.textView7);
        anagramText.setTypeface(EasyFonts.caviarDreamsBold(this));
        anagramText.setText("Anagram: " + MainArray[DictItem][0]);

        TextView hintText = (TextView) findViewById(R.id.textView8);
        hintText.setTypeface(EasyFonts.caviarDreamsBold(this));
        hintText.setText("Hint: " + MainArray[DictItem][2]);

        TextView wordsFound = (TextView) findViewById(R.id.wordsFound);
        wordsFound.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView wordsSkipped = (TextView) findViewById(R.id.wordsSkipped);
        wordsSkipped.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button skipButton = (Button) findViewById(R.id.button2);
        skipButton.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView insertText = (TextView) findViewById(R.id.textView9);
        insertText.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button submitButton = (Button) findViewById(R.id.button);
        submitButton.setTypeface(EasyFonts.caviarDreamsBold(this));


        createTimer();
        timer = (EditText) findViewById(R.id.timer);
        timer.setTypeface(EasyFonts.caviarDreamsBold(this));
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
            correctToast.setGravity(Gravity.CENTER,0,-250);
            ImageView correct = new ImageView(this);
            correct.setImageResource(R.drawable.correct);
            correctToast.setView(correct);
            correctToast.show();
            return;
        }
        incorrectToast = Toast.makeText(GameStartPage.this,"Incorrect! Try Again!", Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.CENTER, 0, -250);
        ImageView incorrect = new ImageView(this);
        incorrect.setImageResource(R.drawable.incorrect);
        incorrectToast.setView(incorrect);
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
            TextView questionText = (TextView) findViewById(R.id.textView6);
            questionText.setTypeface(EasyFonts.caviarDreamsBold(this));
            questionText.setText("Question: " + TotalScreens + "/" + NumScreens);

            //DictItem = new Random().nextInt(MainArray.length);
            TextView anagramText = (TextView) findViewById(R.id.textView7);
            anagramText.setTypeface(EasyFonts.caviarDreamsBold(this));
            anagramText.setText("Anagram: " + MainArray[DictItem][0]);

            TextView hintText = (TextView) findViewById(R.id.textView8);
            hintText.setTypeface(EasyFonts.caviarDreamsBold(this));
            hintText.setText("Hint: " + MainArray[DictItem][2]);

            TextView wordsFound = (TextView) findViewById(R.id.wordsFound);
            wordsFound.setTypeface(EasyFonts.caviarDreamsBold(this));
            wordsFound.setText("Words Found: " + NumRightAnswers);

            TextView wordsSkipped = (TextView) findViewById(R.id.wordsSkipped);
            wordsSkipped.setTypeface(EasyFonts.caviarDreamsBold(this));
            wordsSkipped.setText("Words Skipped: " + NumSkipped);

            EditText editText = (EditText) findViewById(R.id.textView9);
            editText.setTypeface(EasyFonts.caviarDreamsBold(this));
            editText.setText("");
            editText.setHint("Insert Answer Here");
            myTimer.cancel();
            createTimer();
        }
    }

}
