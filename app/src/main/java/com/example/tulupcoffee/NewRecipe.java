package com.example.tulupcoffee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class NewRecipe extends AppCompatActivity {
    ProgressBar progressBar;
    TextView s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,method_name;
    ImageView start,back,pause,resume;
    MyCountDownTimer myCountDownTimer;
    //int total_seconds = 5000;
    long timeLeft,t1,t2,t3,t4,t5,t6,t8,t7,t10,t11,t9;
    String flag;
    int px = 160;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initialise();
        steps_setter();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(NewRecipe.this, "Timer"+t8, Toast.LENGTH_SHORT).show();
                if(flag.equals("1")){
                    t1 = 5; t2 = 10; t3 = 15; t4 = 35; t5 = 42; t6 = 46; t7 = 106; t8 = 118;
                    progressBar.setMax((int)t8);
                    myCountDownTimer = new MyCountDownTimer(t8*1000, 1000);
                    myCountDownTimer.start();
                }else if(flag.equals("2")){
                    t1 = 5; t2 = 15; t3 = 21; t4 = 40; t5 = 50; t6 = 290; t7 = 300; t8 = 305;
                    progressBar.setMax((int)t8);
                    myCountDownTimer = new MyCountDownTimer(t8*1000, 1000);
                    myCountDownTimer.start();
                }else if(flag.equals("3")){
                    t1 = 5; t2 = 12; t3 = 17; t4 = 32; t5 = 52; t6 = 66; t7 = 86; t8 = 87;
                    progressBar.setMax((int)t8);
                    myCountDownTimer = new MyCountDownTimer(t8*1000, 1000);
                    myCountDownTimer.start();
                }else if(flag.equals("4")){
                    t1 = 10; t2 = 16; t3 = 20; t4 =32; t5 = 36; t6 = 96; t7 = 111; t8 = 126; t9=141; t10=146; t11=156;
                    progressBar.setMax((int)t11);
                    myCountDownTimer = new MyCountDownTimer(t11*1000, 1000);
                    myCountDownTimer.start();
                }
               // Toast.makeText(NewRecipe.this, "Flag "+flag, Toast.LENGTH_SHORT).show();
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer= new MyCountDownTimer(156*1000,1000);
                myCountDownTimer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer.cancel();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewRecipe.this,Ingrediant_Selection.class);
                intent.putExtra("Flag",flag);
                startActivity(intent);
                finish();
            }
        });
      }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NewRecipe.this,Ingrediant_Selection.class);
        intent.putExtra("Flag",flag);
        startActivity(intent);
        finish();
    }

    private void initialise() {
        s1 = findViewById(R.id.step1);
        s2 = findViewById(R.id.step2);
        s3 = findViewById(R.id.step3);
        s4 = findViewById(R.id.step4);
        s5 = findViewById(R.id.step5);
        s6 = findViewById(R.id.step6);
        s7 = findViewById(R.id.step7);
        s8 = findViewById(R.id.step8);
        s9 = findViewById(R.id.step9);
        s10 = findViewById(R.id.step10);
        s11 = findViewById(R.id.step11);
        s12 = findViewById(R.id.step12);
        progressBar = findViewById(R.id.barTimer);
        start = findViewById(R.id.play);
        progressBar.setProgress(0);
        method_name = findViewById(R.id.method);
        back = findViewById(R.id.back);
        pause=findViewById(R.id.pause);
        resume=findViewById(R.id.resume);

    }
    public void steps_setter(){
        Intent intent =getIntent();
        String dose = intent.getStringExtra("dose");
        String water_amt = intent.getStringExtra("water_amt");
        flag = intent.getStringExtra("Flag");
        //Toast.makeText(this, "Flag"+flag, Toast.LENGTH_SHORT).show();
        water_amt = water_amt.substring(0,3);
        if(flag.equals("1")){
            method_name.setText("AeroPress");
            double initial = Double.parseDouble(water_amt)/8;
            double step5_water = Double.parseDouble(water_amt) - initial;
            s1.setText("Add "+dose+" of coffee into the chamber");
            s2.setText("Pour "+initial+"ml of water into the chamber");
            s3.setText("Stir in one Direction");
            s4.setText("Wait for coffee to bloom");
            s5.setText("Pour "+step5_water+"ml of water");
            s6.setText("Place the pluger on the top and pull it a little bit till you feel the suction");
            s7.setText("let the coffee Brew");
            s8.setText("Gently press the plunger");
            s9.setText("Ready to sip!");

        }else if(flag.equals("2")){
            method_name.setText("FrenchPress");
            double initial = Double.parseDouble(water_amt)/6;
            double step5_water = Double.parseDouble(water_amt) - initial;
            s1.setText("Add "+dose+" of coffee into the chamber");
            s2.setText("Pour "+String.format("%.0f", initial)+"ml of water to immerse the coffee grounds");
            s3.setText("Stir in one Direction");
            s4.setText("Wait for coffee to bloom");
            s5.setText("Pour "+String.format("%.0f", step5_water)+"ml of water");
            s6.setText("Let the coffee brew for 4 minutes");
            s7.setText("Put the filter in and gently push it down");
            s8.setText("Serve in a cup");
            s9.setText("Ready to sip!");


        }else if(flag.equals("3")){
            method_name.setText("v60 PourOver");
            double initial = Double.parseDouble(water_amt)/5;
            double step5_water = Double.parseDouble(water_amt) - initial;
            s1.setText("Put the filter paper in the cone");
            s2.setText("Wet the paper with hot water (discard that water)");
            s3.setText("Add "+dose+" gms of coffee into the paper");
            s4.setText("Pour "+String.format("%.0f", initial)+ "ml of water in a circular motion");
            s5.setText("Let the coffee bloom");
            s6.setText("Pour "+String.format("%.0f", step5_water)+"ml of water in a circular motion");
            s7.setText("Wait for the coffee to drip");
            s9.setText("Ready to sip!");
            s8.setVisibility(View.GONE);


        }else if(flag.equals("4")){
            // Change your steps here s1 means step 1 s2 means step 2 and so on so accordingly change your steps. Also those values from previous
            // activity is taken in 2 data initial and step5_answer so accordingly kar lena waisa changes.
            // about the timing part for each step t1 t2 t3 are their respective timing so vo hisab se changes kar dena
            method_name.setText("Moka Pota");
            /*double initial = Double.parseDouble(water_amt)/8;
            double step5_water = Double.parseDouble(water_amt) - initial;*/
            s1.setText("Pour hot water into the bottom chamber up till the screw");
            s2.setText("Add the ground coffee into the funnel.");
            s3.setText("Insert the funnel in the bottom chamber ");
            s4.setText("Tighten the top chamber onto the bottom chamber carefully");
            s5.setText("Keep the moka pot on a stove on medium heater");
            s6.setText("Wait for the water to boil and let the coffee start oozing");
            s7.setText("Once you hear the hissing sound turn of the stove and take the moka pot down");
            s8.setText("Run tap water on the bottom chamber to cool down the moka pot");
            s9.setText("Pour the espresso shot it in a cup");
            s10.setText("Add water or milk as per taste");
            s11.setText("Ready to sip!");

        }
    }
    public  void steps_changer() {
        if(flag.equals("1")|| flag.equals("2")||flag.equals("3")){
            if (timeLeft == t1) {
                s1.setAlpha((float) 0.3);
                s1.setTextSize(20);
                s1.setTextColor(getResources().getColor(R.color.GrayColor));
                s2.setAlpha(1);
                s2.setTextSize(30);
                s2.setTextColor(getResources().getColor(R.color.GreenColor));
                s3.setAlpha((float) 0.3);
            } else if (timeLeft == t2) {
                s1.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s2.setLayoutParams(params);
                s2.setAlpha((float) 0.3);
                s2.setTextSize(20);
                s2.setTextColor(getResources().getColor(R.color.GrayColor));
                s3.setAlpha(1);
                s3.setTextSize(30);
                s3.setTextColor(getResources().getColor(R.color.GreenColor));
                s4.setAlpha((float) 0.3);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
            } else if (timeLeft == t3) {
                s2.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s3.setLayoutParams(params);
                s3.setAlpha((float) 0.3);
                s3.setTextSize(20);
                s3.setTextColor(getResources().getColor(R.color.GrayColor));
                s4.setAlpha(1);
                s4.setTextSize(30);
                s4.setTextColor(getResources().getColor(R.color.GreenColor));
                s5.setAlpha((float) 0.3);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds  = 20000;
                // time = 1000*1000/total_seconds;
            } else if (timeLeft == t4) {
                s3.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s4.setLayoutParams(params);
                s4.setAlpha((float) 0.3);
                s4.setTextSize(20);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
                s5.setAlpha(1);
                s5.setTextSize(30);
                s5.setTextColor(getResources().getColor(R.color.GreenColor));
                s6.setAlpha((float) 0.3);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 7000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t5) {
                s4.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s5.setLayoutParams(params);
                s5.setAlpha((float) 0.3);
                s5.setTextSize(20);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                s6.setAlpha(1);
                s6.setTextSize(30);
                s6.setTextColor(getResources().getColor(R.color.GreenColor));
                s7.setAlpha((float) 0.3);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 4000;
                // time = 1000*1000/total_seconds;
            } else if (timeLeft == t6) {
                s5.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(40, px, 40, 0);
                s6.setLayoutParams(params);
                s6.setAlpha((float) 0.3);
                s6.setTextSize(20);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                s7.setAlpha(1);
                s7.setTextSize(30);
                s7.setTextColor(getResources().getColor(R.color.GreenColor));
                s8.setAlpha((float) 0.3);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 60000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t7) {
                s6.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s7.setLayoutParams(params);
                s7.setAlpha((float) 0.3);
                s7.setTextSize(20);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                s8.setAlpha(1);
                s8.setTextSize(30);
                s8.setTextColor(getResources().getColor(R.color.GreenColor));
                s9.setAlpha((float) 0.3);
                s9.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 12000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t8) {
                s7.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s8.setLayoutParams(params);
                s8.setAlpha((float) 0.3);
                s8.setTextSize(20);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                s9.setAlpha(1);
                s9.setTextSize(30);
                s9.setTextColor(getResources().getColor(R.color.GreenColor));
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_vehicles_aircraft_call_bell_dual_tone_44562);
                mediaPlayer.start();
                Intent intent = new Intent(NewRecipe.this, CompleteCoffee.class);
                intent.putExtra("Flag", "" + flag);
                startActivity(intent);
                finish();
            }
        }else if(flag.equals("4")){
            if (timeLeft == t1) {
                s1.setAlpha((float) 0.3);
                s1.setTextSize(20);
                s1.setTextColor(getResources().getColor(R.color.GrayColor));
                s2.setAlpha(1);
                s2.setTextSize(30);
                s2.setTextColor(getResources().getColor(R.color.GreenColor));
                s3.setAlpha((float) 0.3);
            } else if (timeLeft == t2) {
                s1.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s2.setLayoutParams(params);
                s2.setAlpha((float) 0.3);
                s2.setTextSize(20);
                s2.setTextColor(getResources().getColor(R.color.GrayColor));
                s3.setAlpha(1);
                s3.setTextSize(30);
                s3.setTextColor(getResources().getColor(R.color.GreenColor));
                s4.setAlpha((float) 0.3);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
            } else if (timeLeft == t3) {
                s2.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s3.setLayoutParams(params);
                s3.setAlpha((float) 0.3);
                s3.setTextSize(20);
                s3.setTextColor(getResources().getColor(R.color.GrayColor));
                s4.setAlpha(1);
                s4.setTextSize(30);
                s4.setTextColor(getResources().getColor(R.color.GreenColor));
                s5.setAlpha((float) 0.3);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds  = 20000;
                // time = 1000*1000/total_seconds;
            } else if (timeLeft == t4) {
                s3.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s4.setLayoutParams(params);
                s4.setAlpha((float) 0.3);
                s4.setTextSize(20);
                s4.setTextColor(getResources().getColor(R.color.GrayColor));
                s5.setAlpha(1);
                s5.setTextSize(30);
                s5.setTextColor(getResources().getColor(R.color.GreenColor));
                s6.setAlpha((float) 0.3);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 7000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t5) {
                s4.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s5.setLayoutParams(params);
                s5.setAlpha((float) 0.3);
                s5.setTextSize(20);
                s5.setTextColor(getResources().getColor(R.color.GrayColor));
                s6.setAlpha(1);
                s6.setTextSize(30);
                s6.setTextColor(getResources().getColor(R.color.GreenColor));
                s7.setAlpha((float) 0.3);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 4000;
                // time = 1000*1000/total_seconds;
            } else if (timeLeft == t6) {
                s5.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(40, px, 40, 0);
                s6.setLayoutParams(params);
                s6.setAlpha((float) 0.3);
                s6.setTextSize(20);
                s6.setTextColor(getResources().getColor(R.color.GrayColor));
                s7.setAlpha(1);
                s7.setTextSize(30);
                s7.setTextColor(getResources().getColor(R.color.GreenColor));
                s8.setAlpha((float) 0.3);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 60000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t7) {
                s6.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s7.setLayoutParams(params);
                s7.setAlpha((float) 0.3);
                s7.setTextSize(20);
                s7.setTextColor(getResources().getColor(R.color.GrayColor));
                s8.setAlpha(1);
                s8.setTextSize(30);
                s8.setTextColor(getResources().getColor(R.color.GreenColor));
                s9.setAlpha((float) 0.3);
                s9.setTextColor(getResources().getColor(R.color.GrayColor));
                //total_seconds = 12000;
                //time = 1000*1000/total_seconds;
            } else if (timeLeft == t8) {
                s7.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s8.setLayoutParams(params);
                s8.setAlpha((float) 0.3);
                s8.setTextSize(20);
                s8.setTextColor(getResources().getColor(R.color.GrayColor));
                s9.setAlpha(1);
                s9.setTextSize(30);
                s9.setTextColor(getResources().getColor(R.color.GreenColor));
    //            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_vehicles_aircraft_call_bell_dual_tone_44562);
    //            mediaPlayer.start();
    //            Intent intent = new Intent(NewRecipe.this, CompleteCoffee.class);
    //            intent.putExtra("Flag", "" + flag);
    //            startActivity(intent);
                //finish();
            } else if (timeLeft == t9) {
                s8.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s9.setLayoutParams(params);
                s9.setAlpha((float) 0.3);
                s9.setTextSize(20);
                s9.setTextColor(getResources().getColor(R.color.GrayColor));
                s10.setAlpha(1);
                s10.setTextSize(30);
                s10.setTextColor(getResources().getColor(R.color.GreenColor));
    //            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_vehicles_aircraft_call_bell_dual_tone_44562);
    //            mediaPlayer.start();
    //            Intent intent = new Intent(NewRecipe.this, CompleteCoffee.class);
    //            intent.putExtra("Flag", "" + flag);
    //            startActivity(intent);
    //            finish();
            } else if (timeLeft == t10) {
                s9.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s10.setLayoutParams(params);
                s10.setAlpha((float) 0.3);
                s10.setTextSize(20);
                s10.setTextColor(getResources().getColor(R.color.GrayColor));
                s11.setAlpha(1);
                s11.setTextSize(30);
                s11.setTextColor(getResources().getColor(R.color.GreenColor));
    //            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_vehicles_aircraft_call_bell_dual_tone_44562);
    //            mediaPlayer.start();
    //            Intent intent = new Intent(NewRecipe.this, CompleteCoffee.class);
    //            intent.putExtra("Flag", "" + flag);
    //            startActivity(intent);
    //            finish();
            } else if (timeLeft == t11) {
                s10.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.setMargins(0, px, 0, 0);
                s11.setLayoutParams(params);
                s11.setAlpha((float) 0.3);
                s11.setTextSize(20);
                s11.setTextColor(getResources().getColor(R.color.GrayColor));
                s12.setAlpha(1);
                s12.setTextSize(30);
                s12.setTextColor(getResources().getColor(R.color.GreenColor));
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zapsplat_vehicles_aircraft_call_bell_dual_tone_44562);
                mediaPlayer.start();
                Intent intent = new Intent(NewRecipe.this, CompleteCoffee.class);
                intent.putExtra("Flag", "" + flag);
                startActivity(intent);
                finish();
            }
        }
    }
    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timeLeft++;
//            ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", (int) timeLeft);
//            progressAnimator.setInterpolator(new DecelerateInterpolator());
//            progressAnimator.start();
            progressBar.setInterpolator(new DecelerateInterpolator());
            progressBar.setProgress((int) timeLeft);
            //Toast.makeText(NewRecipe.this,timeLeft+"S", Toast.LENGTH_SHORT).show();
            steps_changer();
        }
        @Override
        public void onFinish() {
            progressBar.setProgress((int)t11);
            Intent intent = new Intent(NewRecipe.this,CompleteCoffee.class);
            intent.putExtra("Flag",""+flag);
            startActivity(intent);
            finish();
            //timeLeft = 1;
            //time = 0;
            // Toast.makeText(NewRecipe.this, "Flag "+flag, Toast.LENGTH_SHORT).show();
        }
    }
}