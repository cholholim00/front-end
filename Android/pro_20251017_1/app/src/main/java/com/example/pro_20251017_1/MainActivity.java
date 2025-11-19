package com.example.pro_20251017_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView tvResult;

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

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt( edtNum1.getText().toString());
                int num2 = Integer.parseInt( edtNum2.getText().toString());
                tvResult.setText("계산결과 : " +  (num1 + num2 ));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt( edtNum1.getText().toString());
                int num2 = Integer.parseInt( edtNum2.getText().toString());
                tvResult.setText("계산결과 : " +  (num1 - num2 ));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt( edtNum1.getText().toString());
                int num2 = Integer.parseInt( edtNum2.getText().toString());
                tvResult.setText("계산결과 : " +  (num1 * num2 ));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt( edtNum1.getText().toString());
                int num2 = Integer.parseInt( edtNum2.getText().toString());
                tvResult.setText("계산결과 : " +  (num1 / num2 ));
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt( edtNum1.getText().toString());
                int num2 = Integer.parseInt( edtNum2.getText().toString());
                tvResult.setText("계산결과 : " +  (num1 % num2 ));
            }
        });
    }
}