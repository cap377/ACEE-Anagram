package net.androidbootcamp.anagramproject;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

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
    static int correct;
    static int screens;

    MediaPlayer correctSound;
    MediaPlayer wrongSound;


    public int game_difficulty = DifficultyPage.difficulty;

    private Handler mHandler = new Handler();







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
            //10
            {"magrpro", "program", "I am your creator \n(1 word)", "unread"},
            {"girefd", "fridge", "I am NOT running \n(1 word)", "unread"},
            {"letebe", "beetle", "Let it be \n(1 word)", "unread"},
            {"lscdrmabe", "scrambled", "Like my eggs \n(1 word)", "unread"},
            {"zapiz", "pizza", "Everybody food \n(1 word)", "unread"},
            {"etrusosr", "trousers", "Fancy pants \n(1 word)", "unread"},
            {"pceotmur", "computer", "Tech neccessity \n(1 word)", "unread"},
            {"alpsma", "plasma", "Solid, liquid, gas,... \n(1 word)", "unread"},
            {"hoopt", "photo", "Camera baby \n(1 word)", "unread"},
            {"resup", "purse", "Feminine bag \n(1 word)", "unread"},
            //20
            {"aarrchcet", "character", "Fictional person \n(1 word)", "unread"},
            {"ocoiek", "cookie", "Milk's best friend \n(1 word)", "unread"},
            {"cieecrm", "icecream", "Dessert \n(1 word)", "unread"},
            {"wodrs", "sword", "A weapon \n(1 word)", "unread"},
            {"eestlivnoi", "television", "It's what you watch \n(1 word)", "unread"},
            {"tabo", "boat", "It floats \n(1 word)", "unread"},
            {"tanir", "train", "On the rails \n(1 word)", "unread"},
            {"ievom", "movie", "Visual experience \n(1 word)", "unread"},
            {"rsdipe", "spider", "Find on web \n(1 word)", "unread"},
            {"ucsmi", "music", "Audible fun \n(1 word)", "unread"},
            // 30
            {"palpes", "apples", "Keeps the doctor away \n(1 word)", "unread"},
            {"suites", "tissue", "Nose towel \n(1 word)", "unread"},
            {"smartest", "mattress", "Sleeping cushion \n(1 word)", "unread"},
            {"hacir", "chair", "Take a seat \n(1 word)", "unread"},
            {"palm", "lamp", "Clap on \n(1 word)", "unread"},
            {"inks", "sink", "Wash your hands \n(1 word)", "unread"},
            {"tektin", "kitten", "Meow \n(1 word)", "unread"},
            {"drabe", "bread", "Young toast \n(1 word)", "unread"},
            {"harts", "trash", "Not recyclable \n(1 word)", "unread"},
            {"toga", "goat", "Bleats often \n(1 word)", "unread"},
            // 40
            {"last", "salt", "Bitter tasting \n(1 word)", "unread"},
            {"luge", "glue", "Sticky substance \n(1 word)", "unread"},
            {"apper", "paper", "College ruled \n(1 word)", "unread"},
            {"sareer", "eraser", "Removes mistakes \n(1 word)", "unread"},
            {"sargs", "grass", "Needs to be watered \n(1 word)", "unread"},
            {"swolfer", "flowers", "Spring's bounty \n(1 word)", "unread"},
            {"reset", "trees", "Oxygen producers \n(1 word)", "unread"},
            {"nestus", "sunset", "Beautiful to witness \n(1 word)", "unread"},
            {"uclod", "cloud", "Fluffy water storage \n(1 word)", "unread"},
            {"troclon", "control", "Take over \n(1 word)", "unread"},
            // 50
            {"trid", "dirt", "Worm home \n(1 word)", "unread"},
            {"dancy", "candy", "Sweet tasting \n(1 word)", "unread"},
            {"lurer", "ruler", "Size determiner \n(1 word)", "unread"},
            {"shrub", "brush", "Able to fix messy hair \n(1 word)", "unread"},
            {"tone", "note", "Paper reminder \n(1 word)", "unread"},};
            // 55

    public String[][] MediumArray = {{"cajk dan lijl" , "jack and jill", "We just wanted some water.. \n(3 words)", "unread"},
            {"radht davre", "darth vader", "We can rule the universe together \n(2 words)", "unread"},
            {"og emoh", "go home", "What you want to do right now \n(2 words)", "unread"},
            {"wro oyur otab", "row your boat", "Life is but a dream \n(3 words)", "unread"},
            {"epitar hisp", "pirate ship", "Stolen, but still awesome \n(2 words)", "unread"},
            {"starkeafb", "breakfast", "Most important meal \n(1 word)", "unread"},
            {"moxobob", "boombox", "Portable and loud \n(1 word)", "unread"},
            {"fliese itskc", "selfie stick", "Don't bring on a roller-coaster \n(2 words)", "unread"},
            {"tranima", "martian", "We come in peace \n(1 word)", "unread"},
            {"ride flow", "dire wolf", "Fluffy and dangerous \n(2 words)", "unread"},
            //10
            {"icosal tob", "social bot", "You have a friend request \n(2 words)", "unread"},
            {"hawssidhre", "dishwasher", "Dirty or clean? \n(1 words)", "unread"},
            {"rashgerpospe", "grasshopper", "Spits 'blood' \n(1 word)", "unread"},
            {"focinunso", "confusion", "Wait, what? \n(1 word)", "unread"},
            {"ecopestle", "telescope", "For viewing stars \n(1 word)", "unread"},
            {"batchilkms", "blacksmith", "Medieval occupation \n(1 word)", "unread"},
            {"acerimvow", "microwave", "College kitchen \n(1 word)", "unread"},
            {"rancurhie", "hurricane", "Coastal disaster \n(1 word)", "unread"},
            {"gushnot", "shotgun", "Destructive weapon \n(1 word)", "unread"},
            {"towheadrib", "whiteboard", "Educational tool \n(1 word)", "unread"},
            //20
            {"brainliar", "librarian", "Book lover \n(1 word)", "unread"},
            {"chowdonut", "touchdown", "Tornado or sport \n(1 word)", "unread"},
            {"ryeknow", "newyork", "City and state \n(1 word)", "unread"},
            {"capcroupfin", "frappuccino", "Fancy drink \n(1 word)", "unread"},
            {"rodentthrums", "thunderstorm", "Loud weather \n(1 word)", "unread"},
            {"dubbenk", "bunk bed", "Double decker \n(2 words)", "unread"},
            {"aregrin", "earring", "Shiny accessory \n(1 word)", "unread"},
            {"sbutcokes", "tube socks", "80s fitness apparel \n(2 words)", "unread"},
            {"troutckw", "tow truck", "For when you're car breaks \n(2 words)", "unread"},
            {"napspewer", "newspaper", "Morning delivery \n(1 word)", "unread"}};

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
            //10
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
            //20
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
                timer.setText("Time:\n" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                View view = findViewById(R.id.button2);
                goToNextPage(view);
            }
        }.start();
    }

    @Override
    protected void onStart(){
        super.onStart();
        getAnagram();
        createTimer();
        timer = (EditText) findViewById(R.id.timer);
        timer.setTypeface(EasyFonts.caviarDreamsBold(this));
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start_page);


        //create sounds for right and wrong answers
        correctSound = MediaPlayer.create(GameStartPage.this, R.raw.positive);
        wrongSound = MediaPlayer.create(GameStartPage.this, R.raw.negative);

        //set anagram dictionary based on difficulty value chosen by user
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
       // getAnagram();

        //DictItem = new Random().nextInt(MainArray.length);
        TextView anagramText = (TextView) findViewById(R.id.textView7);
        anagramText.setTypeface(EasyFonts.caviarDreamsBold(this));
        anagramText.setText("Anagram: \n" + MainArray[DictItem][0]);

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



        //createTimer();
        //timer = (EditText) findViewById(R.id.timer);
        //timer.setTypeface(EasyFonts.caviarDreamsBold(this));
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
        Context context = this;

        // create vibration capabilities
        Vibrator vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        EditText editText = (EditText) findViewById(R.id.textView9);
        String answer = editText.getText().toString();


        if(MainArray[DictItem][1].equals(answer)) {
            NumRightAnswers += 1;
            goToNextPage(view);

            correctToast = Toast.makeText(GameStartPage.this,"Correct!", Toast.LENGTH_SHORT);
            correctToast.setGravity(Gravity.CENTER,0,300);
            ImageView correct = new ImageView(this);
            correct.setImageResource(R.drawable.correct);
            correctToast.setView(correct);
            correctToast.show();
            correctSound.start();
            vibe.vibrate(50);
            return;
        }
        incorrectToast = Toast.makeText(GameStartPage.this,"Incorrect! Try Again!", Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.CENTER, 0, 300);
        ImageView incorrect = new ImageView(this);
        incorrect.setImageResource(R.drawable.incorrect);
        incorrectToast.setView(incorrect);
        incorrectToast.show();
        wrongSound.start();
        vibe.vibrate(50);
    }

    public void skipPage(View view){
        Context context = this;

        // create vibration capabilities
        Vibrator vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        NumSkipped += 1;
        goToNextPage(view);
        incorrectToast = Toast.makeText(GameStartPage.this,"Incorrect! Try Again!", Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.CENTER, 0, 300);
        ImageView incorrect = new ImageView(this);
        incorrect.setImageResource(R.drawable.incorrect);
        incorrectToast.setView(incorrect);
        incorrectToast.show();
        wrongSound.start();
        vibe.vibrate(50);
    }

    public void goToNextPage(View view) {
        if (TotalScreens >= NumScreens) {

            correct = NumRightAnswers;
            screens = 10;
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
            anagramText.setText("Anagram: \n" + MainArray[DictItem][0]);

            TextView hintText = (TextView) findViewById(R.id.textView8);
            hintText.setTypeface(EasyFonts.caviarDreamsBold(this));
            hintText.setText("Hint: " + MainArray[DictItem][2]);

            TextView wordsFound = (TextView) findViewById(R.id.wordsFound);
            wordsFound.setTypeface(EasyFonts.caviarDreamsBold(this));
            wordsFound.setText("Correct: " + NumRightAnswers);

            TextView wordsSkipped = (TextView) findViewById(R.id.wordsSkipped);
            wordsSkipped.setTypeface(EasyFonts.caviarDreamsBold(this));
            wordsSkipped.setText("Missed: " + NumSkipped);

            EditText editText = (EditText) findViewById(R.id.textView9);
            editText.setTypeface(EasyFonts.caviarDreamsBold(this));
            editText.setText("");
            editText.setHint("Tap Here To Answer");
            myTimer.cancel();
            createTimer();
        }
    }

}
