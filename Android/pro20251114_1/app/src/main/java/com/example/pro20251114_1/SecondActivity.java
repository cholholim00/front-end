package com.example.pro20251114_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    Button btnFinish;
    Button btnIncrease, btnDecrease;
    RatingBar rBar1, rBar2, rBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnFinish = findViewById(R.id.btnFinish);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        rBar1 = findViewById(R.id.ratingBar1);
        rBar2 = findViewById(R.id.ratingBar2);
        rBar3 = findViewById(R.id.ratingBar3);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rBar1.setRating(rBar1.getRating()+1);
                rBar2.setRating(rBar2.getRating()+2);
                rBar3.setRating((float)(rBar3.getRating()+1.5));
            }
        });
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rBar1.setRating(rBar1.getRating()-1);
                rBar2.setRating(rBar2.getRating()-2);
                rBar3.setRating((float)(rBar3.getRating()-1.5));
            }
        });
    }

}