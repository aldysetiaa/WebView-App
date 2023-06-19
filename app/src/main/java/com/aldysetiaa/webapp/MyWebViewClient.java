package com.aldysetiaa.webapp;

import android.content.Context;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("tel:")) {
            // Handle tel: URL scheme (panggilan telepon)
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        } else if (url.startsWith("https://wa.me/")) {
            // Handle WhatsApp URL scheme
            openWhatsApp(view.getContext(), url);
            return true;
        }

        // Load other URLs within the WebView
        view.loadUrl(url);
        return true;
    }

    private void openWhatsApp(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }
}