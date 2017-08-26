package oom.pocket.acostop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button iniciarTest, seekHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        iniciarTest = (Button)findViewById(R.id.btn_start_test_relationship_violence);
        iniciarTest.setOnClickListener(this);
        seekHelp = (Button)findViewById(R.id.btn_seek_help);
        seekHelp.setOnClickListener(this);
        MobileAds.initialize(this, "ca-app-pub-2236350735048598/6982247264");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_test_relationship_violence:
                Intent intentTest = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intentTest);
                break;
            case R.id.btn_seek_help:
                Intent intentHelp = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intentHelp);
                break;
        }
    }
}
