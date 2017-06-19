package com.quangpn101290.appoderfood.FragmentAPP;

import android.app.Activity;
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
import android.widget.GridView;
import android.widget.Toast;
import com.quangpn101290.appoderfood.CustomAdapter.AdapterHienThiBanAn;
import com.quangpn101290.appoderfood.DAO.BanAnDAO;
import com.quangpn101290.appoderfood.DTO.BanAnDTO;
import com.quangpn101290.appoderfood.R;
import com.quangpn101290.appoderfood.ThemBanAnActivity;
import com.quangpn101290.appoderfood.TrangChuActivity;
import java.util.List;

/**
 * Created by spaba on 6/13/2017.
 */

public class HienThiBanAnFragment extends Fragment {

  public static int REQUEST_CODE_THEM = 111;
  GridView gvHienThiBanAn;
  List<BanAnDTO> banAnDTOList;
  BanAnDAO banAnDAO;
  AdapterHienThiBanAn adapterHienThiBanAn;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.layout_hienthibanan, container, false);
    setHasOptionsMenu(true);
    ((TrangChuActivity)getActivity()).getSupportActionBar().setTitle(R.string.banan);
    gvHienThiBanAn = (GridView) view.findViewById(R.id.gvHienBanAn);

    banAnDAO = new BanAnDAO(getActivity());
    banAnDTOList = banAnDAO.LayTatCaBanAn();

    HienThiDanhSachBanAn();
    return view;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    MenuItem itThemBanAn = menu.add(1, R.id.itThemBanAn, 1, R.string.thembanan);
    itThemBanAn.setIcon(R.drawable.thembanan);
    itThemBanAn.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case R.id.itThemBanAn:
        Intent iThemBanAn = new Intent(getActivity(), ThemBanAnActivity.class);
        startActivityForResult(iThemBanAn, REQUEST_CODE_THEM);

        break;
    }
    return true;
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE_THEM) {
      if (resultCode == Activity.RESULT_OK) {
        Intent intent = data;
        boolean kiemtra = intent.getBooleanExtra("ketquathem", false);
        if (kiemtra) {
          HienThiDanhSachBanAn();
          Toast.makeText(getActivity(), getResources().getString(R.string.themthanhcong),
              Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(getActivity(), getResources().getString(R.string.themthatbai),
              Toast.LENGTH_SHORT).show();
        }
      }
    }
  }

  private void HienThiDanhSachBanAn() {
    banAnDTOList = banAnDAO.LayTatCaBanAn();
    adapterHienThiBanAn = new AdapterHienThiBanAn(getActivity(),
        R.layout.custom_layout_hienthibanan, banAnDTOList);
    gvHienThiBanAn.setAdapter(adapterHienThiBanAn);
    adapterHienThiBanAn.notifyDataSetChanged();
  }
}
