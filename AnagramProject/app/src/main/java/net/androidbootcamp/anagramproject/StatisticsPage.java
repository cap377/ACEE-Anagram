package net.androidbootcamp.anagramproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class StatisticsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_page);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);

        String gamesPlayed = preferences.getString("GamesPlayed", "");
        String wordsFound = preferences1.getString("WordsFound", "");
        String wordsMissed = preferences2.getString("WordsMissed","");
        //if(!gamesPlayed.equalsIgnoreCase("")){
          //  gamesPlayed = gamesPlayed;
        //}
        TextView statTitle = (TextView) findViewById(R.id.statTitle);
        statTitle.setTypeface(EasyFonts.caviarDreamsBold(this));
        statTitle.setText("Statistics");

        TextView statText = (TextView) findViewById(R.id.statText);
        statText.setTypeface(EasyFonts.caviarDreamsBold(this));
        statText.setText("Games Played: "+gamesPlayed+"\n"+"Words Found: "+wordsFound +"\n"+"Words Missed: "+wordsMissed);

        Button button1 = (Button) findViewById(R.id.backbutton);
        button1.setTypeface(EasyFonts.caviarDreamsBold(this));

        final Animation anime = AnimationUtils.loadAnimation(this, R.anim.anim_scale_change);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                startActivity(new Intent(StatisticsPage.this, TitlePage.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics_page, menu);
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
}