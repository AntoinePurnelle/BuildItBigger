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
package net.ouftech.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.ouftech.jokedisplayer.JokeDisplayerActivity;
import net.ouftech.ouftechcommons.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A placeholder fragment containing a simple view.
 */
public abstract class BaseMainActivityFragment extends BaseFragment implements EndpointsAsyncTask.EndpointsAsyncTaskListener {

    @BindView(R.id.instructions_text_view)
    TextView instructionsTextView;
    @BindView(R.id.tell_joke_button)
    Button tellJokeButton;
    Unbinder unbinder;
    @BindView(R.id.pb_loading_indicator)
    ProgressBar pbLoadingIndicator;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);

        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke(View view) {
        if (!isRunning())
            return;

        setLoading(true);
        new EndpointsAsyncTask(this).execute(getContext());
    }

    @Override
    public void onResult(String result) {
        if (getActivity() == null)
            return;

        setLoading(false);
        Intent intent = new Intent(getActivity(), JokeDisplayerActivity.class);
        intent.putExtra(JokeDisplayerActivity.JOKE_EXTRA, result);
        getActivity().startActivity(intent);
    }

    public void setLoading(boolean loading) {
        if (isRunning())
            getActivity().runOnUiThread(() -> {
                pbLoadingIndicator.setVisibility(loading ? View.VISIBLE : View.GONE);
                tellJokeButton.setEnabled(!loading);
            });
    }
}
