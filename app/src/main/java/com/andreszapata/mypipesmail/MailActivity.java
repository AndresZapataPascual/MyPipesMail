package com.andreszapata.mypipesmail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MailActivity extends AppCompatActivity {
    String nombre, hora, descripcion;
    Boolean  reenviado;
    int img;
    CircleImageView foto;
    TextView textoNombre, textoHora, textoDescripcion, textoReenviado;

    @Override
    protected  void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_mail);

        textoNombre = findViewById(R.id.nombreEmail);
        textoHora = findViewById(R.id.horaEmail);
        textoDescripcion = findViewById(R.id.descripcion);
        textoReenviado = findViewById(R.id.reenviadoEmail);
        foto = findViewById(R.id.fotoEmail);

        Intent recibir = this.getIntent();
        if (recibir != null){
            nombre = recibir.getStringExtra("emisor");
            hora = recibir.getStringExtra("hora");
            img = recibir.getIntExtra("foto", R.drawable.cafe);
            descripcion = recibir.getStringExtra("asunto");
            reenviado = recibir.getBooleanExtra("reenviado", false);

            textoNombre.setText(nombre);
            textoHora.setText(hora);
            textoDescripcion.setText(descripcion);
            textoReenviado.setText(resentParser(reenviado));
            foto.setImageResource(img);
        }
    }
    private String resentParser(Boolean resent){
        return resent ? "Email reenviado" : "Este email no ha sido reenviado";
    }
}
