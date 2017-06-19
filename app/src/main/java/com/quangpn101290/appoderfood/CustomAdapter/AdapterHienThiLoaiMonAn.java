package com.quangpn101290.appoderfood.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quangpn101290.appoderfood.DTO.LoaiMonAnDTO;
import com.quangpn101290.appoderfood.R;
import java.util.List;

/**
 * Created by spaba on 6/13/2017.
 */

public class AdapterHienThiLoaiMonAn extends BaseAdapter {

  Context context;
  int layout;
  List<LoaiMonAnDTO> loaiMonAnDTOList;
  ViewHolDerLoaiMonAn viewHolDerLoaiMonAn;

  public AdapterHienThiLoaiMonAn(Context context, int layout,
      List<LoaiMonAnDTO> loaiMonAnDTOList) {
    this.context = context;
    this.layout = layout;
    this.loaiMonAnDTOList = loaiMonAnDTOList;
  }

  @Override
  public int getCount() {
    return loaiMonAnDTOList.size();
  }

  @Override
  public Object getItem(int position) {
    return loaiMonAnDTOList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return loaiMonAnDTOList.get(position).getMaLoai();
  }

 public class  ViewHolDerLoaiMonAn{
   TextView txtTenLoai;
 }

  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if ( view == null){
      viewHolDerLoaiMonAn = new ViewHolDerLoaiMonAn();

      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      view = inflater.inflate(R.layout.custom_layout_spinloaithucdon,parent,false);

      viewHolDerLoaiMonAn.txtTenLoai = (TextView) view.findViewById(R.id.txtTenLoai);

      view.setTag(viewHolDerLoaiMonAn);

    }else {
      viewHolDerLoaiMonAn = (ViewHolDerLoaiMonAn) view.getTag();
    }
    LoaiMonAnDTO loaiMonAnDTO = loaiMonAnDTOList.get(position);
    viewHolDerLoaiMonAn.txtTenLoai.setText(loaiMonAnDTO.getTenLoai());
    viewHolDerLoaiMonAn.txtTenLoai.setTag(loaiMonAnDTO.getMaLoai());
    return view;

  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if ( view == null){
       viewHolDerLoaiMonAn = new ViewHolDerLoaiMonAn();

      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      view = inflater.inflate(R.layout.custom_layout_spinloaithucdon,parent,false);

      viewHolDerLoaiMonAn.txtTenLoai = (TextView) view.findViewById(R.id.txtTenLoai);

      view.setTag(viewHolDerLoaiMonAn);

    }else {
      viewHolDerLoaiMonAn = (ViewHolDerLoaiMonAn) view.getTag();
    }
    LoaiMonAnDTO loaiMonAnDTO = loaiMonAnDTOList.get(position);
    viewHolDerLoaiMonAn.txtTenLoai.setText(loaiMonAnDTO.getTenLoai());
      viewHolDerLoaiMonAn.txtTenLoai.setTag(loaiMonAnDTO.getMaLoai());
    return view;
  }
}
