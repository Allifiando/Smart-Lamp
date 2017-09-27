package com.example.ando.iot;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    RelativeLayout layoutSensor;
    private SensorManager sensorManager;
    TextView tvMaxValue, tvCurrentLight, judul,tvStatus;
    ImageView lamp;
    Button btnOn,btnOff,btnOnPark,btnOnLiivngRoom,btnOnDiningRomm,btnOnKitchen;
    private static String url  =  "https://andoid.000webhostapp.com/api.php?aksi=0";
    private static String url1 =  "https://andoid.000webhostapp.com/api.php?aksi=1";
    private static String url2 =  "https://andoid.000webhostapp.com/api.php?aksi=2";
    private static String url3 =  "https://andoid.000webhostapp.com/api.php?aksi=3";
    private static String url4 =  "https://andoid.000webhostapp.com/api.php?aksi=4";
    private static String url5 =  "https://andoid.000webhostapp.com/api.php?aksi=5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutSensor = (RelativeLayout) findViewById(R.id.layoutSensor);
        tvMaxValue = (TextView)findViewById(R.id.tvMaxValue);
        tvCurrentLight = (TextView)findViewById(R.id.tvCurrentLight);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        judul = (TextView) findViewById(R.id.judul);
        lamp = (ImageView) findViewById(R.id.lamp);
        btnOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);
        btnOnLiivngRoom = (Button) findViewById(R.id.btnOnLivingRoom);
        btnOnPark = (Button) findViewById(R.id.btnOnPark);
        btnOnDiningRomm = (Button) findViewById(R.id.btnOnDiningRoom);
        btnOnKitchen = (Button) findViewById(R.id.btnOnKitchen);

        //create instance of sensor manager and get system service to interact with Sensor
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null){
            Toast.makeText(MainActivity.this,"No Light Sensor Found! ",Toast.LENGTH_LONG).show();
        }
        else {
            float max =  lightSensor.getMaximumRange();
            //Get Maximum Value From Light sensor
            tvMaxValue.setText("Max Range : " + String.valueOf(max));
            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url5)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("All The Lights Are On");
                            }
                        });
                    }
                });
            }
        });

        btnOnLiivngRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url1)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("Lamp in Living Room was On");
                            }
                        });
                    }
                });
            }
        });

        btnOnPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url2)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("Lamp in Park was On");
                            }
                        });
                    }
                });
            }
        });

        btnOnDiningRomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url3)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("Lamp in Dining Room was On");
                            }
                        });
                    }
                });
            }
        });

        btnOnKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url4)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("Lamp in Kitchen was On");
                            }
                        });
                    }
                });
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        final String textResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                tvStatus.setText("All The Lights Are Off");
                            }
                        });
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the lightSensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
            float currentLight = sensorEvent.values[0];
            if(currentLight<1){
                layoutSensor.setBackgroundColor(getResources().getColor(R.color.nolight));
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.nolight));
                judul.setText("No Light");
                judul.setTextColor(getResources().getColor(R.color.white));
                tvMaxValue.setTextColor(getResources().getColor(R.color.white));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.white));
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));}
            else if(currentLight<5){
                layoutSensor.setBackgroundColor(getResources().getColor(R.color.dim));
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.dim));
                judul.setTextColor(getResources().getColor(R.color.white));
                tvMaxValue.setTextColor(getResources().getColor(R.color.white));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.white));
                judul.setText("Dim");
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));}
            else if(currentLight<10){
                layoutSensor.setBackgroundColor(getResources().getColor(R.color.normal));
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.normal));
                judul.setText("Normal");
                judul.setTextColor(getResources().getColor(R.color.black));
                tvMaxValue.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));}
            else if(currentLight<100){
                layoutSensor.setBackgroundColor(getResources().getColor(R.color.bright));
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.bright));
                judul.setText("Bright (Room)");
                judul.setTextColor(getResources().getColor(R.color.black));
                tvMaxValue.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));}
            else {
                layoutSensor.setBackgroundColor(getResources().getColor(R.color.sun));
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.sun));
                judul.setText("Bright (Sun)");
                judul.setTextColor(getResources().getColor(R.color.black));
                tvMaxValue.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
