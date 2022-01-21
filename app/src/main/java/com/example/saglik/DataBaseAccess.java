package com.example.saglik;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DataBaseAccess instance;
    Cursor c = null;

    private DataBaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
    }

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public String getVegan(String sorgu) {
        c = db.rawQuery("select veg from VeriSetii where sorgu='" + sorgu + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String vegan = c.getString(0);
            buffer.append(sorgu + ": " + vegan );
        }
        return buffer.toString();
    }

    public String getGluten(String sorgu) {
        c = db.rawQuery("select gluten from VeriSetii where sorgu='" + sorgu + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String gluten = c.getString(0);
            buffer.append(sorgu + ": " + gluten);
        }
        return buffer.toString();
    }

    public String getProtein(String sorgu) {
        c = db.rawQuery("select protein from VeriSetii where sorgu='" + sorgu + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String protein = c.getString(0);
            buffer.append(sorgu + ": Ürünün protein miktarı " + protein + "gr.");
        }
        return buffer.toString();
    }

    public String getKalori(String sorgu) {
        c = db.rawQuery("select kalori from VeriSetii where sorgu='" + sorgu + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String kalori = c.getString(0);
            buffer.append(sorgu + ": Ürünün kalori miktarı " + kalori + " kcal");
        }
        return buffer.toString();
    }
}