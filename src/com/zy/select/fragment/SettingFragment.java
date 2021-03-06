package com.zy.select.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/3/6.
 */
public class SettingFragment extends Fragment {
    private TextView mTextView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onCreateView");
        if (mTextView == null) {
            mTextView = new TextView(getActivity());
        }
        mTextView.setText(SettingFragment.class.getSimpleName());
        return mTextView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onDestroyView");
        ((ViewGroup)mTextView.getParent()).removeView(mTextView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onDestroy");


    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println(SettingFragment.class.getSimpleName() + "-------------------onDetach");

    }
}

