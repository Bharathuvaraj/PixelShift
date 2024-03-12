package com.pixelshift.shift;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

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
                    loadFragment(new EditFragment(), false);

                } else if (itemId == R.id.navProjects) {
                    loadFragment(new ProjectsFragment(), false);

                } else {
                    // nav profile
                    loadFragment(new ProfileFragment(), false);

                }

                return true;

            }
        });

        loadFragment(new HomeFragment(), true);

    }

    private void loadFragment(Fragment fragment,boolean isAppInitialized){

        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout,fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout,fragment);
        }


        fragmentTransaction.commit();

    }

}