package oom.pocket.acostop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.share.widget.LikeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import oom.pocket.acostop.views.TestCard;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button seekHelp;
    TestCard testViolenciaRelacion, infoAcoso, infoHostigamiento, infoFacebook, qAcoso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initWidgets();
        initAds();
    }



    private void initWidgets(){
        seekHelp = (Button)findViewById(R.id.btn_seek_help);
        seekHelp.setOnClickListener(this);
        testViolenciaRelacion = (TestCard)findViewById(R.id.tc_test_violencia_relacion);
        testViolenciaRelacion.setOnButtonClickListener(this);
        infoAcoso = (TestCard)findViewById(R.id.tc_acoso);
        infoAcoso.setOnButtonClickListener(this);
        infoFacebook = (TestCard)findViewById(R.id.tc_facebook);
        infoFacebook.setOnButtonClickListener(this);
        infoHostigamiento = (TestCard)findViewById(R.id.tc_hostigamiento);
        infoHostigamiento.setOnButtonClickListener(this);
        qAcoso = (TestCard)findViewById(R.id.tc_denuncia_acoso);
        qAcoso.setOnButtonClickListener(this);

    }

    private void initAds(){
        MobileAds.initialize(this, "ca-app-pub-2236350735048598/6982247264");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("HASH", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("HASH", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("HASH", "printHashKey()", e);
        }
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
            case R.id.btn_info_hostigamiento:
                Intent intentHostigamiento = new Intent(MainActivity.this, ActivityHostigamiento.class);
                startActivity(intentHostigamiento);
                break;
            case R.id.btn_info_acoso:
                Intent intent = new Intent(MainActivity.this, ActivityAcoso.class);
                startActivity(intent);
                break;
            case R.id.btn_facebook:
                startActivity(openFacebookPage());
                break;
            case R.id.btn_acoso:
                startActivity(new Intent(MainActivity.this, ActivityProcedimientoAcoso.class));
                break;
        }
    }

    private Intent openFacebookPage() {
        try {
            getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/185763928631195"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/acostop"));
        }
    }
}
