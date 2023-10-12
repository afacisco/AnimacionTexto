package com.example.animaciontexto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/*
Autor: Juan Francisco Sánchez González
Fecha: 09/10/2023
Clase: Actividad con un ToggleButton que cambia la animación y el color del texto
*/

public class MainActivity extends AppCompatActivity {

    private TextView mensaje;
    private Animation animacion;
    private ToggleButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = (TextView) findViewById(R.id.mensaje);
        boton = (ToggleButton) findViewById(R.id.toggleButton);

        // Listener del evento cambio de estado del ToggleButton
        boton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // Asignamos la animación de traslación y el color azul al texto
                    animacion = AnimationUtils.loadAnimation(compoundButton.getContext(), R.anim.traslacion);
                    animacion.setRepeatMode(Animation.RESTART);
                    animacion.setRepeatCount(20);
                    mensaje.startAnimation(animacion);

                    mensaje.setTextColor(Color.BLUE);
                } else {
                    // Asignamos la animación de rotación y el color verde al texto
                    animacion = AnimationUtils.loadAnimation(compoundButton.getContext(), R.anim.rotacion);
                    animacion.setRepeatMode(Animation.RESTART);
                    animacion.setRepeatCount(20);
                    mensaje.startAnimation(animacion);

                    mensaje.setTextColor(Color.GREEN);
                }
            }
        });
    }
}