package com.example.proyectofinal_castillo_lan_morn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
    private Drawable drwAceBlanco, drwAceGris;
    private Drawable drwGiroBlanco, drwGiroGris;
    private Drawable drwProxBlanco, drwProxGris;
    private Drawable drwCube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resources res = getResources();

        drwAceBlanco = res.getDrawable(R.drawable.icono_acelerometro_blanco, getTheme());
        drwAceGris = res.getDrawable(R.drawable.icono_acelerometro_gris, getTheme());
        drwGiroBlanco = res.getDrawable(R.drawable.icono_giroscopio_blanco, getTheme());
        drwGiroGris = res.getDrawable(R.drawable.icono_giroscopio_gris, getTheme());
        drwProxBlanco = res.getDrawable(R.drawable.icono_proximidad_blanco, getTheme());
        drwProxGris = res.getDrawable(R.drawable.icono_proximidad_gris, getTheme());
        drwCube = res.getDrawable(R.drawable.icono_cubo, getTheme());

        btnAceletrometro = findViewById(R.id.btnAcelerometro);
        btnGiroscopio = findViewById(R.id.btnGiroscopio);
        btnProximidad = findViewById(R.id.btnProximidad);

        btnAceletrometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnAceletrometro.setForeground(drwAceBlanco);
                btnGiroscopio.setForeground(drwGiroGris);
                btnProximidad.setForeground(drwProxGris);
                SensorManager sensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                AccelerationFragment proFrag = new AccelerationFragment();
                proFrag.setSensor(sensor);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragView, proFrag);
                ft.commit();

            }
        });

        btnGiroscopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnAceletrometro.setForeground(drwAceGris);
                btnGiroscopio.setForeground(drwGiroBlanco);
                btnProximidad.setForeground(drwProxGris);

            }
        });

        btnProximidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnAceletrometro.setForeground(drwAceGris);
                btnGiroscopio.setForeground(drwGiroGris);
                btnProximidad.setForeground(drwProxBlanco);

                SensorManager sensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                ProximityFragment proFrag = new ProximityFragment(sensor, drwCube);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragView, proFrag);
                ft.commit();
            }
        });
    }


}