package com.firstapp.asslen45;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ImageView; // for menu

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.GravityCompat; //sidebar
import androidx.drawerlayout.widget.DrawerLayout; // for sidebar
import com.google.android.material.navigation.NavigationView;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment; // Added this import to fix crash
import androidx.navigation.ui.NavigationUI;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 1. Changed to 'button' to match your instructions/usage
    private Button button;
    private boolean keepSplash = true;

    public androidx.cardview.widget.CardView cgooglemap, cfacebook, cinstagram, ctiktok, cpinterest, cyoutube, cfacetime, cphone;
    public androidx.cardview.widget.CardView cshaleh, cdakme, caslen, candre, cjamol, cdarwin, ckryshiame, cjade;

    public RelativeLayout myDashboard;


    // Sidebar variables
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Splash screen setup
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);


        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        // Sidebar Setup
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        ImageView imageMenu = findViewById(R.id.imageMenu);

        // Opening Drawer
        imageMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Setup Navigation Controller - Fixed to prevent IllegalStateException crash
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_main);
        
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(navigationView, navController);

            navigationView.setNavigationItemSelectedListener(item -> {
                int id = item.getItemId();
                View fragmentContainer = findViewById(R.id.fragment_container_main);
                
                if (id == R.id.nav_home) {
                    // Hide fragments to show dashboard
                    fragmentContainer.setVisibility(View.GONE);
                } else {
                    // Show fragment container for other items
                    fragmentContainer.setVisibility(View.VISIBLE);
                    NavigationUI.onNavDestinationSelected(item, navController);
                }
                
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            });


        }





        //splashscreen
        splashScreen.setKeepOnScreenCondition(() -> keepSplash);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            keepSplash = false;
        }, 5000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//button
        button = findViewById(R.id.buttonNext);
        button.setOnClickListener(v -> openActivity2Assh());

        initCards();
    }




    private void initCards() {
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

    public void openActivity2Assh() {
        Intent intent = new Intent(this, Activity2Assh.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Cgooglemap) startActivity(new Intent(this, GoogleMap.class));
        else if (id == R.id.cfacebook) startActivity(new Intent(this, Facebook.class));
        else if (id == R.id.cinstagram) startActivity(new Intent(this, Instagram.class));
        else if (id == R.id.ctiktok) startActivity(new Intent(this, Tiktok.class));
        else if (id == R.id.cpinterest) startActivity(new Intent(this, Pinterest.class));
        else if (id == R.id.cyoutube) startActivity(new Intent(this, Youtube.class));
        else if (id == R.id.cfacetime) startActivity(new Intent(this, Facetime.class));
        else if (id == R.id.cphone) startActivity(new Intent(this, Phone.class));
        else if (id == R.id.cshaleh) startActivity(new Intent(this, Shaleh.class));
        else if (id == R.id.cdakme) startActivity(new Intent(this, Dakme.class));
        else if (id == R.id.caslen) startActivity(new Intent(this, Aslen.class));
        else if (id == R.id.candre) startActivity(new Intent(this, Andre.class));
        else if (id == R.id.cjamol) startActivity(new Intent(this, Jamol.class));
        else if (id == R.id.cdarwin) startActivity(new Intent(this, Darwin.class));
        else if (id == R.id.ckryshiame) startActivity(new Intent(this, Kryhsiame.class));
        else if (id == R.id.cjade) startActivity(new Intent(this, Jade.class));
        else if (id == R.id.Asshlene) startActivity(new Intent(this, Dashboard.class));
    }
}