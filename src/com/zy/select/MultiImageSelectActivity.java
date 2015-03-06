package com.zy.select;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import com.zy.select.util.MyFragmentAdapter;

public class MultiImageSelectActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    /**
     * Called when the activity is first created.
     */
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FrameLayout mContent = (FrameLayout) findViewById(R.id.content);
        RadioGroup mTabRadioGroup = (RadioGroup) findViewById(R.id.tab);
        mTabRadioGroup.setOnCheckedChangeListener(this);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), R.id.content);
        myFragmentAdapter.switchFragment(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.home:
                myFragmentAdapter.switchFragment(0);
                break;
            case R.id.setting:
                myFragmentAdapter.switchFragment(1);
                break;
        }
    }
}
