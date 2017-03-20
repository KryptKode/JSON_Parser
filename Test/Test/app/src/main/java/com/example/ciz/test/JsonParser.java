package com.example.ciz.test;

/**
 * Created by Ciz on 3/15/2017.
 */

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class JsonParser {

    /********
     * URLS
     *******/
    private static final String MAIN_URL = "https://api.github.com/search/users?q=+location:lagos+language:java?access_token=98a5dfe97884e02fccb55b2a904526b48a99ca38";

    public static final String TAG = "TAG";

    /**
     * Response
     */
    private static Response response;


    public static JSONObject getDataFromWeb() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (@NonNull IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }
}
