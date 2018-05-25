package com.iesvirgendelcarmen.dam.recuperacion09;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.iesvirgendelcarmen.dam.recuperacion09.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    TextView texto2;
    Button iniciar, detener;
    ImageView imagen;
    private int alto,ancho;
    private double ratio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto2=(TextView)findViewById(R.id.texto2);
        iniciar=(Button)findViewById(R.id.iniciar);
        detener=(Button)findViewById(R.id.detener);
        imagen=(ImageView)findViewById(R.id.imagen);

        Resources recursos=getResources();
        Drawable imagen1= recursos.getDrawable(R.drawable.boccaccino);
        Drawable imagen2= recursos.getDrawable(R.drawable.boticelli);
        Drawable imagen3= recursos.getDrawable(R.drawable.durero);
        Drawable imagen4= recursos.getDrawable(R.drawable.leonardo);
        Drawable imagen5= recursos.getDrawable(R.drawable.miguelangel);
        Drawable imagen6= recursos.getDrawable(R.drawable.rafael);
        Drawable imagen7= recursos.getDrawable(R.drawable.tintoreto);

        imagen.setVisibility(ImageView.VISIBLE);
        imagen.setBackgroundResource(R.drawable.transicion);
        final AnimationDrawable animacion=new AnimationDrawable();
        animacion.setOneShot(false);
        animacion.addFrame(imagen1,2000);
        animacion.addFrame(imagen2,2000);
        animacion.addFrame(imagen3,2000);
        animacion.addFrame(imagen4,2000);
        animacion.addFrame(imagen5,2000);
        animacion.addFrame(imagen6,2000);
        animacion.addFrame(imagen7,2000);
        imagen.setBackgroundDrawable(animacion);

        ancho=imagen1.getIntrinsicWidth();
        alto=imagen1.getIntrinsicHeight();
        ratio=ancho/alto;
        texto2.setText("ANCHO= "+ancho+" ALTO= "+alto+" RATIO= "+ratio);
        ancho=imagen.getMeasuredWidth();
        alto=imagen.getMeasuredHeight();
        texto2.append("\n"+"IMAGEN "+"ANCHO= "+ancho+" ALTO= "+alto);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion.start();
                ancho=imagen.getMeasuredWidth();
                alto=imagen.getMeasuredHeight();
                ratio=ancho/alto;
                double padding=(ancho-ratio)/2;
                texto2.append("\n"+"NUEVO ANCHO= "+ancho+" PADDING= "+padding);
            }
        });
        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion.stop();
            }
        });



    }
}
