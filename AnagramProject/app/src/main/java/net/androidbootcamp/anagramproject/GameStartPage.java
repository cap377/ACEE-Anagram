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

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public String[][] currentWord;
    public String[][] currentLetters;
    public String anagram;


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
            {"tone", "note", "Paper reminder \n(1 word)", "unread"},
            {"oofbtlal", "football", "Not always played with feet \n(1 word)", "unread"},
            {"rcosce", "soccer", "Popular foot-sport \n(1 word)", "unread"},
            {"emunbr", "number", "Used for counting \n(1 word)", "unread"},
            {"tone", "note", "Paper reminder \n(1 word)", "unread"},
            {"ramrke", "marker", "Writing instrument \n(1 word)", "unread"},
            {"locro", "color", "Everyone has a favorite \n(1 word)", "unread"},
            // 60
            {"rabc", "crab", "Tasty ocean scavenger \n(1 word)", "unread"},
            {"orkc", "rock", "Hard and strong \n(1 word)", "unread"},
            {"hklac", "chalk", "Classic teacher tool \n(1 word)", "unread"},
            {"tskea", "steak", "Delicious meat \n(1 word)", "unread"},
            {"hummosor", "mushroom", "Fungus \n(1 word)", "unread"},
            {"erohs", "horse", "Old West transportation \n(1 word)", "unread"},
            {"staerot", "toaster", "Burns bread \n(1 word)", "unread"},
            {"elndbre", "blender", "Mixes and dices various things \n(1 word)", "unread"},
            {"hpnoe", "phone", "What you are looking at \n(1 word)", "unread"},
            {"npaio", "npaio", "A grand instrument \n(1 word)", "unread"},
            // 70
            {"igatur", "guitar", "Has multiple strings \n(1 word)", "unread"},
            {"rdmu", "drum", "Hit this for a beat \n(1 word)", "unread"},
            {"sabs", "bass", "D-d-d-d-drop the _____ \n(1 word)", "unread"},
            {"agem", "game", "For fun \n(1 word)", "unread"},
            {"edvoi", "video", "Moving photo \n(1 word)", "unread"},
            {"pilarena", "airplane", "One way to fly \n(1 word)", "unread"},
            {"rukyte", "turkey", "Gobble gobble \n(1 word)", "unread"},
            {"muippnk", "pumpkin", "Popular pie \n(1 word)", "unread"},
            {"ucase", "sauce", "Makes some food even better \n(1 word)", "unread"},
            {"dohayil", "holiday", "Spent with family \n(1 word)", "unread"},
            // 80
            {"poatlp", "laptop", "Portable computer \n(1 word)", "unread"},
            {"seewart", "sweater", "Warm and possibly ugly \n(1 word)", "unread"},
            {"ajcekt", "jacket", "worn for warmth \n(1 word)", "unread"},
            {"oseh", "shoe", "Always sold in pairs \n(1 word)", "unread"},
            {"botso", "boots", "Durable foot guards \n(1 word)", "unread"},
            {"onlcw", "clown", "Funny or terrifying \n(1 word)", "unread"},
            {"idzwra", "wizard", "Not a 'muggle' \n(1 word)", "unread"},
            {"lwjee", "jewel", "Natural and valuable \n(1 word)", "unread"},
            {"ogdl", "gold", "Dense and precious \n(1 word)", "unread"},
            {"lesvir", "silver", "Similar to grey \n(1 word)", "unread"},
            // 90
            {"owdo", "wood", "Construction material \n(1 word)", "unread"},
            {"emtla", "metal", "Music genre \n(1 word)", "unread"},
            {"hcoocetal", "chocolate", "Brown and tasty \n(1 word)", "unread"},
            {"gitnh", "night", "Not day \n(1 word)", "unread"},
            {"ornimgn", "morning", "Before noon \n(1 word)", "unread"},
            {"apncake", "pancake", "Goes well with syrup \n(1 word)", "unread"},
            {"aocbn", "bacon", "Many pigs final form \n(1 word)", "unread"},
            {"nksae", "snake", "Scale covered \n(1 word)", "unread"},
            {"cibr", "crib", "Baby bed \n(1 word)", "unread"},
            {"tware", "water", "Necessary to live \n(1 word)", "unread"},};
            // 100








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
            {"napspewer", "newspaper", "Morning delivery \n(1 word)", "unread"},
            // 30
            {"snnghviagkit", "thanksgiving", "The day turkeys dread \n(1 word)", "unread"},
            {"trhcsiasm", "christmas", "Present day \n(1 word)", "unread"},
            {"lahlonewe", "halloween", "Trick or treat \n(1 word)", "unread"},
            {"omnlpoyo", "monopoly", "Never play with family \n(1 word)", "unread"},
            {"ifmileet", "lifetime", "As long as you live \n(1 word)", "unread"},
            {"scsorwlka  ", "crosswalk", "Watch for children \n(1 word)", "unread"},
            {"ominolght", "moonlight", "See in the dark \n(1 word)", "unread"},
            {"sotmeseim", "sometimes", "Not always \n(1 word)", "unread"},
            {"ftlsribeetu", "butterflies", "Old caterpillars \n(1 word)", "unread"},
            {"ewaehntarm", "weatherman", "Tries to predict nature \n(1 word)", "unread"},
            // 40
            {"caobekbn", "backbone", "You lack this without courage \n(1 word)", "unread"},
            {"sfiwrorke", "fireworks", "Entertaining explosions \n(1 word)", "unread"},
            {"drorilaa", "railroad", "Train highway \n(1 word)", "unread"},
            {"rbthawcok", "throwback", "Old school \n(1 word)", "unread"},
            {"bcakradw", "grandmother", "Old and sweet \n(1 word)", "unread"},
            {"eabsaktord", "skateboard", "Needed for a kickflip \n(1 word)", "unread"},
            {"douedgnunrr", "underground", "Buried \n(1 word)", "unread"},
            {"oeonhyonm", "honeymoon", "Newly married \n(1 word)", "unread"},
            {"uomshrentdrt", "thunderstorm", "Loud, gloomy, and wet \n(1 word)", "unread"},
            {"eaiaplnr", "airplane", "Quick travel method \n(1 word)", "unread"},
            // 50
            {"sbeybiattr", "babysitter", "Popular teenage job \n(1 word)", "unread"},
            {"muhbrgrea", "hamburger", "Cow product \n(1 word)", "unread"},
            {"ootkthicp", "toothpick", "Oral tool \n(1 word)", "unread"},
            {"udothwocn", "touchdown", "Worth six points \n(1 word)", "unread"},
            {"toptoshtea", "toothpaste", "Do not swallow \n(1 word)", "unread"},
            {"pkaremcae", "pacemaker", "Keeps the blood flowing \n(1 word)", "unread"},
            {"deewken", "weekend", "Always looking forward to it \n(1 word)", "unread"},
            {"nueadreg", "underage", "Too young \n(1 word)", "unread"},
            {"oowbormk", "bookworm", "Love to read \n(1 word)", "unread"},
            {"krofflit", "forklift", "Heavy lifting machine \n(1 word)", "unread"},
            // 60
            {"iefulargd", "lifeguard", "No running!!! \n(1 word)", "unread"},
            {"eatfrawll", "waterfall", "Niagra Falls \n(1 word)", "unread"},
            {"obmkoark", "bookmark", "Holds your place \n(1 word)", "unread"},
            {"rlputaaruens", "supernatural", "Not normal \n(1 word)", "unread"},
            {"oofkhbles", "bookshelf", "Needs dusting \n(1 word)", "unread"},
            {"okyeelh", "keyhole", "Peep through to see \n(1 word)", "unread"},
            {"pkacacbk", "backpack", "Student storage \n(1 word)", "unread"},
            {"hfreeoad", "forehead", "Between hair and eyes \n(1 word)", "unread"},
            {"ttoexobk", "textbook", "Learning material \n(1 word)", "unread"},
            {"ekpdya", "keypad", "Enter your pin \n(1 word)", "unread"},
            // 70
            {"dkcsieik", "sidekick", "Hero helper \n(1 word)", "unread"},
            {"pabakscec", "backspace", "Remove previous key \n(1 word)", "unread"},
            {"roduengd", "underdog", "Unfavored \n(1 word)", "unread"},
            {"cbakeirf", "backfire", "Unexpected \n(1 word)", "unread"},
            {"iatseutmerend", "underestimate", " \n(1 word)", "unread"},
            {"yieegsth", "eyesight", "If lost, you're lost \n(1 word)", "unread"},
            {"nsauebth", "sunbathe", "Burning and relaxing \n(1 word)", "unread"},
            {"aunremdr", "underarm", "Prone to sweat \n(1 word)", "unread"},
            {"erpuohesr", "superhero", "Has special powers \n(1 word)", "unread"},
            {"mapireran", "repairman", "Paid to fix \n(1 word)", "unread"},
            // 80
            {"jlacacbkk", "blackjack", "Popular game \n(1 word)", "unread"},
            {"lrlmaobo", "ballroom", "Dancing area \n(1 word)", "unread"},
            {"elaidned", "deadline", "Due date \n(1 word)", "unread"},
            {"audtpe", "update", "Keep in the loop \n(1 word)", "unread"},
            {"higerfiterf", "firefighter", "Sprays water, saves kittens \n(1 word)", "unread"},
            {"wiranob", "rainbow", "Seven colors and bent \n(1 word)", "unread"},
            {"edagurp", "upgrade", "Gets better \n(1 word)", "unread"},
            {"nerfdipsih", "friendship", "What friends have \n(1 word)", "unread"},
            {"clraopo", "carpool", "Drive together \n(1 word)", "unread"},
            {"cponumig", "upcoming", "Soon \n(1 word)", "unread"},
            // 90
            {"olbktacu", "blackout", "Drink too much \n(1 word)", "unread"},
            {"txacbia", "taxicab", "Whistle to call over \n(1 word)", "unread"},
            {"serpupace", "uppercase", "LIKE THIS \n(1 word)", "unread"},
            {"sihdrwate", "dishwater", "Held in sink \n(1 word)", "unread"},
            {"crtpora", "carport", "Where the car sleeps \n(1 word)", "unread"},
            {"potruo", "uproot", "Pull out \n(1 word)", "unread"},
            {"cdbaardro", "cardboard", "Box material \n(1 word)", "unread"},
            {"wcetrhael", "cartwheel", "Gymnastic move \n(1 word)", "unread"},
            {"atweomrk", "teamwork", "Done together \n(1 word)", "unread"},
            {"eacerrfe", "carefree", "No worries \n(1 word)", "unread"},};
            // 100

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
            {"green ole tv", "never let go", "Hold on \n(3 words)", "unread"},
            {"ray hid uh iron", "harry houdini", "Famous magician \n(2 words)", "unread"},
            //30
            {"emag fo htesrno", "game of thrones", "Spoiler: everyone dies \n(3 words)", "unread"},
            {"het eughrn meags", "the hunger games", "Kids fight to the death \n(3 words)", "unread"},
            {"oldr fo teh girns", "lord of the rings", "Short people, long journey \n(4 words)", "unread"},
            {"iobbl gginabs", "bilbo baggins", "Fictional ring thief \n(2 words)", "unread"},
            {"yad fo eth edad", "day of the dead", "Celebration of death \n(4 words)", "unread"},
            {"ldan fo eth edda", "land of the dead", "2005 Zombie movie \n(4 words)", "unread"},
            {"eht nalikgw edad", "the walking dead", "CARLLLLL!! \n(3 words)", "unread"},
            {"nleifxt adn llhic", "netflix and chill", "Modern hook up phrase \n(3 words)", "unread"},
            {"oainatln taehnm", "national anthem", "Home of the brave \n(2 words)", "unread"},
            {"atannoil raeturse", "national treasure", "Mr. Cage, treasure hunter \n(2 words)", "unread"},
            //40
            {"apkes on eilv", "speak no evil", "Talk nicely \n(3 words)", "unread"},
            {"totga chatc meht lal", "gotta catch them all", "Pokemon \n(4 words)", "unread"},
            {"a iedm a onzde", "a dime a dozen", "Not unique \n(4 words)", "unread"},
            {"cepei fo ceak", "piece of cake", "Easy \n(3 words)", "unread"},
            {"acbk ot qserau eno", "back to square one", "Start over \n(4 words)", "unread"},
            {"sbutr ruyo ulbbeb", "burst your bubble", "Ruin a good moment \n(3 words)", "unread"},
            {"rbkea teh eic", "break the ice", "Remove awkwardness \n(3 words)", "unread"},
            {"cpu fo oje", "cup of joe", "Morning beverage \n(3 words)", "unread"},
            {"tuc ot eht chsea", "cut to the chase", "Get to the point \n(4 words)", "unread"},
            {"ndow ot thaer", "down to earth", "Humble or practical \n(3 words)", "unread"},
            //50
            {"waingdr a nbkla", "drawing a blank", "Failing to remember \n(3 words)", "unread"},
            {"pnpdogir keil fisle", "dropping like flies", "Die in large numbers \n(3 words)", "unread"},
            {"aelpnthe ni hte mroo", "elephant in the room", "Obvious, unaddressed problem \n(4 words)", "unread"},
            {"tighf frei tiwh irfe", "fight fire with fire", "Using enemies tactics against them \n(4 words)", "unread"},
            {"sifh tou fo retaw", "fish out of water", "An unfamiliar situation \n(4 words)", "unread"},
            {"ift sa a fliedd", "fit as a fiddle", "In perfect health \n(4 words)", "unread"},
            {"og uto no a ilbm", "go out on a limb", "Putting yourself in a risky situation \n(5 words)", "unread"},
            {"oydgo wto oshes", "goody two shoes", "Smugly and virtuous \n(3 words)", "unread"},
            {"easgdre nltinghgi", "greased lightning", "Song in Grease \n(2 words)", "unread"},
            {"dhans dnow", "hands down", "Certainly \n(2 words)", "unread"},
            //60
            {"adeh oerv elahs", "head over heals", "Falling in love \n(3 words)", "unread"},
            {"rhad lilp ot llwsawo", "hard pill to swallow", "Difficult to accept \n(4 words)", "unread"},
            {"ihgh nda yrd", "high and dry", "Left behind \n(3 words)", "unread"},
            {"tih lebwo teh tleb", "hit below the belt", "Cheap shot \n(4 words)", "unread"},
            {"ni a lcpkie", "in a pickle", "In a difficult predicament \n(3 words)", "unread"},
            {"gji si pu", "jig is up", "Been found out \n(3 words)", "unread"},
            {"mjipngu teh ung", "jumping the gun", "Starting too early \n(3 words)", "unread"},
            {"rngi ayn leslb", "ring any bells", "Remind you of anything? \n(3 words)", "unread"},
            {"hsot ni eth kadr", "shot in the dark", "Little chance of success \n(4 words)", "unread"},
            {"esye no eth riepz", "eyes on the prize", "Focus \n(4 words)", "unread"},
            //70
            {"ikel hteafr eilk sno", "like father like son", "Runs in the family \n(4 words)", "unread"},
            {"aimnkg a eecsn", "making a scene", "drawing attention \n(3 words)", "unread"},
            {"thumo garwenti", "mouth watering", "Looks delicious \n(2 words)", "unread"},
            {"kcen nda nkce", "neck and neck", "It's close \n(3 words)", "unread"},
            {"on rbrinea", "no brainer", "Little thought required \n(2 words)", "unread"},
            {"no teh asem eapg", "on the same page", "Thinking similarly \n(4 words)", "unread"},
            {"tup a okcs ni ti", "put a sock in it", "Would you shut up? \n(4 words)", "unread"},
            {"arni no ryou preaad", "rain on your parade", "Ruining a happy moment \n(4 words)", "unread"},
            {"osn fo a gnu", "son of a gun", "A bad person \n(4 words)", "unread"},
            {"cnkkelu nowd", "knuckle down", "Applying yourself \n(2 words)", "unread"},
            //80
            {"etl rhe pri", "let her rip", "Permission to start \n(3 words)", "unread"},
            {"rhowt ni eth owetl", "throw in the towel", "Give up \n(4 words)", "unread"},
            {"dunre eht tweerah", "under the weather", "Feeling unwell \n(3 words)", "unread"},
            {"nreud ruyo neso", "under your nose", "Right in front of you \n(3 words)", "unread"},
            {"iht hte aodr", "hit the road", "Leave \n(3 words)", "unread"},
            {"eplda ot hte mealt", "pedal to the metal", "Floor it \n(3 words)", "unread"},
            {"iht eht tlsgih", "hit the lights", "Turn off the lights \n(3 words)", "unread"},
            {"dlho uyro ahbrte", "hold your breath", "To wait on something \n(3 words)", "unread"},
            {"egpedl fo leianlgeca", "pledge of allegiance", "Spoken in school everyday \n(3 words)", "unread"},
            {"gdo seva teh eneuq", "god save the queen", "England's national anthem \n(4 words)", "unread"},
            //90
            {"seu eht oferc", "use the force", "Jedi saying \n(3 words)", "unread"},
            {"eatmrs fo iusgised", "master of disguise", "Good at hiding \n(3 words)", "unread"},
            {"unrt sgialn", "turn signal", "changing lanes \n(2 words)", "unread"},
            {"peno hte orod", "open the door", "Or I'll kick it in! \n(3 words)", "unread"},
            {"smiuacl iahrcs", "musical chairs", "Find a seat quickly \n(2 words)", "unread"},
            {"irce mnactar", "eric cartman", "Screw you guys.. I'm going home \n(2 words)", "unread"},
            {"imswignm wthi het ssfihe", "swimming with the fishes", "Dead \n(4 words)", "unread"},
            {"itme rof dbe", "time for bed", "Dreaded parental phrase \n(3 words)", "unread"},
            {"lsbebaal yaperl", "baseball player", "Paid to hit and run \n(2 words)", "unread"},
            {"sburh oruy ttehe", "brush your teeth", "Cavity free \n(3 words)", "unread"},
            //100


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
        //getAnagram();
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
        getAnagram();

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
