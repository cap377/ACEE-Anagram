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

//http://android-er.blogspot.com/2012/02/apply-animation-on-button.html

public class TitlePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTypeface(EasyFonts.caviarDreamsBold(this));

        Button button1 = (Button) findViewById(R.id.startbutton);
        button1.setTypeface(EasyFonts.caviarDreamsBold(this));
        Button button2 = (Button) findViewById(R.id.aboutbutton);
        button2.setTypeface(EasyFonts.caviarDreamsBold(this));


        final Animation anime = AnimationUtils.loadAnimation(this, R.anim.anim_scale_change);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                startActivity(new Intent(TitlePage.this, DifficultyPage.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.startAnimation(anime);
                startActivity(new Intent(TitlePage.this, AboutPage.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_title_page, menu);
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
