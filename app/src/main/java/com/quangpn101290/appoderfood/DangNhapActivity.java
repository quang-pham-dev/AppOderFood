package com.quangpn101290.appoderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.quangpn101290.appoderfood.DAO.NhanVienDAO;

/**
 * Created by spaba on 6/12/2017.
 */

public class DangNhapActivity extends AppCompatActivity implements OnClickListener {
  Button btnDongYDN,btnDangKyDN;
  EditText edTenDangNhapDN,edMatKhauDN;

  NhanVienDAO nhanVienDAO;
  @Override
  public void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_dangnhap);

    btnDangKyDN = (Button) findViewById(R.id.btnDangKyDN);
    btnDongYDN = (Button) findViewById(R.id.btnDongYDN);
    edMatKhauDN = (EditText) findViewById(R.id.edMatKhauDN);
    edTenDangNhapDN = (EditText) findViewById(R.id.edTenDangNhapDN);

    nhanVienDAO = new NhanVienDAO(this);
    btnDongYDN.setOnClickListener(this);
    btnDangKyDN.setOnClickListener(this);
    HienThiButtonDangKyVSDongY();
  }
  private void HienThiButtonDangKyVSDongY(){
    boolean kiemtra = nhanVienDAO.KiemTraNhanVien();
    if(kiemtra){
      btnDangKyDN.setVisibility(View.GONE);
      btnDongYDN.setVisibility(View.VISIBLE);
    }else{
      btnDangKyDN.setVisibility(View.VISIBLE);
      btnDongYDN.setVisibility(View.GONE);
    }
  }
private void btnDongY(){
  String stendangnhap = edTenDangNhapDN.getText().toString();
  String smatkhau = edMatKhauDN.getText().toString();
 boolean kiemtra = nhanVienDAO.KiemTraDangNhap(stendangnhap,smatkhau);
  if (kiemtra){
    Intent iTrangChu = new Intent(DangNhapActivity.this,TrangChuActivity.class);
    iTrangChu.putExtra("tendn",edTenDangNhapDN.getText().toString());
    startActivity(iTrangChu);
  }else {
    Toast.makeText(this, "Đăng Nhập thất bại", Toast.LENGTH_SHORT).show();
  }
}
private  void btnDangKy(){
  Intent iDangKy = new Intent(DangNhapActivity.this,DangKyActivity.class);
  startActivity(iDangKy);

}

  @Override
  protected void onResume() {
    super.onResume();
    HienThiButtonDangKyVSDongY();
  }

  @Override
  public void onClick(View v) {
      switch (v.getId()){
        case R.id.btnDongYDN:
          btnDongY();
          ;break;
        case R.id.btnDangKyDN:
          btnDangKy();
          ;break;
      }
  }
}
