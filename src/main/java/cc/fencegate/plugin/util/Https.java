package cc.fencegate.plugin.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Https {

    private static final class TrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static HttpsURLConnection getConnection(String url, String method) {
        SSLContext sslContext;
        try {
            new URL("https://www.fencegate.cc").openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
