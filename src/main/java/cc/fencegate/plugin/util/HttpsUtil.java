package cc.fencegate.plugin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsUtil {
    private static SSLSocketFactory ssf = null;

    private static final class FencegateTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private HttpsURLConnection getConnection(String url, String method, String data) {
        try {
            if (ssf == null) {
                TrustManager[] tm = {new FencegateTrustManager()};
                SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                sslContext.init(null, tm, new java.security.SecureRandom());
                ssf = sslContext.getSocketFactory();
            }
            URL u = new URL(url);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) u.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            httpUrlConn.setRequestMethod(method);

            if (method.equalsIgnoreCase("GET"))
                httpUrlConn.connect();

            if (data != null) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                outputStream.write(data.getBytes("UTF-8"));
                outputStream.close();
            }

            return httpUrlConn;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpsURLConnection getConnection(String url, String method) {
        return getConnection(url, method, null);
    }

    public JSONObject getJSON(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            HttpsURLConnection httpUrlConn = getConnection(requestUrl, requestMethod, outputStr);


            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
            jsonObject = JSON.parseObject(stringBuilder.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
