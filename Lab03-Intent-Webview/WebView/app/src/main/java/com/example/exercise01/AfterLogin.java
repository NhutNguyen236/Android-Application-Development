package com.example.exercise01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class AfterLogin extends AppCompatActivity {

    private EditText urlEntry;
    private Button Go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        urlEntry = (EditText) findViewById(R.id.editText);
        Go = (Button) findViewById(R.id.button);

        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new MyBrowser());

        Go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = urlEntry.getText().toString();

                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
            }
        });
    }

    private class MyBrowser extends WebViewClient implements com.example.exercise01.MyBrowser {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}