package com.spcomps14.group11.hci.mathforkids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.spcomps14.group11.hci.mathforkids.util.SystemUiHider;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class StartPage extends Activity
{
    private ImageButton learnBtn, countBtn, solveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        onWindowFocusChanged(true);
        init();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            findViewById(android.R.id.content).setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    public void init()
    {
        learnBtn= (ImageButton)findViewById(R.id.learnButton);
        learnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent learnIntent= new Intent(StartPage.this, LearnPage.class);
                StartPage.this.startActivity(learnIntent);
            }
        });

        countBtn= (ImageButton)findViewById(R.id.countButton);
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent countIntent= new Intent(StartPage.this, CountPage.class);
                StartPage.this.startActivity(countIntent);
            }
        });

        solveBtn= (ImageButton)findViewById(R.id.solveButton);
        solveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent solveIntent= new Intent(StartPage.this, SolvePage.class);
                StartPage.this.startActivity(solveIntent);

            }
        });
    }

}
