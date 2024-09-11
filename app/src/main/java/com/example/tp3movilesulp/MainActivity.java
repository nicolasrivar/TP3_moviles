package com.example.tp3movilesulp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private HashMap<Integer, Class<?>> fragmentMap;

    public static ArrayList<String> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.nav_listar, ListarNotasFragment.class);
        fragmentMap.put(R.id.nav_cargar, CargarNotasFragment.class);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class<?> fragmentClass = fragmentMap.get(item.getItemId());

                if (fragmentClass != null) {
                    try {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainer, (Fragment) fragmentClass.newInstance())
                                .commit();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (item.getItemId() == R.id.nav_salir) {
                    finish();
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new ListarNotasFragment())
                    .commit();
        }
    }
}
