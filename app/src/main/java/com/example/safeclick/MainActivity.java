package com.example.safeclick;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText url1;
    TextView result;
    Button submit;
    Button openurl;
    ImageButton reportBut;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        url1 = findViewById(R.id.url);
        result = findViewById(R.id.response);
        submit = findViewById(R.id.button);
        openurl = findViewById(R.id.openurl);
        reportBut = findViewById(R.id.reportbut);
//        public void gotoUrl(String s){
//            Uri uri = Uri.parse(s);
//        }

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String link = url1.getText().toString();
                Log.d("myapp", "Url enter by user: " + link);
                String API_KEY = "5b2923603ce95e22c8ffa9977b3a2999a2170f9b3f2a958c11d731c2f7adb8ba";
                String url = "https://www.virustotal.com/vtapi/v2/url/report?apikey=" + API_KEY + "&resource=" + link + "&scan=1";
//                String url = "https://www.virustotal.com/vtapi/v2/url/report?apikey=5b2923603ce95e22c8ffa9977b3a2999a2170f9b3f2a958c11d731c2f7adb8ba&resource=https://https;..microsoft.login-virtual@is.gd/3EYwy6&scan=1";
                Log.d("button", "Button is clicked");
                openurl.setVisibility(View.INVISIBLE);
                result.setText("Wait!! Detecting link.....");
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                Log.d("button", "Url calling: " + link);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject scans;
                                    scans = response.getJSONObject("scans");
                                    if(response.getInt("response_code")==1){
                                        int threat=0;
                                        try {
                                            if(scans.getJSONObject("Segasec").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("CMC Threat Intelligence").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Sophos").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("alphaMountain.ai").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("CyRadar").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }
                                        try{
                                            if(scans.getJSONObject("CRDF").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }
                                        try{
                                            if(scans.getJSONObject("Webroot").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("ESET").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Forcepoint ThreatSeeker").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Phishtank").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }
                                        try{
                                            if(scans.getJSONObject("Fortinet").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("BitDefender").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("G-Data").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Netcraft").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Cluster25").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("AlphaSOC").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("Emsisoft").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }

                                        try{
                                            if(scans.getJSONObject("VIPRE").getString("detected").equalsIgnoreCase("true")) {
                                                threat++;
                                            }
                                        }catch (JSONException e){
                                            Log.e("err", "scan name not found");
                                        }


                                        if(threat<2){
                                            result.setText("Safe Link Detected");
                                            openurl.setVisibility(View.VISIBLE);
                                        }
                                        else if(threat>=2 && threat <=5){
                                            result.setText("Risk Level: Medium\n"+ "There is a chance that the url is malicious.");
                                        }
                                        else if(threat>5){
                                            result.setText("Risk Level: High\n"+"There is a high chance that the url is malicious/phishing");
                                        }
                                    }else{
                                        result.setText("Link Not recognised");
                                        openurl.setVisibility(View.VISIBLE);
                                        openurl.setText("Open Anyway");
                                    }

                                } catch (JSONException e) {
                                    result.setText("Link Not recognised");
                                    openurl.setVisibility(View.VISIBLE);
                                    openurl.setText("Open Anyway");
//                                    throw new RuntimeException(e);
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", "Something went wrong");
                    }
                });

                queue.add(jsonObjectRequest);
            }
        });

        openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(url1.getText().toString());

            }
        });

        reportBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Reporting!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] reciepients = {"abhinav89908@gmail.com", "sachinu760@gmail.com"};

                intent.putExtra(Intent.EXTRA_EMAIL, reciepients);
                intent.setType("messgage/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });







    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}