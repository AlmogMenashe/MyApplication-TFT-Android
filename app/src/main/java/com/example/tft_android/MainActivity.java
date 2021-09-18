package com.example.tft_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
    Animation upAnim, downAnim;
    ImageView imageLogo;
    TextView textLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        upAnim = AnimationUtils.loadAnimation(this,R.anim.up_animation);
        downAnim = AnimationUtils.loadAnimation(this,R.anim.down_animation);

        imageLogo = findViewById(R.id.imageLogo);
        textLogo = findViewById(R.id.createText);

        imageLogo.setAnimation(upAnim);
        textLogo.setAnimation(downAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        },SPLASH_SCREEN);
    }
}






