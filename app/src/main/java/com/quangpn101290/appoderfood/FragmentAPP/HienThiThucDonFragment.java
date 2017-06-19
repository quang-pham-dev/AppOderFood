package com.quangpn101290.appoderfood.FragmentAPP;

import static com.quangpn101290.appoderfood.R.id.itThemThucDon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.quangpn101290.appoderfood.R;
import com.quangpn101290.appoderfood.ThemThucDonActivity;
import com.quangpn101290.appoderfood.TrangChuActivity;

/**
 * Created by spaba on 6/13/2017.
 */

public class HienThiThucDonFragment extends Fragment {
  public static int  REQUEST_CODE_THEM_THUCDON = 111;
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View  view = inflater.inflate(R.layout.layout_hienthithucdon,container,false);
    setHasOptionsMenu(true);
    ((TrangChuActivity)getActivity()).getSupportActionBar().setTitle(R.string.fragthucdon);


    return view;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    MenuItem itThemThucDon = menu.add(1, R.id.itThemThucDon, 1, R.string.themthucdon);
    itThemThucDon.setIcon(R.drawable.logodangnhap);
//    itThemThucDon.setTitle("THỰC ĐƠN");
    itThemThucDon.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case itThemThucDon:
        Intent iThemThucDon = new Intent(getActivity(), ThemThucDonActivity.class);
        startActivity(iThemThucDon);

        break;
    }
    return true;
  }

}

