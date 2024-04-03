package com.andreszapata.mypipesmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listaEmails;
    boolean[] leido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotosEmail = {
                R.drawable.cafe,
                R.drawable.lau,
                R.drawable.adidas,
                R.drawable.movistar,
                R.drawable.tigo,
                R.drawable.nelson,
                R.drawable.amazon
        };
        String[] nombresEmail = {
                "Starbucks",
                "Laura Daniela Salas",
                "Adidas",
                "Movistar",
                "Tigo",
                "Nelson Augusto Benitez Montoya",
                "Amazon"
        };
        String[] descripciones = {
                "Starbucks anunció la certificación de sus primeras 11 tiendas más ecológicas, a medida que la compañía acelera la expansión internacional de su marco de código abierto de tiendas más ecológicas destinadas a reducir las emisiones globales de carbono, el uso de agua y los desechos enviados a los vertederos en un 50 %. para el 2030",
                "Por favor dame otra oportunidad... No volveré a cometer el mismo error",
                "El deporte nos mantiene en forma. Te mantiene atento. Nos une. A través del deporte podemos cambiar vidas. Ya sea a través de historias de atletas inspiradores. Animándote a ponerte en marcha. Ofreciéndote artículos deportivos con las últimas tecnologías para mejorar tu rendimiento. Supera tu mejor marca personal",
                "Precios increíbles y financiación exclusiva para que estrenes celular con Movistar. Contrata tu plan Hogar, estrena celular o adquiere el plan móvil que...",
                "Pásate a Tigo UNE con nuestros planes post pago. Por favor amigo, pásate y descubre  ya una excelente experiencia en tu navegacion ultra pro 5G",
                "Buenos dias para todos, les anuncio que la entrega del jueves queda aplazada, tendran plazo maximo hasta el domingo 11:59, recuerden tener los commit dentro del tiempo estipulado.",
                "Sí, nosotros te lo enviamos. Compra las mejores marcas en electrónica, ropa, libros y más. Envío gratis a Colombia en pedidos elegibles de más de $35 USD."
        };
        String[] horas = {
                "2:30 PM",
                "3:33 AM",
                "2:59 PM",
                "5:36 PM",
                "6:30 PM",
                "2:15 AM",
                "1:48 PM"
        };
        Boolean[] reenviado = {
                true,
                false,
                true,
                true,
                true,
                false,
                false,
        };
        leido = new boolean[nombresEmail.length];

        ListAdapter emails = new ListAdapter(MainActivity.this, nombresEmail,horas,fotosEmail,descripciones, reenviado, leido);
        listaEmails = (ListView) findViewById(R.id.listaEmails);
        listaEmails.setAdapter(emails);

        listaEmails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leido[position] = true;
                emails.notifyDataSetChanged();
                Intent SendInfo = new Intent(MainActivity.this, MailActivity.class);
                SendInfo.putExtra("emisor", nombresEmail[position])
                        .putExtra("hora", horas[position])
                        .putExtra("foto", fotosEmail[position])
                        .putExtra("asunto", descripciones[position])
                        .putExtra("reenviado:", reenviado[position]);
                startActivity(SendInfo);
            }
        });

    }
}
