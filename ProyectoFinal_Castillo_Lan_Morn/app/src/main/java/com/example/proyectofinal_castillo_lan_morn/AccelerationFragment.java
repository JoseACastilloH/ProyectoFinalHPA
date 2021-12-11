package com.example.proyectofinal_castillo_lan_morn;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.app.Activity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccelerationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccelerationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SensorManager SM;
    private TextView xText, yText, zText;
    private Sensor mySensor;
    int whip = 0;
    private FrameLayout flView;

    public AccelerationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
     //* @param param2 Parameter 2.
     * @return A new instance of fragment AccelerationFragment.
     */
    // TODO: Rename and change types and number of parameters

    public void setSensor(SensorManager sensor){
        SM = sensor;
    }

    SensorEventListener accelerationSensorEventListener
            = new SensorEventListener() {


        //flView = view.findViewById(R.id.flView);

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            //View contenedor = event.getView();

            if (y>0 ){
                whip++;
                //contenedor.setBackgroundColor(Color.RED);
            }
            else if (y<0 ){
                whip--;
                //getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }
            xText.setText("X: " + event.values[0]);
            yText.setText("Y: " + event.values[1]);
            zText.setText("Z: " + event.values[2]);
        }
    };








    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create our Sensor Manager
        //SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(accelerationSensorEventListener, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        xText = (TextView)view.findViewById(R.id.xText);
        yText = (TextView)view.findViewById(R.id.yText);
        zText = (TextView)view.findViewById(R.id.zText);

    }









    public static AccelerationFragment newInstance(String param1, String param2) {
        AccelerationFragment fragment = new AccelerationFragment();
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
        return inflater.inflate(R.layout.fragment_acceleration, container, false);
    }



}