package com.iesvirgendelcarmen.dam.recuperacion09;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by matinal on 25/05/2018.
 */

public class Actividad05 extends AppCompatActivity {
    static int escala = 350;
    Button button ;
    TextView t1,t2;
    ImageView imageView;
    Bitmap imagen;
    int factorEscala;
    int ancho;
    int alto;
    boolean filtro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad05);

        imageView = findViewById(R.id.imagen);
        button = findViewById(R.id.boton);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        imagen = BitmapFactory.decodeResource(getResources(),R.drawable.leonardo);
        factorEscala = escala / (int)imagen.getHeight();


        alto = (Integer) ((int) imagen.getHeight());
        ancho = (Integer) ((int) imagen.getWidth());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reescalado();
            }
        });

    }

    public void reescalado(){

        Long tiempoInicio = System.currentTimeMillis();
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoProcesado = tiempoInicio-tiempoFinal;


        Bitmap bm = Bitmap.createScaledBitmap(imagen,ancho*factorEscala,alto*factorEscala,filtro);
        imageView.setImageBitmap(bm);

    }
}
