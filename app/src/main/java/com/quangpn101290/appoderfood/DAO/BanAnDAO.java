package com.quangpn101290.appoderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.quangpn101290.appoderfood.DTO.BanAnDTO;
import com.quangpn101290.appoderfood.Database.CreateDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spaba on 6/13/2017.
 */

public class BanAnDAO  {
  SQLiteDatabase database;
  public BanAnDAO(Context context) {
    CreateDatabase createDatabase = new CreateDatabase(context);
    database = createDatabase.open();

  }
  public boolean ThemBanAn(String tenban){
    ContentValues contentValues = new ContentValues();
    contentValues.put(CreateDatabase.TB_BANAN_TENBAN,tenban);
    contentValues.put(CreateDatabase.TB_BANAN_TINHTRANG,"false");

    long kiemtra = database.insert(CreateDatabase.TB_BANAN,null,contentValues);
    if(kiemtra != 0){
      return true;
    }else{
      return false;
    }
  }
  public List<BanAnDTO> LayTatCaBanAn(){
    List<BanAnDTO> banAnDTOList = new ArrayList<BanAnDTO>();
    String truyvan = "SELECT * FROM " + CreateDatabase.TB_BANAN;
    Cursor cursor = database.rawQuery(truyvan,null);
    cursor.moveToFirst();
    while(!cursor.isAfterLast()){
      BanAnDTO banAnDTO = new BanAnDTO();
      banAnDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_BANAN_MABAN)));
      banAnDTO.setTenBan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_BANAN_TENBAN)));

      banAnDTOList.add(banAnDTO);
      cursor.moveToNext();
    }
    return banAnDTOList;
  }

}
