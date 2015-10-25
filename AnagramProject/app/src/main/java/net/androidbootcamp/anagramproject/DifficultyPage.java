package net.androidbootcamp.anagramproject;

import android.content.Intent;
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

import java.security.Policy;

public class DifficultyPage extends AppCompatActivity {
    static int difficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_page);

        TextView selectDifficulty = (TextView) findViewById(R.id.Selectdifficulty);
        selectDifficulty.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button easyButton = (Button) findViewById(R.id.Easybutton);
        easyButton.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button mediumButton = (Button) findViewById(R.id.Mediumbutton);
        mediumButton.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button hardButton = (Button) findViewById(R.id.Hardbutton);
        hardButton.setTypeface(EasyFonts.caviarDreamsBold(this));

        final Animation anime = AnimationUtils.loadAnimation(this, R.anim.anim_scale_change);

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                difficulty = 1;
                startActivity(new Intent(DifficultyPage.this, GameStartPage.class));
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                difficulty = 2;
                startActivity(new Intent(DifficultyPage.this, GameStartPage.class));
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                difficulty = 3;
                startActivity(new Intent(DifficultyPage.this, GameStartPage.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_difficulty_page, menu);
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