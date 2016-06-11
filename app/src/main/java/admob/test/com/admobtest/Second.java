package admob.test.com.admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Second extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-2125563025891565/9872581331");

        AdRequest.Builder builder = new AdRequest.Builder().addTestDevice("E37EADB0EE3B5B653961C2700E1C7A06");
        AdRequest adRequest = builder.build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                showFullScreenAd();
            }
        });
    }

    private void showFullScreenAd(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }


}
