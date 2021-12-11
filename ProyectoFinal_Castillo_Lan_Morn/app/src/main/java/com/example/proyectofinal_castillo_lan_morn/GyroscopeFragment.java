package com.example.proyectofinal_castillo_lan_morn;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyroscopeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyroscopeFragment extends Fragment {

    TextView textX, textY, textZ;
    private SensorManager sensorManager;
    Sensor sensor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GyroscopeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GyroscopeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GyroscopeFragment newInstance(String param1, String param2) {
        GyroscopeFragment fragment = new GyroscopeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gyroscope, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        textX = view.findViewById(R.id.tvX);
        textY = view.findViewById(R.id.tvY);
        textZ = view.findViewById(R.id.tvZ);
    }

    public void setSensor(SensorManager sensor){
        sensorManager = sensor;
    }

    public void onResume(){
        super.onResume();
        sensorManager.registerListener(gyrolistener,sensor,SensorManager.SENSOR_DELAY_FASTEST);

    }

    public void onStop(){
        super.onStop();
        sensorManager.unregisterListener(gyrolistener);
    }

    public SensorEventListener gyrolistener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            textX.setText("X: " + (int) x);
            textY.setText("Y: " + (int) y);
            textZ.setText("Z: " + (int) z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };



}