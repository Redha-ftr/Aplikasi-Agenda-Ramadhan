package com.redha.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class EditActivity extends AppCompatActivity {
    DBHandler handler;
    EditText editctt, editss, editAyat1, editAyat2;
    CheckBox ckSubuh, ckZuhur, ckAshar, ckMagrib, ckIsya, ckss1, ckss2, ckss3, ckss4, ckInfaq, ckPuasa;
    Spinner spinSurat1, spinSurat2;
    Button btnSimpan;
    long id;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        handler = new DBHandler(this);
        id = getIntent().getLongExtra(DBHandler.row_id, 0);

        editctt = (EditText) findViewById(R.id.editctt);
        editss = (EditText) findViewById(R.id.editss);
        ckSubuh = (CheckBox) findViewById(R.id.ckSubuh);
        ckZuhur = (CheckBox) findViewById(R.id.ckZuhur);
        ckAshar = (CheckBox) findViewById(R.id.ckAshar);
        ckMagrib = (CheckBox) findViewById(R.id.ckMagrib);
        ckIsya = (CheckBox) findViewById(R.id.ckIsya);
        ckss1 = (CheckBox) findViewById(R.id.ckss1);
        ckss2 = (CheckBox) findViewById(R.id.ckss2);
        ckss3 = (CheckBox) findViewById(R.id.ckss3);
        ckss4 = (CheckBox) findViewById(R.id.ckss4);
        ckInfaq = (CheckBox) findViewById(R.id.ckInfaq);
        spinSurat1 = (Spinner) findViewById(R.id.spinSurat1);
        spinSurat2 = (Spinner) findViewById(R.id.spinSurat2);
        editAyat1 = (EditText) findViewById(R.id.editAyat1);
        editAyat2 = (EditText) findViewById(R.id.editAyat2);
        ckPuasa = (CheckBox) findViewById(R.id.ckPuasa);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        getData();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catatan = editctt.getText().toString().trim();
                String cttSunnah = editss.getText().toString().trim();
                String ayat1 = editAyat1.getText().toString().trim();
                String ayat2 = editAyat2.getText().toString().trim();
                String subuh = "";
                if(ckSubuh.isChecked()){
                    subuh = (ckSubuh.getText().toString());
                    progress +=  10;
                }
                String zuhur = "";
                if(ckZuhur.isChecked()){
                    zuhur =(ckZuhur.getText().toString());
                    progress +=  10;
                }
                String ashar = "";
                if(ckAshar.isChecked()){
                    ashar = (ckAshar.getText().toString());
                    progress +=  10;
                }
                String magrib = "";
                if(ckMagrib.isChecked()){
                    magrib = (ckMagrib.getText().toString());
                    progress +=  10;
                }
                String isya = "";
                if(ckIsya.isChecked()){
                    isya = (ckIsya.getText().toString());
                    progress +=  10;
                }
                String puasa = "";
                if(ckPuasa.isChecked()){
                    puasa = ckPuasa.getText().toString().trim();
                    progress +=  10;
                }
                String surat1 = spinSurat1.getSelectedItem().toString();
                String surat2 = spinSurat2.getSelectedItem().toString();
                if(surat1.equals("Pilih surat")==false||surat2.equals("Pilih surat")==false){
                    progress += 10;
                }

                String infaq = "";
                if(ckInfaq.isChecked()){
                    infaq = ckInfaq.getText().toString();
                    progress +=  10;
                }

                String sunnah1 = "";
                if(ckss1.isChecked()){
                    sunnah1 = ckss1.getText().toString();
                    progress +=  5;
                }
                String sunnah2 = "";
                if(ckss2.isChecked()){
                    sunnah2 = ckss2.getText().toString();
                    progress +=  5;
                }
                String sunnah3 = "";
                if(ckss3.isChecked()){
                    sunnah3 = ckss3.getText().toString();
                    progress +=  3;
                }
                String sunnah4 = "";
                if(ckss1.isChecked()){
                    sunnah4 = ckss4.getText().toString();
                    progress +=  3;
                }

                ContentValues values = new ContentValues();
                values.put(DBHandler.row_catatan, catatan);
                values.put(DBHandler.row_subuh, subuh);
                values.put(DBHandler.row_zuhur, zuhur);
                values.put(DBHandler.row_ashar, ashar);
                values.put(DBHandler.row_magrib, magrib);
                values.put(DBHandler.row_isya, isya);
                values.put(DBHandler.row_puasa, puasa);
                values.put(DBHandler.row_surat1, surat1);
                values.put(DBHandler.row_surat2, surat2);
                values.put(DBHandler.row_ayat1, ayat1);
                values.put(DBHandler.row_ayat2, ayat2);
                values.put(DBHandler.row_infaq, infaq);
                values.put(DBHandler.row_sunnah1, sunnah1);
                values.put(DBHandler.row_sunnah2, sunnah2);
                values.put(DBHandler.row_sunnah3, sunnah3);
                values.put(DBHandler.row_sunnah4, sunnah4);
                values.put(DBHandler.row_tambahan, cttSunnah);
                values.put(DBHandler.progress, progress);
                handler.editData(values,id);
                finish();
            }
        });

    }
    @SuppressLint("Range")
    public void getData(){
        Cursor cur = handler.getData(id);
        if(cur.moveToFirst()){
            String catatan = cur.getString((cur.getColumnIndex(DBHandler.row_catatan)));
            String surat1 = cur.getString(cur.getColumnIndex(DBHandler.row_surat1));
            String surat2 = cur.getString(cur.getColumnIndex(DBHandler.row_surat2));
            String ayat1 = cur.getString(cur.getColumnIndex(DBHandler.row_ayat1));
            String ayat2 = cur.getString(cur.getColumnIndex(DBHandler.row_ayat2));
            String tambahan = cur.getString(cur.getColumnIndex(DBHandler.row_tambahan));
            String infaq = cur.getString(cur.getColumnIndex(DBHandler.row_infaq));
            String puasa = cur.getString(cur.getColumnIndex(DBHandler.row_puasa));
            String subuh = cur.getString(cur.getColumnIndex(DBHandler.row_subuh));
            String zuhur = cur.getString(cur.getColumnIndex(DBHandler.row_zuhur));
            String ashar = cur.getString(cur.getColumnIndex(DBHandler.row_ashar));
            String magrib = cur.getString(cur.getColumnIndex(DBHandler.row_magrib));
            String isya = cur.getString(cur.getColumnIndex(DBHandler.row_isya));
            String sunnah1 = cur.getString(cur.getColumnIndex(DBHandler.row_sunnah1));
            String sunnah2 = cur.getString(cur.getColumnIndex(DBHandler.row_sunnah2));
            String sunnah3 = cur.getString(cur.getColumnIndex(DBHandler.row_sunnah3));
            String sunnah4 = cur.getString(cur.getColumnIndex(DBHandler.row_sunnah4));

            editctt.setText(catatan);
            editss.setText(tambahan);
            if(subuh.equals("Subuh")){
                ckSubuh.setChecked(true);
            }

            if(zuhur.equals("Zuhur")){
                ckZuhur.setChecked(true);
            }

            if(ashar.equals("Ashar")){
                ckAshar.setChecked(true);
            }

            if(magrib.equals("Magrib")){
                ckMagrib.setChecked(true);
            }
            if (isya.equals("Isya")){
                ckIsya.setChecked(true);
            }

            for(int i=0; i<spinSurat1.getCount(); i++){
                if(spinSurat1.getItemAtPosition(i).toString().equals(surat1)){
                    spinSurat1.setSelection(i);
                }
            }

            for(int i=0; i<spinSurat2.getCount(); i++){
                if(spinSurat2.getItemAtPosition(i).toString().equals(surat2)){
                    spinSurat2.setSelection(i);
                }
            }

            editAyat1.setText(ayat1);
            editAyat2.setText(ayat2);

            if(infaq.equals("Infaq")){
                ckInfaq.setChecked(true);
            }

            if(puasa.equals("Puasa Ramadhan")){
                ckPuasa.setChecked(true);
            }

            if(sunnah1.equals("Shalat Tarawih")){
                ckss1.setChecked(true);
            }

            if(sunnah2.equals("Shalat Witir")){
                ckss2.setChecked(true);
            }

            if(sunnah3.equals("Shalat Duha")){
                ckss3.setChecked(true);
            }

            if(sunnah4.equals("Shalat Tahajud")){
                ckss4.setChecked(true);
            }



        }
    }
}