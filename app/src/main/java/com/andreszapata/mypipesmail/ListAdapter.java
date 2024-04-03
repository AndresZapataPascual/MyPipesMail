package com.andreszapata.mypipesmail;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, Horas, Descripciones;
    Boolean[] Reenviado;
    boolean[] Leido;
    int[] imageID;
    LayoutInflater inflater;

    public ListAdapter(Context contexto, String[] nombres, String[] horas, int[] imageID, String[] descripciones, Boolean[] reenviado, boolean[] leido){
        this.Contexto = contexto;
        this.Nombres = nombres;
        this.Horas = horas;
        this.imageID = imageID;
        this.Descripciones = descripciones;
        this.Reenviado = reenviado;
        this.Leido = leido;
        inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount(){
        return Nombres.length;
    }

    @Override
    public Object getItem(int i){
        return null;
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        view = inflater.inflate(R.layout.list_item, null);
        ImageView fotoEmail = view.findViewById(R.id.foto);
        TextView nombreEmisor = view.findViewById(R.id.nombre);
        TextView horaEmail = view.findViewById(R.id.horaEmail);
        TextView reenviado = view.findViewById(R.id.reenviadoEmail);
        fotoEmail.setImageResource(imageID[i]);
        reenviado.setText(resentParser(Reenviado[i]));
        horaEmail.setText(Horas[i]);
        nombreEmisor.setText(Nombres[i]);

        if (Leido[i]){
            nombreEmisor.setTypeface(null, Typeface.NORMAL);
            horaEmail.setTypeface(null, Typeface.NORMAL);
            reenviado.setTypeface(null, Typeface.NORMAL);
        } else {
            nombreEmisor.setTypeface(null, Typeface.BOLD);
            horaEmail.setTypeface(null, Typeface.BOLD);
            reenviado.setTypeface(null, Typeface.BOLD);
        }

        return view;
    }
    private String resentParser(Boolean resent){
        return resent ? "Email reenviado" : "Este email no ha sido reenviado";
    }
}