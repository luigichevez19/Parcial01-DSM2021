package com.local.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public class calculo extends AppCompatActivity {

    TableLayout tl;
    ArrayList<emp> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        tl = (TableLayout) findViewById(R.id.mainTable);

        String jsonLista = getIntent().getStringExtra("list");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<emp>>(){}.getType();
        lista = gson.fromJson(jsonLista,type);



        for(emp e:lista){
            TableRow tr = new TableRow(getApplicationContext());
            Double sueldoBase = 0.0;
            if(e.horas < 160) sueldoBase = e.horas*9.75;
            else sueldoBase = 160*9.75 + (e.horas-160)*11.5;
            Double isss = sueldoBase * 0.0525;
            Double afp =  sueldoBase * 0.0688;
            Double renta = sueldoBase * 0.1;
            Double liq = sueldoBase - (isss + afp + renta);

            Double bono = 0.0;
            switch (e.cargo) {
                case "Gerente":
                    bono = liq * 0.1; break;
                case "Asistente":
                    bono = liq * 0.05; break;
                case "secretaria":
                    bono = liq * 0.03; break;
                default:
                    bono = liq * 0.02;
            }
            newTv(e.nombre+" "+e.apel,100,tr);
            newTv(e.cargo,73,tr);
            DecimalFormat dec2 = new DecimalFormat("#.##");
            newTv(dec2.format(isss),47,tr);
            newTv(dec2.format(afp),47,tr);
            newTv(dec2.format(renta),47,tr);
            newTv(dec2.format(bono),47,tr);
            newTv(dec2.format(liq),50,tr);

            tr.setId(e.hashCode());
            tr.setPadding(0,5,0,5);
            Log.i("lista",e.nombre);
            tl.addView((tr));
        }
    }

    private void newTv(String txt, int w,TableRow t){
        TextView tv = new TextView(getApplicationContext());
        tv.setText(txt);
        tv.setId(txt.hashCode());
        tv.setWidth(w);
        t.addView(tv);
    }

//    private int[] maxMin(ArrayList<emp> e){
//        int max =0;
//        int min = max;
//        for(emp i: e){
//            if()
//        }
//    }

}