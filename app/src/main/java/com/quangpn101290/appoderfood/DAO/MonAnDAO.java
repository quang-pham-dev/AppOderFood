package com.quangpn101290.appoderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.quangpn101290.appoderfood.DTO.MonAnDTO;
import com.quangpn101290.appoderfood.Database.CreateDatabase;

/**
 * Created by spaba on 6/15/2017.
 */

public class MonAnDAO {

  SQLiteDatabase database;

  public MonAnDAO(Context context) {
    CreateDatabase createDatabase = new CreateDatabase(context);
    database = createDatabase.open();

  }

  public boolean ThemMonAn(MonAnDTO monAnDTO) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(CreateDatabase.TB_MONAN_TENMONAN, monAnDTO.getTenMonAn());
    contentValues.put(CreateDatabase.TB_MONAN_GIATIEN, monAnDTO.getGiaTien());
    contentValues.put(CreateDatabase.TB_MONAN_MALOAI, monAnDTO.getMaLoai());
    contentValues.put(CreateDatabase.TB_MONAN_HINHANH, monAnDTO.getHinhAnh());

    long kiemtra = database.insert(CreateDatabase.TB_MONAN, null, contentValues);
    if (kiemtra != 0) {
      return true;
    } else {
      return false;
    }
  }
}
