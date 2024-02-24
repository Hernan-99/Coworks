package com.example.coworks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.coworks.interfaces.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //actionbar
    private ActionBar actionBar;

    private ViewPager2 viewPager2;

    private ArrayList<CardModel> cardModelArrayList;
    private CardAdapter cardAdapter;

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);

/*
PASAR A UNA INTERFACE
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                pasar swit a if-else
                int itemId = item.getItemId();
                if(itemId == R.id.home){
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.add) {
                    Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.perfil) {
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Perfil", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });*/

        //NavigationBarView.OnItemSelectedListener()

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        //init action bar
        actionBar = getSupportActionBar();

        //init UI views
        viewPager2 = findViewById(R.id.viewPager);
        loadCards();

        //set viewpager
        viewPager2.unregisterOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //String title = cardModelArrayList.get(position).getTitulo();
                int id = cardModelArrayList.get(position).getId();
                //int img = cardModelArrayList.get(position).getImg();
                actionBar.setTitle(id);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    private void loadCards() {
        //init list
        cardModelArrayList = new ArrayList<>();

        //agraga items al arraylist

        cardModelArrayList.add(new CardModel(1, R.drawable.oficina1));
        cardModelArrayList.add(new CardModel(2, R.drawable.oficina2));
        cardModelArrayList.add(new CardModel(3, R.drawable.oficina3));


       /* cardModelArrayList.add(new CardModel(
                "Oficina 1",
                "Lorem ipsum",
                "$7000/dia",
                R.drawable.oficina1));

        cardModelArrayList.add(new CardModel(
                "Oficina 2",
                "Lorem ipsum",
                "$12000/dia",
                R.drawable.oficina2));

        cardModelArrayList.add(new CardModel(
                "Oficina 3",
                "Lorem ipsum",
                "$23000/dia",
                R.drawable.oficina3));*/




        //config adapter
        cardAdapter = new CardAdapter(this, cardModelArrayList);

        //seteo adapter para viewpager2
        viewPager2.setAdapter(cardAdapter);

        //viewPager2.setPadding(100, 0, 100, 0);

    }

}