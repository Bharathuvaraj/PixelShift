package com.pixelshift.shift.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pixelshift.shift.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Initialize FirebaseApp
        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navHome) {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.navTemplate) {
                    loadFragment(new TemplatesFragment(), false);

                } else if (itemId == R.id.navEdit) {
                    //loadFragment(new EditFragment(), false);
                    loadAppCompatActivity(EditActivity.class);

                } else if (itemId == R.id.navProjects) {
                    loadFragment(new ProjectsFragment(), false);

                } else if (itemId == R.id.navProfile) {
                    // Check if user is logged in
                    if (isUserLoggedIn()) {
                        //loadFragment(new ProfileFragment(), false);
                        loadAppCompatActivity(ProfileActivity.class);
                    } else {
                        // User is not logged in, redirect to LoginActivity
                        loadAppCompatActivity(LoginActivity.class);
                    }
                }

                return true;
            }
        });

        // Load HomeFragment by default
        loadFragment(new HomeFragment(), true);
    }

    // Method to check if user is logged in using Firebase Authentication
    private boolean isUserLoggedIn() {
        FirebaseUser user = mAuth.getCurrentUser();
        return user != null;
    }

    // Method to load a fragment into the frame layout
    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        if (isAppInitialized) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameLayout, fragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .addToBackStack(null) // Add to back stack for fragment navigation
                    .commit();
        }
    }

    // Method to load an AppCompatActivity
    private void loadAppCompatActivity(Class<? extends AppCompatActivity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
