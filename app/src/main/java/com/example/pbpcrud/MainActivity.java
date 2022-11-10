package com.example.pbpcrud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pbpcrud.adapter.ruanganAdapter;
import com.example.pbpcrud.database.AppDatabase;
import com.example.pbpcrud.database.entitas.ruangan;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnTambah;
    private AppDatabase database;
    private ruanganAdapter ruanganAdapter;
    private List<ruangan> list = new ArrayList<>();
    private AlertDialog.Builder dialog;
    private EditText kode_ruangan;
    private EditText kapasitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        btnTambah = findViewById(R.id.btn_tambah);

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.ruanganDao().getAll());
        ruanganAdapter = new ruanganAdapter(getApplicationContext(), list);
        ruanganAdapter.setDialog(new ruanganAdapter.Dialog() {
            @Override
            public void onClick(int position) {

                        final CharSequence[] dialogItem = {"Edit", "Hapus"};
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(MainActivity.this, tambah.class);
                                intent.putExtra("uid", list.get(position).uid);
                                startActivity(intent);
                                break;
                            case 1:
                                ruangan ruangan = list.get(position);
                                database.ruanganDao().delete(ruangan);
                                onStart();
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ruanganAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tambah.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.ruanganDao().getAll());
        ruanganAdapter.notifyDataSetChanged();
    }
}