package online.startprogramming.webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true); // open js in app

        webView.setWebViewClient(new WebViewClient()); // open in this app not in other mobile web browsers

//        webView.loadUrl("http://www.google.com");

        webView.loadData("<html><body><h1>Hello World!</h1><p>This is my cool website!</p></body></html>", "text/html","UTF-8");


    }
}