package com.local.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONStringer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private EditText name;
    private EditText apell;
    private EditText cargo;
    private EditText horas;
//    public Button add;
    public Button btnCalc;
    LinearLayout cont;
    ArrayList<emp> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.txtName);
        apell = (EditText)findViewById(R.id.txtApel);
        cargo = (EditText)findViewById(R.id.txtCargo);
        horas = (EditText)findViewById(R.id.txtHoras);
        btnCalc = findViewById(R.id.btnCalc);
        cont = (LinearLayout)findViewById(R.id.cont);
        list = new ArrayList<emp>();

    }

    public void addEmp (View view){
        String n = name.getText().toString();
        String a = apell.getText().toString();
        String c = cargo.getText().toString();
        int h ;
        if(horas.getText().toString().equals("")) h = 0;
        else h = Integer.parseInt(horas.getText().toString());
        if(n.equals("") || a.equals("") || c.equals("") || h < 1 ) Toast.makeText(getApplicationContext(),"Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        else{
            list.add(new emp(n, a, c, h));
            if(list.size() >= 3){
                btnCalc.setEnabled(true);
            }
            TextView tv = new TextView(getApplicationContext());
            tv.setText(n+" "+a);
            tv.setId(n.hashCode());
            tv.setTextSize(30);
            cont.addView(tv);
            clearAll();
        }
//        Log.i("list",list.toString());
    }

    public void calc(View view) {
        Intent i = new Intent(this,calculo.class);
//        Bundle b = new Bundle();
//        b.putParcelableArrayList("lista", (ArrayList<emp>) list);
        Gson json = new Gson();
        String jsonList = json.toJson(list);
        i.putExtra("list",jsonList);
        startActivity(i);
    }
    private void clearAll(){
        name.setText("");
        apell.setText("");
        cargo.setText("");
        horas.setText("");
    }
}
