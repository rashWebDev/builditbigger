package com.udacity.gradle.builditbigger.free;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.EndPointAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private InterstitialAd mIntestitialAd;
    private ProgressBar progressBar;
    String jokeSecond;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar=(ProgressBar)root.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adReq = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adReq);

        MobileAds.initialize(getContext(),getString(R.string.banner_id));

        AdRequest adRequest = new AdRequest.Builder().build();
        mIntestitialAd = new InterstitialAd(getContext());
        mIntestitialAd.setAdUnitId(getString(R.string.banner_id));

        AdRequest adRequests = new AdRequest.Builder()
                .addTestDevice("4A01AB2E4F2FF02EE470476281FA3C4E")
                .build();
        mIntestitialAd.loadAd(adRequests);

        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if(mIntestitialAd.isLoaded()){
                        mIntestitialAd.show();
                }
            }
        });

        mIntestitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                new EndPointAsyncTask(getContext()).execute();
                progressBar.setVisibility(View.GONE);
                requestNewInterstitial();
            }
        });
        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequests = new AdRequest.Builder()
                .addTestDevice("4A01AB2E4F2FF02EE470476281FA3C4E")
                .build();
        mIntestitialAd.loadAd(adRequests);
    }
}
