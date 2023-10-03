package com.example.yogafit_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity2 extends AppCompatActivity {


    int[] newArray;


    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);


        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        newArray = new int[]{



                R.id.bow_pose_1v2,R.id.bridge_pose_2v2,R.id.chair_pose_3v2,
                R.id.child_pose_4v2,R.id.cobbler_pose_5v2,R.id.cow_pose_6v2,
                R.id.playji_pose_7v2,R.id.pauseji_pose_8v2,R.id.plank_pose_9v2,
                R.id.crunches_pose_10v2,R.id.situp_pose_11v2,R.id.rotation_pose_12v2,
                R.id.twisht_pose_13v2,R.id.windmill_pose_14v2,R.id.legup_pose_15v2,






        };

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/dQw4w9WgXcQ?si=F2Bp4Lq4pFW0f1gk"));
            startActivity(intent);


            return true;
        }
        if (id == R.id.id_term){

            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://docs.google.com/document/d/1KQp41PQ3lxRlfN0rao1jW7zY1Z-NUdBZN1CZQh2sAYQ/edit"));
            startActivity(intent);


            return true;
        }
        if (id == R.id.rate){

            try {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));


            }catch (Exception ex){

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

            }


            return true;
        }
        if (id == R.id.more){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/17WJkP0B75TEgKZmVgdvxDE2NRt5vdL9Phi4tjt2jC-0/edit?usp=sharing"));
            startActivity(intent);


            return true;
        }
        if (id == R.id.share){

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the best app that you ever see! \n If you join us you can participate in the competition of Mr.Bist! \n Absolutely free! \n P.S. It is required to sign an agreement." + "https://play.google.com/store/apps/details?id=com.example.yogafit_app&hl=en";
            String sharehub = "Yoga App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));


            return true;
        }

        return true;
    }


    public void Imagebuttoncliked(View view) {



        for (int i=0; i< newArray.length; i++){


            if (view.getId() == newArray[i]) {
                int value = i+1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this, ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);


            }
        }



    }
}