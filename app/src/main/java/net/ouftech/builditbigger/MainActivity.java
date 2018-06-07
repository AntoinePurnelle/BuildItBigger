package net.ouftech.builditbigger;

import android.support.annotation.NonNull;

import net.ouftech.ouftechcommons.BaseActivity;


public class MainActivity extends BaseActivity {

    @NonNull
    @Override
    protected String getLogTag() {
        return "MainActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
