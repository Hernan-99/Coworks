package com.example.coworks.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.coworks.CardAdapter;
import com.example.coworks.CardModel;
import com.example.coworks.data.database.appdatabase.CoworksDatabase;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CoworksDatabase coworksDatabase;
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

        coworksDatabase = CoworksDatabase.getInstance(this);

        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);


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
                int id = cardModelArrayList.get(position).getId();
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



        //config adapter
        cardAdapter = new CardAdapter(this, cardModelArrayList);

        //seteo adapter para viewpager2
        viewPager2.setAdapter(cardAdapter);

    }

}