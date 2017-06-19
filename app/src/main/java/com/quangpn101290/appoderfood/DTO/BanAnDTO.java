package com.quangpn101290.appoderfood.DTO;

/**
 * Created by spaba on 6/13/2017.
 */

public class BanAnDTO {
  int MaBan;
  String TenBan;
  boolean DuocChon;

  public int getMaBan() {
    return MaBan;
  }

  public boolean isDuocChon() {
    return DuocChon;
  }

  public void setDuocChon(boolean duocChon) {
    DuocChon = duocChon;
  }

  public void setMaBan(int maBan) {
    MaBan = maBan;
  }

  public String getTenBan() {
    return TenBan;
  }

  public void setTenBan(String tenBan) {
    TenBan = tenBan;
  }
}
