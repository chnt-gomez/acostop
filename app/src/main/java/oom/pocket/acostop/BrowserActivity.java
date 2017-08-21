package oom.pocket.acostop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        webView = (WebView)findViewById(R.id.web_view);
        String url = getIntent().getStringExtra("URL");
        if (url != null){
            webView.loadUrl(url);
        }
    }
}
