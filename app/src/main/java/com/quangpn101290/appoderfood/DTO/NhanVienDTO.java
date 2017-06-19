package com.quangpn101290.appoderfood.DTO;

/**
 * Created by spaba on 6/12/2017.
 */

public class NhanVienDTO  {
  int MANV,CMND;
  String TENDN,MATKHAU,GIOITINH,NGAYSINH;

  public int getMANV() {
    return MANV;
  }

  public void setMANV(int MANV) {
    this.MANV = MANV;
  }

  public int getCMND() {
    return CMND;
  }

  public void setCMND(int CMND) {
    this.CMND = CMND;
  }

  public String getTENDN() {
    return TENDN;
  }

  public void setTENDN(String TENDN) {
    this.TENDN = TENDN;
  }

  public String getMATKHAU() {
    return MATKHAU;
  }

  public void setMATKHAU(String MATKHAU) {
    this.MATKHAU = MATKHAU;
  }

  public String getGIOITINH() {
    return GIOITINH;
  }

  public void setGIOITINH(String GIOITINH) {
    this.GIOITINH = GIOITINH;
  }

  public String getNGAYSINH() {
    return NGAYSINH;
  }

  public void setNGAYSINH(String NGAYSINH) {
    this.NGAYSINH = NGAYSINH;
  }
}
