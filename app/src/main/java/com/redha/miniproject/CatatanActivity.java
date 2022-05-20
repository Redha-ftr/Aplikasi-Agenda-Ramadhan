package com.redha.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class CatatanActivity extends AppCompatActivity {
    DBHandler handler;
    EditText editctt, editss, editAyat1, editAyat2;
    CheckBox ckSubuh, ckZuhur, ckAshar, ckMagrib, ckIsya, ckss1, ckss2, ckss3, ckss4, ckInfaq, ckPuasa;
    Spinner spinSurat1, spinSurat2;
    Button btnSimpan;
    int progress = 0;

    /*String[] Surat = {"Al Fatihah", "Al Baqarah", "Ali Imran", "An Nisa", "Al Maidah", "Al Anam", "Al-Araf",
            "Al-Anfal", "At-Taubah", "Yunus", "Hud", "Yusuf", "Ar-Rad", "Ibrahim", "Al-Hijr", "An-Nahl", "Al-Isra",
            "Al-Kahf", "Maryam", "Ta Ha", "Al-Anbiya",  "Al-Hajj", "Al-Muminun", "An-Nur", "Al-Furqan",
            "Asy-Syuara", "An-Naml", "Al-Qasas", "Al-Ankabut", "Ar-Rum", "Luqman", "As-Sajdah", "Al-Ahzab",
            "Saba", "Fatir", "Ya Sin", "As-Saffat", "Sad", "Az-Zumar", "Ghafir", "Fussilat", "Asy-Syura", "Az-Zukhruf",
            "Ad-Dukhan", "Al-Jasiyah", "Al-Ahqaf", "Muhammad", "Al-Fath", "Al-Hujurat", "Qaf", "Az-Zariyat", "At-Tur",
            "An-Najm", "Al-Qamar", "Ar-Rahman", "Al-Waqiah", "Al-Hadid", "Al-Mujadilah", "Al-Hasyr", "Al-Mumtahanah",
            "As-Saff", "Al-Jumuah", "Al-Munafiqun", "At-Tagabun", "At-Talaq", "Al-Mulk", "Al-Qalam", "Al-Haqqah",
            "Al-Maarij", "Nuh", "Al-Jinn", "Al-Muzzammil", "Al-Muddassir", "Al-Qiyamah", "Al-Insan", "Al-Mursalat",
            "An-Naba", "An-Naziat", "Abasa", "At-Takwir", "Al-Infitar", "Al-Tatfif", "Al-Insyiqaq", "Al-Buruj",
            "At-Tariq", "Al-Ala", "Al-Gasyiyah", "Al-Fajr", "Al-Balad", "Asy-Syams", "Al-Lail", "Ad-Duha", "Al-Insyirah",
            "At-Tin", "Al-Alaq", "Al-Qadr", "Al-Bayyinah", "Az-Zalzalah", "Al-Adiyat", "Al-Qariah", "At-Takasur",
            "Al-Asr", "Al-Humazah", "Al-Fil", "Quraisy", "Al-Maun", "Al-Kausar", "Al-Kafirun", "An-Nasr", "Al-Lahab",
            "Al-Ikhlas", "Al-Falaq" , "An-Nas"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        handler = new DBHandler(this);
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

                /*ArrayAdapter AA = new ArrayAdapter(CatatanActivity.this,R.layout.spinner_layout,Surat);
                AA.setDropDownViewResource(R.layout.spinner_layout);
                spinSurat1.setAdapter(AA);
                spinSurat2.setAdapter(AA);*/
                String surat1 = spinSurat1.getSelectedItem().toString();
                String surat2 = spinSurat2.getSelectedItem().toString();

                if(surat1.equals("Pilih surat")==false||surat2.equals("Pilih surat")==false){
                    progress += 10;
                }

                String infaq = "";
                if(ckInfaq.isChecked()){
                    infaq = ckInfaq.getText().toString();
                    progress += 10;
                }

                String sunnah1 = "";
                if(ckss1.isChecked()){
                    sunnah1 = ckss1.getText().toString();
                    progress += 5;
                }
                String sunnah2 = "";
                if(ckss2.isChecked()){
                    sunnah2 = ckss2.getText().toString();
                    progress += 5;
                }
                String sunnah3 = "";
                if(ckss3.isChecked()){
                    sunnah3 = ckss3.getText().toString();
                    progress += 3;
                }
                String sunnah4 = "";
                if(ckss1.isChecked()){
                    sunnah4 = ckss4.getText().toString();
                    progress += 3;
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
                handler.addData(values);

                Intent intent = new Intent(CatatanActivity.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(CatatanActivity.this, "Data berhasil disimpan", Toast.LENGTH_LONG).show();
            }
        });
    }
}