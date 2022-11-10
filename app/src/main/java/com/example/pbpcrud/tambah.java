package com.example.pbpcrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pbpcrud.database.AppDatabase;
import com.example.pbpcrud.database.entitas.ruangan;

public class tambah extends AppCompatActivity {
    private EditText editRuangan, editKapasitas;
    private Button btnSave;
    private AppDatabase database;
    private int uid = 0;
    private boolean isEdit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editRuangan = findViewById(R.id.kode_ruangan);
        editKapasitas = findViewById(R.id.kapasitas);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        if (uid>0){
            isEdit = true;
            ruangan ruangan  = database.ruanganDao().get(uid);
            editRuangan.setText(ruangan.kode_ruangan);
            editKapasitas.setText(ruangan.kapasitas);
        }else{
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdit){
                    database.ruanganDao().update(uid, editRuangan.getText().toString(), editKapasitas.getText().toString());
                }else{
                    database.ruanganDao().insertAll(editRuangan.getText().toString(), editKapasitas.getText().toString());
                }
                finish();
            }
        });
    }
}