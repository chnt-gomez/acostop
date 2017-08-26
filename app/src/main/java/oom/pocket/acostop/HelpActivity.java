package oom.pocket.acostop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener{

    Button urlAdivac, callAdivac, urlCora, callCora, urlInmujeres, callInmujeres,
    urlPgj, callPgj, urlSaptel, callSaptel, urlIle, urlUapvif, callUapvif, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        urlAdivac = (Button)findViewById(R.id.url_adivac);
        callAdivac = (Button)findViewById(R.id.call_adivac);
        urlCora = (Button)findViewById(R.id.url_cora);
        callCora = (Button)findViewById(R.id.call_cora);
        urlInmujeres = (Button)findViewById(R.id.url_inmujeres);
        callInmujeres = (Button)findViewById(R.id.call_inmujeres);
        urlPgj = (Button)findViewById(R.id.url_pgj);
        callPgj = (Button)findViewById(R.id.call_pgj);
        urlSaptel = (Button)findViewById(R.id.url_saptel);
        callSaptel = (Button)findViewById(R.id.call_saptel);
        urlIle = (Button)findViewById(R.id.url_ile);
        urlUapvif = (Button)findViewById(R.id.url_uapvif);
        callUapvif = (Button)findViewById(R.id.call_uapvif);
        btnShare = (Button) findViewById(R.id.btn_share);

        urlAdivac.setOnClickListener(this);
        callAdivac.setOnClickListener(this);
        urlCora.setOnClickListener(this);
        callCora.setOnClickListener(this);
        urlInmujeres.setOnClickListener(this);
        callInmujeres.setOnClickListener(this);
        urlPgj.setOnClickListener(this);
        callPgj.setOnClickListener(this);
        urlSaptel.setOnClickListener(this);
        callSaptel.setOnClickListener(this);
        urlIle.setOnClickListener(this);
        urlUapvif.setOnClickListener(this);
        callUapvif.setOnClickListener(this);
        btnShare.setOnClickListener(this);

        MobileAds.initialize(this, "ca-app-pub-2236350735048598/1813503450");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.url_adivac:
                openUrl("http://www.adivac.org");
                break;
            case R.id.url_cora:
                openUrl("http://www.cora.org.mx");
                break;
            case R.id.url_inmujeres:
                openUrl("http://www.inmujeres.df.gob.mx");
                break;
            case R.id.url_pgj:
                openUrl("http://www.pgj.cdmx.gob.mx/");
                break;
            case R.id.url_ile:
                openUrl("http://data.inmujeres.cdmx.gob.mx/interrupcion-legal-del-embarazo/");
                break;
            case R.id.url_saptel:
                openUrl("http://www.saptel.org.mx/");
                break;
            case R.id.url_uapvif:
                openUrl("http://www.pgj.cdmx.gob.mx/cavi");
                break;
            case R.id.call_adivac:
                call("5556827969");
                break;
            case R.id.call_cora:
                call("5555598451");
                break;
            case R.id.call_inmujeres:
                call("5555122836");
                break;
            case R.id.call_pgj:
                call("5553455598");
                break;
            case R.id.call_saptel:
                call("5552598121");
                break;
            case R.id.call_uapvif:
                call("5555185210");
                break;
            case R.id.btn_share:
                share();
                break;
        }
    }

    private void openUrl(String url) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Navegador no compatible", Toast.LENGTH_SHORT).show();
        }
    }

    private void call(String phone){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phone));
        startActivity(dialIntent);
    }

    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Prevención de violencia en la relación: https://play.google.com/store/apps/details?id=oom.pocket.acostop");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
