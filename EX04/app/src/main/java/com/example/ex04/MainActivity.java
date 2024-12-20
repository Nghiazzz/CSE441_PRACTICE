package com.example.ex04;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText txtFar, txtCel;
    Button btnFar, btnCel, btnClear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFar = findViewById(R.id.txtFar);
        txtCel = findViewById(R.id.txtCel);
        btnFar = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear);

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String far = txtFar.getText().toString();
                double F = Double.parseDouble(far);
                txtCel.setText(dcf.format((F - 32) / 1.8));
            }
        });

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String cel = txtCel.getText().toString();
                double C = Double.parseDouble(cel);
                txtFar.setText(dcf.format(C * 1.8 + 32));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFar.setText("");
                txtCel.setText("");
            }
        });
    }
}