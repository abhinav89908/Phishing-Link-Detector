//package com.example.safeclick;
//
//import okhttp3.*;
//
//import android.telecom.Call;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//
//public class VirusTotalAPI {
//
//    private static final String API_KEY = "5b2923603ce95e22c8ffa9977b3a2999a2170f9b3f2a958c11d731c2f7adb8ba";
//
//    public interface VirusTotalCallback {
//        void onResult(boolean isSafe);
//        void onError(String errorMessage);
//    }
//
//    public static void checkURL(String url, final VirusTotalCallback callback) {
//        String apiUrl = "https://www.virustotal.com/vtapi/v2/url/report";
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(apiUrl).newBuilder();
//        urlBuilder.addQueryParameter("apikey", API_KEY);
//        urlBuilder.addQueryParameter("resource", url);
//        urlBuilder.addQueryParameter("scan", "1");
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(urlBuilder.build().toString())
//                .build();
//
////        client.newCall(request).enqueue(new Callback() {
////
////            public void onFailure(Call call, IOException e) {
////                callback.onError(e.getMessage());
////            }
////
////            public void onResponse(Call call, Response response) throws IOException {
////                try (ResponseBody responseBody = response.body()) {
////                    if (!response.isSuccessful()) {
////                        callback.onError("Unexpected response code: " + response.code());
////                        return;
////                    }
////
////                    String json = responseBody.string();
////                    // Parse the JSON response and check if the link is safe or not
////                    boolean isSafe = parseVirusTotalResponse(json);
////                    callback.onResult(isSafe);
////                }
////            }
////        });
//    }
//
//    private static boolean parseVirusTotalResponse(String json) {
//        // Implement the logic to parse the JSON response from VirusTotal API
//        // Extract the necessary information to determine if the link is safe or not
//        // You may need to refer to the VirusTotal API documentation for the response format
//        // Return true if the link is safe, false otherwise
//        try {
//            JSONObject responseJson = new JSONObject(json);
//
//            // Check if the response indicates the URL is safe
//            if (responseJson.has("positives") && responseJson.getInt("positives") == 0) {
//                return true; // URL is safe
//            } else {
//                return false; // URL is potentially unsafe
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//}
//
