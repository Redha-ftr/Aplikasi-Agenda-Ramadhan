package com.redha.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public static final String nama_db = "db_agenda";
    public static final String nama_tabel = "tabel_agenda";
    public static final String progress = "progress";

    public static final String row_id = "_id";
    public static final String row_catatan = "catatan";
    public static final String row_subuh = "subuh";
    public static final String row_zuhur = "zuhur";
    public static final String row_ashar = "ashar";
    public static final String row_magrib = "magrib";
    public static final String row_isya = "isya";
    public static final String row_puasa = "puasa";
    public static final String row_surat1 = "surat1";
    public static final String row_surat2 = "surat2";
    public static final String row_ayat1 = "ayat1";
    public static final String row_ayat2 = "ayat2";
    public static final String row_infaq = "infaq";
    public static final String row_sunnah1 = "sunnah1";
    public static final String row_sunnah2 = "sunnah2";
    public static final String row_sunnah3 = "sunnah3";
    public static final String row_sunnah4 = "sunnah4";
    public static final String row_tambahan = "tambahan";

    private SQLiteDatabase db;

    public DBHandler(@Nullable Context context) {
        super(context, nama_db, null, 2);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + nama_tabel + "(" + row_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + row_catatan + " TEXT, "+row_subuh+" TEXT, "+row_zuhur+" TEXT, "+row_ashar+" TEXT, "
                +row_magrib+" TEXT, "+row_isya+" TEXT, "+row_puasa+" TEXT, "
                +row_surat1+" TEXT, "+row_surat2+" TEXT, "+row_ayat1+" TEXT, "
                +row_ayat2+" TEXT, "+row_infaq+" TEXT, "+row_sunnah1+" TEXT, "+row_sunnah2+" TEXT, "
                +row_sunnah3+" TEXT, "+row_sunnah4+" TEXT, "
                +row_tambahan+ " TEXT, "+ progress +" TEXT )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+nama_tabel);
    }

    //mengambil semua data
    public Cursor getAll(){
        Cursor cur = db.rawQuery("SELECT * FROM "+nama_tabel, null);
        return cur;
    }

    //mengambil satu data
    public Cursor getData(long id){
        Cursor cur = db.rawQuery("SELECT * FROM "+nama_tabel+" WHERE "+row_id+" = "+id, null);
        return cur;
    }

    //menambah data
    public void addData(ContentValues values){
        db.insert(nama_tabel, null, values);
    }

    //update data
    public void editData(ContentValues values, long id){
        db.update(nama_tabel, values, row_id+"="+id, null);
    }

    //hapus data
    public void hapusData(){
        db.execSQL("DROP TABLE IF EXISTS "+nama_tabel);
        onCreate(db);
    }



}
