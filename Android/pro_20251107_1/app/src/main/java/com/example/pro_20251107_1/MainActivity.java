package com.example.pro_20251107_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainLayout;
    Button btnMenu, btnMenuContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayoyt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.mainLayoyt);
        btnMenu = findViewById(R.id.btnMenu);
        btnMenuContext = findViewById(R.id.btnMenuContext);
        registerForContextMenu(btnMenuContext);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu2, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemRed2){
            mainLayout.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == R.id.itemGreen2){
            mainLayout.setBackgroundColor(Color.GREEN);
        }else if(item.getItemId() == R.id.itemBlue2){
            mainLayout.setBackgroundColor(Color.BLUE);
            }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (item.getItemId() == R.id.itemRed){
           mainLayout.setBackgroundColor(Color.RED);
       }else if(item.getItemId() == R.id.itemGreen){
           mainLayout.setBackgroundColor(Color.GREEN);
       }else if(item.getItemId() == R.id.itemBlue){
           mainLayout.setBackgroundColor(Color.BLUE);
       }else if (item.getItemId() == R.id.subRotate){
           btnMenu.setRotation(45);
       }else if (item.getItemId() == R.id.subSize){
           btnMenu.setScaleX(2);
       }
        return super.onOptionsItemSelected(item);
    }
}
