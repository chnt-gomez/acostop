package oom.pocket.acostop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener{

    Button urlAdivac, callAdivac, urlCora, callCora, urlInmujeres, callInmujeres,
    urlPgj, callPgj, urlSaptel, callSaptel, urlIle, urlUapvif, callUapvif;

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

        MobileAds.initialize(this, "ca-app-pub-2236350735048598/1813503450");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.url_adivac:
                openUrl("www.adivac.org");
                break;
            case R.id.url_cora:
                openUrl("www.cora.org.mx");
                break;
            case R.id.url_inmujeres:
                openUrl("www.inmujeres.df.gob.mx");
                break;
            case R.id.url_pgj:
                openUrl("www.pgjdf.gob.mx/index.php/servicios/atencionvictimas/adevi");
                break;
            case R.id.url_ile:
                openUrl("www.inmujeres.df.gob.mx/wb/inmujeres/interrupcion_legal_del_embarazo");
                break;
            case R.id.url_saptel:
                openUrl("http://www.saptel.org.mx/");
                break;
            case R.id.url_uapvif:
                openUrl("www.equidad.df.gob.mx/vfamiliar/red_uapvif.html");
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
        }
    }

    private void openUrl(String url) {
        Intent intent = new Intent(HelpActivity.this, BrowserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("URL", url);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void call(String phone){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phone));
        startActivity(dialIntent);
    }
}
