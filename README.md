# WebView-App
In the WebViewClient there is the code below to display whatsapp from the webview android application with the url https://wa.me/

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
