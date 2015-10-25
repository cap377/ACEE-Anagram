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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_page);

        Intent intent = getIntent();
        String info = intent.getStringExtra(GameStartPage.EXTRA_MESSAGE);

        TextView finishText = (TextView) findViewById(R.id.textView10);
        finishText.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView text1 = (TextView) findViewById(R.id.textView11);
        text1.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView textView = (TextView) findViewById(R.id.textView12);
        textView.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView text2 = (TextView) findViewById(R.id.textView13);
        text2.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView textView1 = (TextView) findViewById(R.id.textView14);
        textView1.setTypeface(EasyFonts.caviarDreamsBold(this));

        TextView text3 = (TextView) findViewById(R.id.textView15);
        text3.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button mainMenuButton = (Button) findViewById(R.id.button3);
        mainMenuButton.setTypeface(EasyFonts.caviarDreamsBold(this));


        char[] chars = info.toCharArray();

        int i = 0;
        String info1 = "";
        String info2 = "";
        while(i < chars.length){
            if(chars[i] == '|'){
                i++;
                break;
            }
            info1 += chars[i];
            i++;
        }

        while(i < chars.length){
            info2 += chars[i];
            i++;
        }

        textView.setText(info1);
        textView1.setText(info2);

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