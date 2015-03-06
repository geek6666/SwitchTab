package com.zy.select.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Administrator on 2015/3/5.
 */
public abstract class FragmentSwitch {
    private FragmentManager mFragmentManager;
    private int mContainerId;
    private Fragment mCurrentFragment;

    public FragmentSwitch(FragmentManager mFragmentManager, int mContainerId) {
        this.mContainerId = mContainerId;
        this.mFragmentManager = mFragmentManager;
    }

    /**
     * 切换fragment
     *
     * @param position
     * @return
     */
    public Fragment switchFragment(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        String fragmentName = makeFragmentName(position);
        Fragment fragment = this.mFragmentManager.findFragmentByTag(fragmentName);
        if (mCurrentFragment != null && mCurrentFragment == fragment) {//当前的fragment是要切换的fragment，不需要再次切换
            return mCurrentFragment;
        }

        detachCurrentFragment(transaction);
        if (fragment != null) {
            transaction.attach(fragment).commit();
        } else {
            fragment = getItem(position);
            transaction.add(mContainerId, fragment, fragmentName).commit();
        }
        this.mCurrentFragment = fragment;
        return fragment;
    }

    /**
     * detach当前正在显示的fragment
     *
     * @param transaction
     */
    private void detachCurrentFragment(FragmentTransaction transaction) {
        if (mCurrentFragment != null) {
            transaction.detach(mCurrentFragment);
        }
    }

    /**
     * 获取position位置的fragment
     *
     * @param position
     * @return
     */
    protected abstract Fragment getItem(int position);

    /**
     * 生成position位置的fragment
     *
     * @param position
     * @return
     */
    public String makeFragmentName(int position) {
        return "android:switcher:" + mContainerId + ":" + position;
    }


}
