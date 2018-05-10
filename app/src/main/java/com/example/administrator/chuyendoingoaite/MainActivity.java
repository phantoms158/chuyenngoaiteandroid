package com.example.administrator.chuyendoingoaite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txtVND;
    RadioButton radUSD,radEUR,radJPY;
    Button btnChuyenDoi;
    TextView txtNgoaiTe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();
    }

    private void AddEvents() {
        final DecimalFormat decimalFormat = new DecimalFormat("#.00");
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tienvnd = Double.parseDouble(txtVND.getText().toString());
                if (radUSD.isChecked()){
                    txtNgoaiTe.setText(String.valueOf(decimalFormat.format(tienvnd/20000)) + radUSD.getText());
                }
                if (radEUR.isChecked()){
                    txtNgoaiTe.setText(String.valueOf(decimalFormat.format(tienvnd/27000)) + radEUR.getText());
                }
                if (radJPY.isChecked()){
                    txtNgoaiTe.setText(String.valueOf(decimalFormat.format(tienvnd/208.02)) + radJPY.getText());
                }
            }
        });
    }

    private void AddControls() {
        txtVND = findViewById(R.id.edtVND);
        txtNgoaiTe = findViewById(R.id.txtNgoaiTe);
        radUSD = findViewById(R.id.radUSD);
        radEUR = findViewById(R.id.radEUR);
        radJPY = findViewById(R.id.radJPY);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);

    }
}
