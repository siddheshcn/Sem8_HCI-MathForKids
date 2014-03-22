package com.spcomps14.group11.hci.mathforkids;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LearnPage extends Activity
{

    ImageButton homeBtn, leftBtn, rightBtn;
    ImageView screenView;
    int[] screenImage;
    int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_page);
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
        screenImage= new int[]{
                R.drawable.learnzero,
                R.drawable.learnone,
                R.drawable.learntwo,
                R.drawable.learnthree,
                R.drawable.learnfour,
                R.drawable.learnfive,
                R.drawable.learnsix,
                R.drawable.learnseven,
                R.drawable.learneight,
                R.drawable.learnnine,
        };
        screenView= (ImageView)findViewById(R.id.screen);
        screenView.setBackground(getResources().getDrawable(R.drawable.learnstart));

        homeBtn= (ImageButton)findViewById(R.id.home);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        leftBtn= (ImageButton)findViewById(R.id.left);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //left button function;
                if(state==0)
                    finish();
                else
                {
                    state--;
                    screenView.setBackground(getResources().getDrawable(screenImage[state%10]));
                }
            }
        });

        rightBtn= (ImageButton)findViewById(R.id.right);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //right button function;
                state++;
                screenView.setBackground(getResources().getDrawable(screenImage[state%10]));
            }
        });
    }


}
