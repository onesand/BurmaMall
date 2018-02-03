package com.burmamall.burmamall.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.burmamall.burmamall.ECApplication;
import com.burmamall.burmamall.R;
import com.burmamall.burmamall.config.LauchConfig;
import com.burmamall.burmamall.utils.ConstanModel;
import com.burmamall.burmamall.utils.DBlog;

/**
 * Created by sand on 2018/1/27.
 */

public class MainFragment extends FragmentActivity implements View.OnClickListener{

    private LinearLayout homeTab,discoveryTab,messageTab,cartTab,MyTab;
    private ImageView homeIcon,discoveryIcon,messageIcon,cartIcon, myIcon;
    private TextView homeHint,discoveryHint,messageHint,cartHint,MyHint;
    private HomeFragment homeFragment;
    private DiscoveryFragment discoveryFragment;
    private MessageFragment messageFragment;
    private CartFragment cartFragment;
    private MyFragment myFragment;
    private int currentTabId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        if (null != null){
            currentTabId = savedInstanceState.getInt("currenttab");
            boolean flag = savedInstanceState.getBoolean("tab-1",false);
            if (flag){
                homeFragment = (HomeFragment) getSupportFragmentManager().getFragment(savedInstanceState,"tab-1");
            }
            flag = savedInstanceState.getBoolean("tab-2",false);
            if (flag){
                discoveryFragment = (DiscoveryFragment) getSupportFragmentManager().getFragment(savedInstanceState,"tab-2");
            }
            flag = savedInstanceState.getBoolean("tab-3",false);
            if (flag){
                messageFragment = (MessageFragment) getSupportFragmentManager().getFragment(savedInstanceState,"tab-3");
            }
            flag = savedInstanceState.getBoolean("tab-4",false);
            if (flag){
                cartFragment = (CartFragment) getSupportFragmentManager().getFragment(savedInstanceState,"tab-4");
            }
            flag = savedInstanceState.getBoolean("tab-5",false);
            if (flag){
                myFragment = (MyFragment) getSupportFragmentManager().getFragment(savedInstanceState,"tab-5");
            }
        }
        if (currentTabId == 0){
            switchTab(R.id.tab_home_ll);
        } else {
            switchTab(currentTabId);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("currenttab",currentTabId);
        if (homeFragment != null){
            getSupportFragmentManager().putFragment(outState,"tab1",homeFragment);
            outState.putBoolean("tab-1",true);
        }
        if (discoveryFragment != null){
            getSupportFragmentManager().putFragment(outState,"tab2",discoveryFragment);
            outState.putBoolean("tab-2",true);
        }
        if (messageFragment != null){
            getSupportFragmentManager().putFragment(outState,"tab3",messageFragment);
            outState.putBoolean("tab-3",true);
        }
        if (cartFragment != null){
            getSupportFragmentManager().putFragment(outState,"tab4",cartFragment);
            outState.putBoolean("tab-4",true);
        }
        if (myFragment != null){
            getSupportFragmentManager().putFragment(outState,"tab5",myFragment);
            outState.putBoolean("tab-5",true);
        }
    }

    private void initView() {
        homeIcon = (ImageView) findViewById(R.id.tab_home_icon);
        discoveryIcon = (ImageView) findViewById(R.id.tab_discovery_icon);
        messageIcon = (ImageView) findViewById(R.id.tab_message_icon);
        cartIcon = (ImageView) findViewById(R.id.tab_cart_icon);
        myIcon = (ImageView) findViewById(R.id.tab_my_icon);

        homeTab = (LinearLayout) findViewById(R.id.tab_home_ll);
        discoveryTab = (LinearLayout) findViewById(R.id.tab_discovery_ll);
        messageTab = (LinearLayout) findViewById(R.id.tab_message_ll);
        cartTab = (LinearLayout) findViewById(R.id.tab_cart_ll);
        MyTab = (LinearLayout) findViewById(R.id.tab_my_ll);
        homeTab.setOnClickListener(this);
        discoveryTab.setOnClickListener(this);
        messageTab.setOnClickListener(this);
        cartTab.setOnClickListener(this);
        MyTab.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int fromTag = intent.getIntExtra("from_tag",-1);
        if (fromTag == 3){
            switchTab( R.id.tab_message_ll);
        } else if (fromTag == 4){
            switchTab(R.id.tab_cart_ll);
        } else if (fromTag == 5){
            switchTab(R.id.tab_my_ll);
        } else {
            switchTab(R.id.tab_home_ll);
        }
    }

