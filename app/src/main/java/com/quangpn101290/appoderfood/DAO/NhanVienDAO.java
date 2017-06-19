package com.quangpn101290.appoderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.quangpn101290.appoderfood.DTO.NhanVienDTO;
import com.quangpn101290.appoderfood.Database.CreateDatabase;

/**
 * Created by spaba on 6/12/2017.
 */

public class NhanVienDAO {
    SQLiteDatabase database;

  public  NhanVienDAO(Context context){
    CreateDatabase createDatabase = new CreateDatabase(context);
    database = createDatabase.open();

  }

  public  long ThemNhanVien(NhanVienDTO nhanVienDTO){
    ContentValues contentValues = new ContentValues();
    contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN,nhanVienDTO.getTENDN());
    contentValues.put(CreateDatabase.TB_NHANVIEN_CMND,nhanVienDTO.getCMND());
    contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH,nhanVienDTO.getGIOITINH());
    contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU,nhanVienDTO.getMATKHAU());
    contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH,nhanVienDTO.getNGAYSINH());

    long kiemtra = database.insert(CreateDatabase.TB_NHANVIEN,null,contentValues);
    return  kiemtra;
  }


  public boolean KiemTraNhanVien(){
    String truyvan = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN;
    Cursor cursor = database.rawQuery(truyvan, null);
    if(cursor.getCount() != 0){
      return true;
    }else{
      return false;
    }
  }

  public boolean KiemTraDangNhap(String tendangnhap, String matkhau){
    String truyvan = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN + " WHERE " + CreateDatabase.TB_NHANVIEN_TENDN + " = '" + tendangnhap
        + "' AND " + CreateDatabase.TB_NHANVIEN_MATKHAU + " = '" + matkhau + "'";
    Cursor cursor = database.rawQuery(truyvan,null);
    if (cursor.getCount() !=0){
      return true;
    }else {
      return false;
    }
  }

}
