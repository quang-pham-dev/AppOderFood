package com.quangpn101290.appoderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.quangpn101290.appoderfood.DAO.BanAnDAO;

/**
 * Created by spaba on 6/13/2017.
 */

public class ThemBanAnActivity extends AppCompatActivity implements OnClickListener {
  EditText edTenThemBanAn;
  Button btnDongYThemBanAn;

  BanAnDAO banAnDAO;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_thembanan);
    edTenThemBanAn = (EditText) findViewById(R.id.edThemTenBanAn);
    btnDongYThemBanAn = (Button) findViewById(R.id.btnDongYThemBanAn);


    banAnDAO = new BanAnDAO(this);
    btnDongYThemBanAn.setOnClickListener(this);

  }

  @Override

  public void onClick(View v) {
    String sTenBanAn = edTenThemBanAn.getText().toString();
    if(sTenBanAn != null || sTenBanAn.equals("")){
      boolean kiemtra = banAnDAO.ThemBanAn(sTenBanAn);
      Intent intent = new Intent();
      intent.putExtra("ketquathem",kiemtra);
      setResult(Activity.RESULT_OK,intent);
      finish();
    }
  }
}