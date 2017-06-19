package com.quangpn101290.appoderfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.quangpn101290.appoderfood.DAO.NhanVienDAO;
import com.quangpn101290.appoderfood.DTO.NhanVienDTO;
import com.quangpn101290.appoderfood.FragmentAPP.DatePickerFragment;

public class DangKyActivity extends AppCompatActivity implements OnClickListener,
    OnFocusChangeListener {

  EditText edTenDangNhapDk, edMatKhau, edNgaySinh, edCMND;
  Button btnDongY, btnThoat;
  RadioGroup rgGioiTinh;
  RadioButton rdNam,rdNu;

  String sGioiTinh;
  NhanVienDAO nhanVienDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_dangky);

    edTenDangNhapDk = (EditText) findViewById(R.id.edTenDangNhapDK);
    edMatKhau = (EditText) findViewById(R.id.edMatKhauDK);
    edNgaySinh = (EditText) findViewById(R.id.edNgaySinhDK);
    edCMND = (EditText) findViewById(R.id.edCMNDDK);
    btnDongY = (Button) findViewById(R.id.btnDongYDK);
    btnThoat = (Button) findViewById(R.id.btnThoatDK);

    rgGioiTinh = (RadioGroup) findViewById(R.id.rgGioiTinh);
    rdNam = (RadioButton) findViewById(R.id.rdNam);
    rdNu = (RadioButton) findViewById(R.id.rdNu);
    btnDongY.setOnClickListener(this);
    btnThoat.setOnClickListener(this);
    edNgaySinh.setOnFocusChangeListener(this);

    nhanVienDAO = new NhanVienDAO(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btnDongYDK:
        DongYThemNhanVien();
        break;
      case R.id.btnThoatDK:
        finish();
        break;
    }
  }

  private void DongYThemNhanVien() {
    String sTenDangNhap = edTenDangNhapDk.getText().toString();
    String sMatKhau = edMatKhau.getText().toString();

    String sNgaySinh = edNgaySinh.getText().toString();
    int sCMND = Integer.parseInt(edCMND.getText().toString());

    if (sTenDangNhap == null || sTenDangNhap.equals("")) {
      Toast.makeText(this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
    } else if (sMatKhau == null || sMatKhau.equals("")) {
      Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
    } else {
      NhanVienDTO nhanVienDTO = new NhanVienDTO();
      nhanVienDTO.setTENDN(sTenDangNhap);
      nhanVienDTO.setMATKHAU(sMatKhau);
      nhanVienDTO.setGIOITINH(sGioiTinh);
      nhanVienDTO.setNGAYSINH(sNgaySinh);
      nhanVienDTO.setCMND(sCMND);

      long kiemtra = nhanVienDAO.ThemNhanVien(nhanVienDTO);
      if (kiemtra != 0 ){
        Toast.makeText(this, "Thêm thành Công", Toast.LENGTH_SHORT).show();
      }else {
        Toast.makeText(this, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
      }

    }
    switch (rgGioiTinh.getCheckedRadioButtonId()) {
      case R.id.rdNam:
        sGioiTinh = "Nam";
        break;
      case R.id.rdNu:
        sGioiTinh = "Nữ";
        break;
    }


  }

  @Override
  public void onFocusChange(View v, boolean hasFocus) {
    int id = v.getId();
    switch (id) {
      case R.id.edNgaySinhDK:
        if (hasFocus) {
          // xuat popup ngay sinh
          DatePickerFragment datePickerFragment = new DatePickerFragment();
          datePickerFragment.show(getSupportFragmentManager(), "Ngày Sinh");
        }
        break;
    }
  }
}
