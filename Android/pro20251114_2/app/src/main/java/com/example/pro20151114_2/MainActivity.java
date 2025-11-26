package com.example.pro20151114_2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int [] voteCount = new int[9];
        ImageView []  image = new ImageView[9];
        int [] imageId = {
                R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,
                R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9,
        };

        String [] imgName = {
                "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀",
                "테라스의 두 소녀", "피아노 레슨", "피아노 옆의 소녀들", "해변에서"
        };

        for (int i=0; i<voteCount.length; i++){
            final int index = i;
            image[i] = findViewById(imageId[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index] += 1;
                    Toast.makeText(getApplicationContext(),imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imgName", imgName);
                startActivity(intent);
            }
        });


    }
}










