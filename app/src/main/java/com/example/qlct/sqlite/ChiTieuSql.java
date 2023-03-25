package com.example.qlct.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qlct.model.ChiTieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChiTieuSql extends SQLiteOpenHelper {
    private Context context;
    public static final String TableName = "ChiTieu";
    //tên các cột trong bảng
    public static final String MaChiTieu = "MaChiTieu";
    public static final String SoTien = "SoTien";
    public static final String MaVi = "MaVi";
    public static final String MaLoaiCT = "MaLoaiCT";
    public static final String ThoiGianCT = "ThoiGianCT";
    public static final String GhiChu = "GhiChu";
    public static final String IsDeleted = "IsDeleted";

    public ChiTieuSql(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo câu sql để tạo bảng TableContact
        String sqlCreate = "Create table if not exists " + TableName + " ( "
                + MaChiTieu + " Integer Primary key AUTOINCREMENT, "
                + SoTien + " REAL, "
                +MaVi+" Integer, "
                +MaLoaiCT+" Integer, "
                +ThoiGianCT+" Text, "
                +GhiChu+" Text, "
                + IsDeleted + " Integer ) ";

        //chạy câu truy vấn SQL để tạo bảng
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//xóa bảng TableContact đã có
        db.execSQL("Drop table if exists " + TableName);
        //tạo lại
        onCreate(db);
    }
    public void addChiTieu(ChiTieu chiTieu)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MaChiTieu, chiTieu.getMaChiTieu());
        value.put(SoTien, chiTieu.getSoTien());
        value.put(MaVi, chiTieu.getMaVi());
        value.put(MaLoaiCT, chiTieu.getMaLoaiCT());
        value.put(ThoiGianCT, chiTieu.getTgCT().toString());
        value.put(GhiChu, chiTieu.getGhiChu());
        value.put(IsDeleted, 1);
        long a=db.insert(TableName,null, value);
        db.close();
    }
    public void updateChiTieu( ChiTieu chiTieu )
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(SoTien, chiTieu.getSoTien());
        value.put(MaVi, chiTieu.getMaVi());
        value.put(MaLoaiCT, chiTieu.getMaLoaiCT());
        value.put(ThoiGianCT, chiTieu.getTgCT().toString());
        value.put(GhiChu, chiTieu.getGhiChu());
        db.update(TableName, value,MaChiTieu + " =? ",
                new String[]{String.valueOf(chiTieu.getMaChiTieu())});
        db.close();
    }

    public void deleteChiTieu(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(IsDeleted, 0);
        db.update(TableName, value,MaChiTieu + " =? ",
                new String[]{String.valueOf(id)});
        db.close();
    }
    //lấy tất cả các dòng của bảng TableContact trả về dạng ArrayList
    public ArrayList<ChiTieu> getAllChiTieu(int id) throws ParseException {
        ArrayList<ChiTieu> list = new ArrayList<>();
        //câu truy vấn
        String sql = "Select * from " + TableName +" where Isdeleted=1 and MaVi="+id+" order by MaChiTieu";
        //lấy đối tượng csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chạy câu truy vấn trả về dạng Cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tạo ArrayList<Contact> để trả về;
        if(cursor!=null)
            while (cursor.moveToNext())
            {
                ChiTieu chiTieu = new ChiTieu(cursor.getInt(0),
                        cursor.getDouble(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(4)),
                        cursor.getString(5)
                );
                list.add(chiTieu);
            }
        return list;
    }
    public ArrayList<ChiTieu> getTop5(int id) throws ParseException {
        ArrayList<ChiTieu> list = new ArrayList<>();
        //câu truy vấn
        String sql = "Select * from " + TableName +" where Isdeleted=1 and MaVi="+id+" order by MaChiTieu";
        //lấy đối tượng csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chạy câu truy vấn trả về dạng Cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tạo ArrayList<Contact> để trả về;
        int i=0;
        if(cursor!=null)
            while (cursor.moveToNext() && i<=5)
            {
                i++;
                ChiTieu chiTieu = new ChiTieu(cursor.getInt(0),
                        cursor.getDouble(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(4)),
                        cursor.getString(5)
                );
                list.add(chiTieu);
            }
        return list;
    }

    public ArrayList<ChiTieu> getMonthChiTieu(int id, int Month) throws ParseException {
        ArrayList<ChiTieu> list = new ArrayList<>();
        //câu truy vấn
        String sql = "Select * from " + TableName +" where Isdeleted=1 and MaChiTieu="+id +" and ThoiGianCT like %/"+Month+"/% order by MaChiTieu";
        //lấy đối tượng csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chạy câu truy vấn trả về dạng Cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tạo ArrayList<Contact> để trả về;
        if(cursor!=null)
            while (cursor.moveToNext())
            {
                ChiTieu chiTieu = new ChiTieu(cursor.getInt(0),
                        cursor.getDouble(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(4)),
                        cursor.getString(5)
                );
                list.add(chiTieu);
            }
        return list;
    }
}
