/*
 * Copyright 2018 Antoine PURNELLE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
