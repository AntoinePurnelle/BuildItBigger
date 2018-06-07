package net.ouftech.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import net.ouftech.builditbigger.commons.BaseFragment;
import net.ouftech.jokesprovider.JokesProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import icepick.State;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    @BindView(R.id.instructions_text_view)
    TextView instructionsTextView;
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.tell_joke_button)
    Button tellJokeButton;
    Unbinder unbinder;
    JokesProvider jokesProvider;
    @State
    int jokeNumber = 0;

    public MainActivityFragment() {
    }

    @NonNull
    @Override
    protected String getLogTag() {
        return "MainActivityFragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
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
        if (isRunning())
            Toast.makeText(getActivity(), getJoke(), Toast.LENGTH_LONG).show();
    }

    private String getJoke() {
        if (jokesProvider == null)
            jokesProvider = new JokesProvider();

        if (jokeNumber == 9)
            jokeNumber = 0;
        else
            jokeNumber++;

        return jokesProvider.getJoke(jokeNumber);
    }
}
