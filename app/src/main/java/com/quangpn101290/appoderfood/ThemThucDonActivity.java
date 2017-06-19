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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.quangpn101290.appoderfood.CustomAdapter.AdapterHienThiLoaiMonAn;
import com.quangpn101290.appoderfood.DAO.LoaiMonAnDAO;
import com.quangpn101290.appoderfood.DAO.MonAnDAO;
import com.quangpn101290.appoderfood.DTO.LoaiMonAnDTO;
import com.quangpn101290.appoderfood.DTO.MonAnDTO;
import java.util.List;

/**
 * Created by spaba on 6/13/2017.
 */

public class ThemThucDonActivity extends AppCompatActivity implements OnClickListener {

  ImageButton imThemLoaiThucDon;
  Spinner spinLoaiThucDon;
  public static int REQUEST_CODE_THEMLOAITHUCDON = 112;
  public static int REQUEST_CODE_MOHINH = 122;
  LoaiMonAnDAO loaiMonAnDAO;
  List<LoaiMonAnDTO> loaiMonAnDTOs;
  AdapterHienThiLoaiMonAn adapterHienThiLoaiMonAn;
  ImageView imHinhThucDon;
  Button btnDongYThemMonAn, btnThoatThemMonAn;
  String sDuongDanHinh;
  EditText edTenMonAn, edGiaTien;
  MonAnDAO monAnDAO;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_themthucdon);

    loaiMonAnDAO = new LoaiMonAnDAO(this);
    monAnDAO = new MonAnDAO(this);
    imThemLoaiThucDon = (ImageButton) findViewById(R.id.imThemLoaiThucDon);
    spinLoaiThucDon = (Spinner) findViewById(R.id.spinLoaiMonAn);
    imHinhThucDon = (ImageView) findViewById(R.id.imHinhThucDon);
    btnDongYThemMonAn = (Button) findViewById(R.id.btnDongYThemMonAn);
    btnThoatThemMonAn = (Button) findViewById(R.id.btnThoatThemMonAn);
    edTenMonAn = (EditText) findViewById(R.id.edThemTenMonAn);
    edGiaTien = (EditText) findViewById(R.id.edThemGiaTien);

    HienThiSpinnerLoaiMonAn();
    imThemLoaiThucDon.setOnClickListener(this);
    imHinhThucDon.setOnClickListener(this);
    btnDongYThemMonAn.setOnClickListener(this);
    btnThoatThemMonAn.setOnClickListener(this);
  }

  private void HienThiSpinnerLoaiMonAn() {
    loaiMonAnDTOs = loaiMonAnDAO.LayDanhSachLoaiMonAn();
    adapterHienThiLoaiMonAn = new AdapterHienThiLoaiMonAn(this,
        R.layout.custom_layout_spinloaithucdon, loaiMonAnDTOs);
    spinLoaiThucDon.setAdapter(adapterHienThiLoaiMonAn);
    adapterHienThiLoaiMonAn.notifyDataSetChanged();


  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    switch (id) {
      case R.id.imThemLoaiThucDon:
        Intent iThemLoaiMonAn = new Intent(getApplicationContext(), ThemLoaiThucDonActivity.class);
        startActivityForResult(iThemLoaiMonAn, REQUEST_CODE_THEMLOAITHUCDON);
        break;
      case R.id.imHinhThucDon:
        Intent iMohinh = new Intent();
        iMohinh.setType("image/*");
        iMohinh.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(iMohinh, "Chọn hình thực đơn "),
            REQUEST_CODE_MOHINH);

        break;
      case R.id.btnDongYThemMonAn:
        int vitri = spinLoaiThucDon.getSelectedItemPosition();
        int maloai = loaiMonAnDTOs.get(vitri).getMaLoai();
        String tenmonan = edTenMonAn.getText().toString();
        String giatien = edGiaTien.getText().toString();
        if (tenmonan != null && giatien != null && !tenmonan.equals("") && !giatien.equals("")) {
          MonAnDTO monAnDTO = new MonAnDTO();
          monAnDTO.setMaLoai(maloai);
          monAnDTO.setGiaTien(giatien);
          monAnDTO.setHinhAnh(sDuongDanHinh);
          monAnDTO.setTenMonAn(tenmonan);
          boolean kiemtra =monAnDAO.ThemMonAn(monAnDTO);
          if (kiemtra){
            Toast.makeText(this, getResources().getString(R.string.themthanhcong), Toast.LENGTH_SHORT)
                .show();
          }else {
            Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT)
                .show();
          }
        } else {
          Toast.makeText(this, getResources().getString(R.string.loithemmonan), Toast.LENGTH_SHORT)
              .show();

        }
        break;
      case R.id.btnThoatThemMonAn:
        finish();
        break;
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_CODE_THEMLOAITHUCDON) {
      if (resultCode == Activity.RESULT_OK) {
        Intent dulieu = data;
        boolean kiemtra = dulieu.getBooleanExtra("kiemtraloaithucdon", false);
        if (kiemtra) {
          HienThiSpinnerLoaiMonAn();
          Toast.makeText(this, getResources().getString(R.string.themthanhcong), Toast.LENGTH_SHORT)
              .show();
        } else {
          Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT)
              .show();
        }
      }
    } else if (REQUEST_CODE_MOHINH == requestCode) {
      if (resultCode == Activity.RESULT_OK && data != null) {
//                try {
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
//                    imHinhThucDon.setImageBitmap(bitmap);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
        sDuongDanHinh = data.getData().toString();
        imHinhThucDon.setImageURI(data.getData());
      }
    }
  }
}
