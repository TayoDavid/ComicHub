package com.example.comichub;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.comichub.fragments.AboutFragment;
import com.example.comichub.fragments.CharacterFragment;
import com.example.comichub.fragments.ComicsFragment;
import com.example.comichub.fragments.CreatorFragment;
import com.example.comichub.fragments.CreditFragment;
import com.example.comichub.fragments.EventFragment;
import com.example.comichub.fragments.SeriesFragment;
import com.example.comichub.fragments.StoriesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigationView;
    private NavigationView drawerNavigationView;
    private DrawerLayout drawer;
    private NavController navController;

    public static int currentPosition;
    private static final String KEY_CURRENT_POSITION = "currentKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, 0);
            return;
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        drawerNavigationView = findViewById(R.id.drawer_navigation_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        setupNavigation();
    }

    private void setupNavigation() {
        drawerNavigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_creators,
                R.id.navigation_events,
                R.id.navigation_about,
                R.id.navigation_credit)
                .setOpenableLayout(drawer)
                .build();
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (menuItem.getItemId() == R.id.navigation_creators) {
            fragment = new CreatorFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_events) {
            fragment = new EventFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_about) {
            fragment = new AboutFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_credit) {
            fragment = new CreditFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_home) {
            fragment = new CharacterFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_comics) {
            fragment = new ComicsFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_stories) {
            fragment = new StoriesFragment();
        }
        if (menuItem.getItemId() == R.id.navigation_series) {
            fragment = new SeriesFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        assert fragment != null;
        fragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment, fragment, menuItem.toString())
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();

        return true;
    }

}


