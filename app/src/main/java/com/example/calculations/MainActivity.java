package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //BMI
    EditText et_height;
    EditText et_weight;
    TextView bmi;
    Button btn_calculate;
    Button oztokg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BMI
        et_height=findViewById(R.id.et_height);
        et_weight=findViewById(R.id.et_weight);
        btn_calculate=findViewById(R.id.btn_calculate);
        bmi=findViewById(R.id.bmi);
        oztokg=findViewById(R.id.oztokg);

        oztokg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter();
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                double height = Double.parseDouble(et_height.getText().toString());
                double weight = Double.parseDouble(et_weight.getText().toString());

                double sum = (weight * 703)/(height * height);;

                bmi.setText(Double.toString(sum));
            }
        });

    }

    private void openConverter() {
        Intent intent = new Intent(MainActivity.this, ConvertOzToKg.class);
        startActivity(intent);
    }

}