package net.androidbootcamp.anagramproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;


public class GameStartPage extends AppCompatActivity {

    public EditText timer;
    private ButtonClickListener btnClick = new ButtonClickListener();
    public CountDownTimer myTimer;
    public int numWrong = 0;
    public int numRight = 0;

    public void createTimer(){

         myTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Time Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                numWrong += 1;
                createTimer();

            }


        }.start();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start_page);

        createTimer();

        timer = (EditText) findViewById(R.id.timer);



        int idList[] = {R.id.resetbutton};

        for (int id:idList){
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
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
    private class ButtonClickListener implements View.OnClickListener {

        public void onClick(View v){
            switch(v.getId()){
                case R.id.resetbutton:
                    myTimer.cancel();
                    createTimer();

                    break;

                default:

                    break;
            }
        }
    }
}
