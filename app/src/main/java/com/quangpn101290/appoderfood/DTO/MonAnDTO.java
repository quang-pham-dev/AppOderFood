package com.quangpn101290.appoderfood.DTO;

/**
 * Created by spaba on 6/15/2017.
 */

public class MonAnDTO {
  int MaMonAn,MaLoai;
  String TenMonAn,GiaTien,HinhAnh;


  public int getMaMonAn() {
    return MaMonAn;
  }

  public String getHinhAnh() {
    return HinhAnh;
  }

  public void setHinhAnh(String hinhAnh) {
    HinhAnh = hinhAnh;
  }

  public void setMaMonAn(int maMonAn) {
    MaMonAn = maMonAn;
  }

  public int getMaLoai() {
    return MaLoai;
  }

  public void setMaLoai(int maLoai) {
    MaLoai = maLoai;
  }

  public String getTenMonAn() {
    return TenMonAn;
  }

  public void setTenMonAn(String tenMonAn) {
    TenMonAn = tenMonAn;
  }

  public String getGiaTien() {
    return GiaTien;
  }

  public void setGiaTien(String giaTien) {
    GiaTien = giaTien;
  }
}
