package com.firstapp.asslen45;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.splashscreen.SplashScreen;

import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 1. Changed to 'button' to match your instructions/usage
    private Button button;
    private boolean keepSplash = true;

    public androidx.cardview.widget.CardView cgooglemap, cfacebook, cinstagram, ctiktok, cpinterest, cyoutube, cfacetime, cphone;
    public androidx.cardview.widget.CardView cshaleh, cdakme, caslen, candre, cjamol, cdarwin, ckryshiame, cjade;

    public RelativeLayout myDashboard;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Splash screen setup
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        //fullscreen
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_BLUR_BEHIND);



          //binding




        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Keep splash on screen for 5 seconds
        splashScreen.setKeepOnScreenCondition(() -> keepSplash);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            keepSplash = false;
        }, 5000);

        // Handle System Bars (Moved inside onCreate) according to gemini
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //  Button Initialization
        button = (Button) findViewById(R.id.buttonNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2Assh();  }
        });
//cards
        cgooglemap = findViewById(R.id.Cgooglemap);
        cfacebook = findViewById(R.id.cfacebook);
        cinstagram = findViewById(R.id.cinstagram);
        ctiktok= findViewById(R.id.ctiktok);
        cpinterest =findViewById(R.id.cpinterest);
        cyoutube = findViewById(R.id.cyoutube);
        cfacetime = findViewById(R.id.cfacetime);
        cphone = findViewById(R.id.cphone);
//profile
        cshaleh = findViewById(R.id.cshaleh);
        cdakme = findViewById(R.id.cdakme);
        caslen = findViewById(R.id.caslen);
        candre = findViewById(R.id.candre);
        cjamol = findViewById(R.id.cjamol);
        cdarwin = findViewById(R.id.cdarwin);
        ckryshiame = findViewById(R.id.ckryshiame);
        cjade = findViewById(R.id.cjade);


 //click listener
        cgooglemap.setOnClickListener(this);
        cfacebook.setOnClickListener(this);
        cinstagram.setOnClickListener(this);
        ctiktok.setOnClickListener(this);
        cpinterest.setOnClickListener(this);
        cyoutube.setOnClickListener(this);
        cfacetime.setOnClickListener(this);
        cphone.setOnClickListener(this);

        cshaleh.setOnClickListener(this);
        cdakme.setOnClickListener(this);
        caslen.setOnClickListener(this);
        candre.setOnClickListener(this);
        cjamol.setOnClickListener(this);
        cdarwin.setOnClickListener(this);
        ckryshiame.setOnClickListener(this);
        cjade.setOnClickListener(this);


//dashboard
        myDashboard = findViewById(R.id.Asshlene);
        myDashboard.setOnClickListener(this);







    }

    // button code
    public void openActivity2Assh() {
        Intent intent = new Intent(this, Activity2Assh.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.Cgooglemap) {
            Intent i = new Intent(this, GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.cfacebook) {
            Intent i = new Intent(this, Facebook.class);
            startActivity(i);
        } else if (id == R.id.cinstagram) {
            Intent i = new Intent(this, Instagram.class);
            startActivity(i);
        } else if (id == R.id.ctiktok) {
            Intent i = new Intent(this, Tiktok.class);
            startActivity(i);
        } else if (id == R.id.cpinterest) {
            Intent i = new Intent(this, Pinterest.class);
            startActivity(i);
        } else if (id == R.id.cyoutube) {
            Intent i = new Intent(this, Youtube.class);
            startActivity(i);
        } else if (id == R.id.cfacetime) {
            Intent i = new Intent(this, Facetime.class);
            startActivity(i);
        } else if (id == R.id.cphone) {
            Intent i = new Intent(this, Phone.class);
            startActivity(i);
        } else if (id == R.id.cshaleh) {
            Intent i = new Intent(this, Shaleh.class);
            startActivity(i);
        } else if (id == R.id.cdakme) {
            Intent i = new Intent(this, Dakme.class);
            startActivity(i);
        } else if (id == R.id.caslen) {
            Intent i = new Intent(this, Aslen.class);
            startActivity(i);
        } else if (id == R.id.candre) {
            Intent i = new Intent(this, Andre.class);
            startActivity(i);
        } else if (id == R.id.cjamol) {
            Intent i = new Intent(this, Jamol.class);
            startActivity(i);
        } else if (id == R.id.cdarwin) {
            Intent i = new Intent(this, Darwin.class);
            startActivity(i);
        } else if (id == R.id.ckryshiame) {
            Intent i = new Intent(this, Kryhsiame.class);
            startActivity(i);
        } else if (id == R.id.cjade) {
            Intent i = new Intent(this, Jade.class);
            startActivity(i);
        } else if (id == R.id.Asshlene) {
            Intent i = new Intent(this, Dashboard.class);
            startActivity(i);
    }
}}
