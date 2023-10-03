package com.example.yogafit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunnig;
    private long MTimeLefttinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){



            case 1:
                setContentView(R.layout.activity_bow_pose_1_v2);
                break;
            case 2:
                setContentView(R.layout.activity_bridge_pose_2_v2);
                break;
            case 3:
                setContentView(R.layout.activity_chair_pose_3_v2);
                break;
            case 4:
                setContentView(R.layout.activity_child_pose_4_v2);
                break;
            case 5:
                setContentView(R.layout.activity_cobbler_pose_5_v2);
                break;
            case 6:
                setContentView(R.layout.activity_cow_pose_6_v2);
                break;
            case 7:
                setContentView(R.layout.activity_playji_pose_7_v2);
                break;
            case 8:
                setContentView(R.layout.activity_pauseji_pose_8_v2);
                break;
            case 9:
                setContentView(R.layout.activity_plank_pose_9_v2);
                break;
            case 10:
                setContentView(R.layout.activity_crunches_pose_10_v2);
                break;
            case 11:
                setContentView(R.layout.activity_situp_pose_11_v2);
                break;
            case 12:
                setContentView(R.layout.activity_rotation_pose_12_v2);
                break;
            case 13:
                setContentView(R.layout.activity_twisht_pose_13_v2);
                break;
            case 14:
                setContentView(R.layout.activity_windmill_pose_14_v2);
                break;
            case 15:
                setContentView(R.layout.activity_legup_pose_15_v2);
                break;



        }



        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MTimeRunnig)

                {
                    stoptimer();


                }

                else {
                    startTimer();


                }
            }
        });

    }


    private void stoptimer()

    {

        countDownTimer.cancel();
        MTimeRunnig=false;
        startBtn.setText("START");

    }

    private void startTimer()
    {
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);




        final int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MTimeLefttinmills = number*1000;



        countDownTimer = new CountDownTimer(MTimeLefttinmills, 1000) {
            @Override
            public void onTick(long l) {


                MTimeLefttinmills = l;
                updateTimer();

            }

            @Override
            public void onFinish() {


                int newvalue = Integer.valueOf(buttonvalue)+1;
                if (newvalue<=7){

                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }

                else {

                    newvalue =1;
                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);



                }

            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunnig=true;



    }



    private void updateTimer()



    {


        int minutes = (int) MTimeLefttinmills/60000;
        int seconds = (int) MTimeLefttinmills%60000 /1000;



        String timeLeftText="";
        if(minutes<10)
            timeLeftText = "0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }


    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}