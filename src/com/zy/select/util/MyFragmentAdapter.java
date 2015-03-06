package com.zy.select.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.zy.select.fragment.HomeFragment;
import com.zy.select.fragment.SettingFragment;

/**
 * Created by Administrator on 2015/3/6.
 */
public class MyFragmentAdapter extends FragmentSwitch {

    public MyFragmentAdapter(FragmentManager mFragmentManager, int mContainerId) {
        super(mFragmentManager, mContainerId);
    }

    @Override
    protected Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new SettingFragment();
                break;
        }
        return fragment;
    }
}