    private void switchTab(int id) {
        if (id == R.id.tab_message_ll ||id == R.id.tab_cart_ll || id == R.id.tab_my_ll){
            int fromTag = -1;
            if (id == R.id.tab_message_ll){
                fromTag = 3;
            } else if (id == R.id.tab_cart_ll){
                fromTag = 4;
            } else {
                fromTag = 5;
            }
            if (ECApplication.i().getLoginCode() == ConstanModel.Login.USER_UNLOGIN){
                LauchConfig.toLoginActivity(this,fromTag);
                return;
            }
        }

        if (id == R.id.tab_home_ll){
            homeIcon.setBackgroundResource(R.mipmap.main_home_press);
            discoveryIcon.setBackgroundResource(R.mipmap.main_find_normal);
            messageIcon.setBackgroundResource(R.mipmap.main_message_normal);
            cartIcon.setBackgroundResource(R.mipmap.main_cart_normal);
            myIcon.setBackgroundResource(R.mipmap.main_my_normal);
        } else if(id == R.id.tab_discovery_ll){
            homeIcon.setBackgroundResource(R.mipmap.main_home_normal);
            discoveryIcon.setBackgroundResource(R.mipmap.main_find_press);
            messageIcon.setBackgroundResource(R.mipmap.main_message_normal);
            cartIcon.setBackgroundResource(R.mipmap.main_cart_normal);
            myIcon.setBackgroundResource(R.mipmap.main_my_normal);
        } else if(id == R.id.tab_message_ll){
            homeIcon.setBackgroundResource(R.mipmap.main_home_normal);
            discoveryIcon.setBackgroundResource(R.mipmap.main_find_normal);
            messageIcon.setBackgroundResource(R.mipmap.main_message_press);
            cartIcon.setBackgroundResource(R.mipmap.main_cart_normal);
            myIcon.setBackgroundResource(R.mipmap.main_my_normal);
        } else if(id == R.id.tab_cart_ll){
            homeIcon.setBackgroundResource(R.mipmap.main_home_normal);
            discoveryIcon.setBackgroundResource(R.mipmap.main_find_normal);
            messageIcon.setBackgroundResource(R.mipmap.main_message_normal);
            cartIcon.setBackgroundResource(R.mipmap.main_cart_press);
            myIcon.setBackgroundResource(R.mipmap.main_my_normal);
        } else if(id == R.id.tab_my_ll){
            homeIcon.setBackgroundResource(R.mipmap.main_home_normal);
            discoveryIcon.setBackgroundResource(R.mipmap.main_find_normal);
            messageIcon.setBackgroundResource(R.mipmap.main_message_normal);
            cartIcon.setBackgroundResource(R.mipmap.main_cart_normal);
            myIcon.setBackgroundResource(R.mipmap.main_my_press);
        }
        switchFragment(id);
        currentTabId = id;
    }

    private void switchFragment(int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        if (id == R.id.tab_home_ll){
            if (homeFragment == null){
                homeFragment = new HomeFragment();
                transaction.add(R.id.main_frame_layout,homeFragment);
            }
            transaction.show(homeFragment);
        } else if (id == R.id.tab_discovery_ll){
            if (discoveryFragment == null){
                discoveryFragment = new DiscoveryFragment();
                transaction.add(R.id.main_frame_layout,discoveryFragment);
            }
            transaction.show(discoveryFragment);
        } else if (id == R.id.tab_message_ll){
            if (messageFragment == null){
                messageFragment = new MessageFragment();
                transaction.add(R.id.main_frame_layout,messageFragment);
            }
            transaction.show(messageFragment);
        } else if (id == R.id.tab_cart_ll){
            if (cartFragment == null){
                cartFragment = new CartFragment();
                transaction.add(R.id.main_frame_layout,cartFragment);
            }
            transaction.show(cartFragment);
        } else if (id == R.id.tab_my_ll){
            if (myFragment == null){
                myFragment = new MyFragment();
                transaction.add(R.id.main_frame_layout,myFragment);
            }
            transaction.show(myFragment);
        }
    transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null){
            transaction.hide(homeFragment);
        }
        if (discoveryFragment != null){
            transaction.hide(discoveryFragment);
        }
        if (messageFragment != null){
            transaction.hide(messageFragment);
        }
        if (cartFragment != null){
            transaction.hide(cartFragment);
        }
        if (myFragment != null){
            transaction.hide(myFragment);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id != currentTabId){
            switchTab(id);
        }
    }
}
