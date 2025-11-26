package com.example.pro20151114_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        int [] tvId = {
                R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9
        };
        int [] rbarId = {
                R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6,  R.id.rbar7, R.id.rbar8, R.id.rbar9
        };


        int [] voteResult;
        String [] imageName;
        Intent intent = getIntent();
        voteResult = intent.getIntArrayExtra("voteCount");
        imageName = intent.getStringArrayExtra("imgName");

        TextView [] tvPic = new TextView[tvId.length];
        RatingBar [] rbarPic = new RatingBar[rbarId.length];

        for (int i=0; i<tvPic.length; i++){
            tvPic[i] = findViewById(tvId[i]);
            rbarPic[i] = findViewById(rbarId[i]);
        }

        for (int i=0; i<tvPic.length; i++){
            tvPic[i].setText(imageName[i]);
            rbarPic[i].setRating((float)voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}