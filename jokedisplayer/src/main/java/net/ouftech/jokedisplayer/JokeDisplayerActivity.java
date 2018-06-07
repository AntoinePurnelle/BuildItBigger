package net.ouftech.jokedisplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import net.ouftech.ouftechcommons.BaseActivity;

public class JokeDisplayerActivity extends BaseActivity {

    public static final String JOKE_EXTRA = "JOKE_EXTRA";

    @NonNull
    @Override
    protected String getLogTag() {
        return "JokeDisplayerActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_joke_displayer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView jokeTextview = findViewById(R.id.joke_textview);

        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        jokeTextview.setText(joke);
    }
}
