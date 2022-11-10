package com.example.pbpcrud;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ruangan extends AppCompatActivity {
    private EditText edtkode_ruangan;
    private EditText edtkapasitas;
    private Button btn_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruangan);
    }
}