package com.example.accgyrotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;

    Sensor accelerometer;
    Sensor gyro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Initializing Sensor services");

        sensorManager  =  (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //accelerometer
        accelerometer =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener( MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG,"registered accelerometer");

        //gyroscope
        gyro =  sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(MainActivity.this,gyro,SensorManager.SENSOR_DELAY_NORMAL);



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor  = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            Log.d(TAG, "onSensorChanged: x : "+sensorEvent.values[0] + "Y : " + sensorEvent.values[1] + "Z: = "+sensorEvent.values[2]);

        else if(sensor.getType() == Sensor.TYPE_GYROSCOPE)
            Log.d(TAG, "onSensorChanged:GYRO x : "+sensorEvent.values[0] + "GYRO Y : " + sensorEvent.values[1] + " GYRO Z: = "+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}