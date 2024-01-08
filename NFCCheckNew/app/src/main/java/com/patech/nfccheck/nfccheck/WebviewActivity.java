package com.patech.nfccheck.nfccheck;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.patech.utils.AppConstants;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WebviewActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.webView) WebView webView;

    private String url = AppConstants.EMPTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent calleeIntent = getIntent();
        url = calleeIntent.getStringExtra(AppConstants.WEBVIEW_URL);
        String title = calleeIntent.getStringExtra(AppConstants.TITLE);
        setTitle(title);
//
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        webView.getSettings().setAllowFileAccess(true);

        //
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_INSET);


        webView.setWebViewClient(new MyWebViewClient());
        //
        if (!url.isEmpty()) {
            webView.loadUrl(url);
        }

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        //show the web page in webview but not in web browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webview_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_openin_browser) {
            if (!url.isEmpty()) {
                Intent inbrowserOpenIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(inbrowserOpenIntent);
            } else {
                Toast.makeText(getApplicationContext(), "URL is empty", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
