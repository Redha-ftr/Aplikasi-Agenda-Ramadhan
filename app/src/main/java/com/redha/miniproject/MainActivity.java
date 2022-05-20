package com.redha.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView ls;
    DBHandler handler;
    FloatingActionButton delete;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CatatanActivity.class);
                startActivity(intent);
            }
        });

        delete = (FloatingActionButton) findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Hapus catatan Ramadhan");
                builder1.setMessage("Apakah Anda yakin ingin menghapus agenda?");
                builder1.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        handler.hapusData();
                        setupListView();
                    }
                });
                builder1.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = builder1.create();
                dialog.show();
            }
        });

        handler = new DBHandler(this);
        ls = (ListView) findViewById(R.id.listAgenda);
        ls.setOnItemClickListener(this);
        setupListView();

    }

    private void setupListView() {
        Cursor cursor = handler.getAll();
        CustomCursorAdapter customAdapter = new CustomCursorAdapter(this, cursor, 1);
        ls.setAdapter(customAdapter);
        ls.setDividerHeight(0);
    }

     @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Keluar aplikasi?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView getId = (TextView) view.findViewById(R.id.no);
        final long id = Long.parseLong(getId.getText().toString());
        Cursor cur = handler.getData(id);
        cur.moveToFirst();

        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra(DBHandler.row_id, id);
        startActivity(intent);

    }

/*    public void dialogHapusItem(final long id) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("Hapus catatan Ramadhan " + id);
        builder1.setMessage("Apakah Anda yakin ingin menghapus agenda " + id + "?");
        builder1.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.hapusData(id);
                setupListView();
            }
        });
        builder1.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //batal
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();

    }*/

    protected void onResume() {
        super.onResume();
        setupListView();
    }
}