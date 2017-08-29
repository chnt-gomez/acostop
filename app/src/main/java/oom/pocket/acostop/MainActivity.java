package oom.pocket.acostop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import oom.pocket.acostop.views.TestCard;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button seekHelp;
    TestCard testViolenciaRelacion, infoAcoso, infoHostigamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        seekHelp = (Button)findViewById(R.id.btn_seek_help);
        seekHelp.setOnClickListener(this);
        testViolenciaRelacion = (TestCard)findViewById(R.id.tc_test_violencia_relacion);
        testViolenciaRelacion.setOnButtonClickListener(this);
        infoAcoso = (TestCard)findViewById(R.id.tc_acoso);
        infoAcoso.setOnButtonClickListener(this);
        infoHostigamiento = (TestCard)findViewById(R.id.tc_hostigamiento);
        infoHostigamiento.setOnButtonClickListener(this);
        MobileAds.initialize(this, "ca-app-pub-2236350735048598/6982247264");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_violencia_relacion:
                Intent intentTestViolencia = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intentTestViolencia);
                break;
            case R.id.btn_seek_help:
                Intent intentHelp = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intentHelp);
                break;
            case R.id.btn_info_acoso:
                Intent intentAcoso = new Intent(MainActivity.this, ActivityAcoso.class);
                startActivity(intentAcoso);
                break;
            case R.id.btn_info_hostigamiento:
                Intent intentHostigamiento = new Intent(MainActivity.this, ActivityHostigamiento.class);
                startActivity(intentHostigamiento);
                break;
        }
    }
}
