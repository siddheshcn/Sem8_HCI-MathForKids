package com.spcomps14.group11.hci.mathforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;


public class CountPage extends Activity implements View.OnClickListener {

    ImageButton homeBtn, nextBtn;
    ImageButton screen;
    ImageButton noBtn[];
    ImageButton tcBox[];
    Random randomGenerator;
    int[] screenImages, whiteChalk, greyChalk;

    int clickedNo, questionNo, randomNumber, state, count;
    int[] questionSet;
    boolean noClicked, start, showingQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_page);
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
        randomGenerator= new Random();
        state=9;
        count=0;
        clickedNo=0;
        questionSet= new int[]{0,1,2,3,4,5,6,7,8,9};
        noClicked= false;
        showingQuestion=false;
        start=false;


        homeBtn= (ImageButton)findViewById(R.id.btnHome);
        homeBtn.setOnClickListener(this);
        nextBtn= (ImageButton)findViewById(R.id.btnNext);
        nextBtn.setOnClickListener(this);

        noBtn= new ImageButton[10];
        noBtn[0]= (ImageButton)findViewById(R.id.btn0);
        noBtn[1]= (ImageButton)findViewById(R.id.btn1);
        noBtn[2]= (ImageButton)findViewById(R.id.btn2);
        noBtn[3]= (ImageButton)findViewById(R.id.btn3);
        noBtn[4]= (ImageButton)findViewById(R.id.btn4);
        noBtn[5]= (ImageButton)findViewById(R.id.btn5);
        noBtn[6]= (ImageButton)findViewById(R.id.btn6);
        noBtn[7]= (ImageButton)findViewById(R.id.btn7);
        noBtn[8]= (ImageButton)findViewById(R.id.btn8);
        noBtn[9]= (ImageButton)findViewById(R.id.btn9);
        for (int i=0; i<10; i++)
        {
            noBtn[i].setOnClickListener(this);
        }

        tcBox= new ImageButton[10];
        tcBox[0]= (ImageButton)findViewById(R.id.tc1);
        tcBox[1]= (ImageButton)findViewById(R.id.tc2);
        tcBox[2]= (ImageButton)findViewById(R.id.tc3);
        tcBox[3]= (ImageButton)findViewById(R.id.tc4);
        tcBox[4]= (ImageButton)findViewById(R.id.tc5);
        tcBox[5]= (ImageButton)findViewById(R.id.tc6);
        tcBox[6]= (ImageButton)findViewById(R.id.tc7);
        tcBox[7]= (ImageButton)findViewById(R.id.tc8);
        tcBox[8]= (ImageButton)findViewById(R.id.tc9);
        tcBox[9]= (ImageButton)findViewById(R.id.tc10);

        screen= (ImageButton)findViewById(R.id.countScreen);
        screen.setOnClickListener(this);

//        Initialization of image array.
        screenImages= new int[]{R.drawable.btn0_white,
                R.drawable.btn1_white,
                R.drawable.btn2_white,
                R.drawable.btn3_white,
                R.drawable.btn4_white,
                R.drawable.btn5_white,
                R.drawable.btn6_white,
                R.drawable.btn7_white,
                R.drawable.btn8_white,
                R.drawable.btn9_white};

        whiteChalk= new int[]{R.drawable.btn0_white,
                R.drawable.btn1_white,
                R.drawable.btn2_white,
                R.drawable.btn3_white,
                R.drawable.btn4_white,
                R.drawable.btn5_white,
                R.drawable.btn6_white,
                R.drawable.btn7_white,
                R.drawable.btn8_white,
                R.drawable.btn9_white};

        greyChalk= new int[]{R.drawable.btn0_grey,
                R.drawable.btn1_grey,
                R.drawable.btn2_grey,
                R.drawable.btn3_grey,
                R.drawable.btn4_grey,
                R.drawable.btn5_grey,
                R.drawable.btn6_grey,
                R.drawable.btn7_grey,
                R.drawable.btn8_grey,
                R.drawable.btn9_grey};

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn0: numberClick(0);
            break;

            case R.id.btn1: numberClick(1);
            break;

            case R.id.btn2: numberClick(2);
            break;

            case R.id.btn3: numberClick(3);
            break;

            case R.id.btn4: numberClick(4);
            break;

            case R.id.btn5: numberClick(5);
            break;

            case R.id.btn6: numberClick(6);
            break;

            case R.id.btn7: numberClick(7);
            break;

            case R.id.btn8: numberClick(8);
            break;

            case R.id.btn9: numberClick(9);
            break;

            case R.id.btnHome:finish();
            break;

            case R.id.btnNext:
                if(noClicked==false && start==true )
                    tcBox[count++].setBackground(getResources().getDrawable(R.drawable.crossdash));
                nextQuestion();
            break;

            case R.id.countScreen:
                if(showingQuestion==false)
                    nextQuestion();
                break;
        }
    }

    public void nextQuestion()
    {
        noClicked= false;
        if(state>=0)
        {
            noBtn[clickedNo].setBackground(getResources().getDrawable(greyChalk[clickedNo]));
            if(state>0) {
                start=true;
                randomNumber = randomGenerator.nextInt(state);
            }
            else {
                randomNumber = 0;
            }
            questionNo = questionSet[randomNumber];
            removeQuestion();
            screen.setBackground(getResources().getDrawable(screenImages[questionNo]));
            showingQuestion=true;
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Start again?")
                    .setMessage("All 10 questions are answered. Do you want to take the quiz again?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resetAll();
                            start=false;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            start=false;
                        }
                    })
                    .show();
        }
    }

    public void removeQuestion()
    {
        //Remove the question number from the array and reduce the size of the array.
        int i= randomNumber;
        int temp= questionSet[i];
        questionSet[i]= questionSet[state];
        questionSet[state]= temp;
        state--;
    }

    public void numberClick(int no)
    {
        if(noClicked==false && start== true)
        {
            noClicked = true;
            showingQuestion=false;
            clickedNo = no;
            setNumberClicked(no);
            if (isCorrect()) {
                screen.setBackground(getResources().getDrawable(R.drawable.tick_screen));
                tcBox[count++].setBackground(getResources().getDrawable(R.drawable.tickdash));
            } else {
                screen.setBackground(getResources().getDrawable(R.drawable.cross_screen));
                tcBox[count++].setBackground(getResources().getDrawable(R.drawable.crossdash));
            }
        }
    }

    public void setNumberClicked(int no)
    {
        //set image to number clicked
        noBtn[no].setBackground(getResources().getDrawable(whiteChalk[no]));
    }

    public boolean isCorrect()
    {
        //check if the selected option is correct
        if(clickedNo==questionNo)
            return true;
        else
            return false;
    }

    public void resetAll()
    {
        noBtn[clickedNo].setBackground(getResources().getDrawable(greyChalk[clickedNo]));
        screen.setBackground(getResources().getDrawable(R.drawable.count_startscreen));
        showingQuestion=false;
        state=9;
        count=0;
        clickedNo=0;
        questionSet= new int[]{0,1,2,3,4,5,6,7,8,9};
        for(int i=0; i<10; i++)
            tcBox[i].setBackground(getResources().getDrawable(R.drawable.dash));
    }

}
