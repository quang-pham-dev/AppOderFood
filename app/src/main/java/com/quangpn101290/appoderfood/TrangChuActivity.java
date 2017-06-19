package com.quangpn101290.appoderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.quangpn101290.appoderfood.FragmentAPP.HienThiBanAnFragment;
import com.quangpn101290.appoderfood.FragmentAPP.HienThiThucDonFragment;

/**
 * Created by spaba on 6/13/2017.
 */

public class TrangChuActivity extends AppCompatActivity implements
    OnNavigationItemSelectedListener {

  DrawerLayout drawerLayout;
  NavigationView navigationView;
  Toolbar toolbar;
  TextView txtTenNhanVien_Navigation;
  FragmentManager fragmentManager;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_trangchu);
    drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    navigationView = (NavigationView) findViewById(R.id.navigationview_trangchu);
    toolbar = (Toolbar) findViewById(R.id.toolbar);

    View view = navigationView.inflateHeaderView(R.layout.layout_header_navigation_trangchu);
    txtTenNhanVien_Navigation = (TextView) view.findViewById(R.id.txtTenNhanVien_Navigation);

    setSupportActionBar(toolbar);
    getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
        R.string.mo, R.string.dong) {
      @Override
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
      }
    };
    drawerLayout.setDrawerListener(drawerToggle);
    drawerToggle.syncState();

    navigationView.setItemIconTintList(null);
    navigationView.setNavigationItemSelectedListener(this);

    Intent intent = getIntent();
    String tendn = intent.getStringExtra("tendn");
    Log.d("dulieu", tendn);
    txtTenNhanVien_Navigation.setText(tendn);
    fragmentManager = getSupportFragmentManager();
    FragmentTransaction tranHienThiBanAn = fragmentManager.beginTransaction();
    HienThiBanAnFragment hienThiBanAnFragment = new HienThiBanAnFragment();
    tranHienThiBanAn.replace(R.id.content,hienThiBanAnFragment);
    tranHienThiBanAn.commit();
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case R.id.itTrangChu:
        FragmentTransaction tranHienThiBanAn = fragmentManager.beginTransaction();
        HienThiBanAnFragment hienThiBanAnFragment = new HienThiBanAnFragment();
        tranHienThiBanAn.replace(R.id.content,hienThiBanAnFragment);
        tranHienThiBanAn.commit();
        item.setChecked(true);
        drawerLayout.closeDrawers();
        break;
      case R.id.itThucDon:
        FragmentTransaction tranHienThiThucDon = fragmentManager.beginTransaction();
        HienThiThucDonFragment hienThiThucDonFragment = new HienThiThucDonFragment();
        tranHienThiThucDon.replace(R.id.content,hienThiThucDonFragment);
        tranHienThiThucDon.commit();
        item.setChecked(true);
        drawerLayout.closeDrawers();
        break;

    }
    return false;
  }
}
