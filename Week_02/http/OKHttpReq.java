import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OKHttpReq {
    public String get(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        OKHttpReq okHttpReq = new OKHttpReq();
        String s = okHttpReq.get("http://localhost:8801");
        System.out.println(s);
    }
}
