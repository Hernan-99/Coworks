package com.example.coworks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationBarView;

public class RedireccionamientosNavbar implements NavigationBarView.OnItemSelectedListener{
    private Context context;

    public RedireccionamientosNavbar(Context context) {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.home){
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.add) {
            Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.perfil) {
            Intent intent = new Intent(context, PerfilActivity.class);
            context.startActivity(intent);
            Toast.makeText(context, "Perfil", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
