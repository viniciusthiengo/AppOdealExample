package br.com.thiengo.appodealexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.ads.VideoCallbacks;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String appKey = "SUA API KEY DO APPODEAL";
        Appodeal.initialize(this, appKey, Appodeal.ALL);
        Appodeal.setTesting(true);
        //Appodeal.show(this, Appodeal.INTERSTITIAL);


        Appodeal.show( this, Appodeal.BANNER_BOTTOM );
    }


    @Override
    protected void onResume() {
        super.onResume();

        Appodeal.onResume(this, Appodeal.BANNER);
    }


    private boolean gettingOut = false;
    @Override
    public void onBackPressed() {

        if( gettingOut ){
            super.onBackPressed();
            finish();
        }
        else{
            gettingOut = true;
            Appodeal.show(this, Appodeal.INTERSTITIAL);
            //Appodeal.show(this, Appodeal.VIDEO);


            Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
                @Override
                public void onInterstitialLoaded(boolean b) {

                }

                @Override
                public void onInterstitialFailedToLoad() {

                }

                @Override
                public void onInterstitialShown() {

                }

                @Override
                public void onInterstitialClicked() {

                }

                @Override
                public void onInterstitialClosed() {
                    onBackPressed();
                }
            });

            /*Appodeal.setVideoCallbacks(new VideoCallbacks() {
                @Override
                public void onVideoLoaded() {

                }

                @Override
                public void onVideoFailedToLoad() {

                }

                @Override
                public void onVideoShown() {

                }

                @Override
                public void onVideoFinished() {

                }

                @Override
                public void onVideoClosed() {
                    onBackPressed();
                }
            });*/
        }

    }
}
