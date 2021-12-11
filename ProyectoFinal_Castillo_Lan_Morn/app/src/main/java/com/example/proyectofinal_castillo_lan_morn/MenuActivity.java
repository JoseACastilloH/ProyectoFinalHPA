package com.example.proyectofinal_castillo_lan_morn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    private ImageButton btnAceletrometro;
    private ImageButton btnGiroscopio;
    private ImageButton btnProximidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAceletrometro = findViewById(R.id.btnAcelerometro);
        btnGiroscopio = findViewById(R.id.btnGiroscopio);
        btnProximidad = findViewById(R.id.btnProximidad);

        btnAceletrometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnGiroscopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnProximidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SensorManager sensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                ProximityFragment proFrag = new ProximityFragment();
                proFrag.setSensor(sensor);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragView, proFrag);
                ft.commit();
            }
        });
    }


}