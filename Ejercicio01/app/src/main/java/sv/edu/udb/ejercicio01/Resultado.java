package sv.edu.udb.ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView Resp, Resp2;
    String a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Resp=(TextView) findViewById(R.id.txtResp);
        Resp2=(TextView) findViewById(R.id.txtResp2);
        //Lee datos del activitie anteior
        Bundle bundle = getIntent().getExtras();
        a=bundle.getString("txtA");
        b=bundle.getString("txtB");
        c=bundle.getString("txtC");
        Calcular();
    }
     void Calcular()
    {
        Double a2,b2,c2;
        a2 = Double.parseDouble(a.toString());
        b2 = Double.parseDouble(b.toString());
        c2 = Double.parseDouble(c.toString());
        double resp2= (-b2 + Math.sqrt(Math.pow(b2,2)- 4*a2*c2))/2*a2;
        double resp3= (-b2 - Math.sqrt(Math.pow(b2,2)- 4*a2*c2))/2*a2;
        Resp.setText("Respuesta 1: "+resp2);
        Resp2.setText("Respuesta 2: "+resp3);
    }

}