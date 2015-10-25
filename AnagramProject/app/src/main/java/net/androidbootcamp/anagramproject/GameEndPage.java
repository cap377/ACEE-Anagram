package net.androidbootcamp.anagramproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class GameEndPage extends AppCompatActivity {

    public int number_correct = GameStartPage.correct;
    public int total_screens = GameStartPage.screens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_page);

        TextView textView = (TextView) findViewById(R.id.textView12);
        textView.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button mainMenuButton = (Button) findViewById(R.id.button3);
        mainMenuButton.setTypeface(EasyFonts.caviarDreamsBold(this));

        textView.setText("You got:\n" + number_correct + "/" + total_screens +"\nCorrect");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_end_page, menu);
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

    public void NavigateBack(View view){
        startActivity(new Intent(GameEndPage.this, TitlePage.class));
    }

}