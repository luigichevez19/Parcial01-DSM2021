package sv.edu.udb.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView uno,doss,tres,cuat;
    String votos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        uno=(TextView) findViewById(R.id.lblResc1);
        doss=(TextView)findViewById(R.id.lblResc2);
        tres=(TextView)findViewById(R.id.lblResc3);
        cuat=(TextView)findViewById(R.id.lblResc4);
        //Lee datos del activitie anteior
        Bundle bundle = getIntent().getExtras();
        votos=bundle.getString("txtVotos");
        Calcular();
    }
    void Calcular()
    {
        int un=0,dos=0,tre=0,cua=0;
        String [] vts= votos.split(",");
        int larg=0;
        for (int i=0; i< vts.length;i++)
        {
            larg++;
            switch (vts[i])
            {
                case "1":
                    un++;
                    break;
                case "2":
                    dos++;
                        break;
                case "3":
                    tre++;
                    break;
                case "4":
                    cua++;
                    break;

            }
        }

        int pun=((un*100)/larg),pdos=((dos*100)/larg),ptre=((tre*100)/larg),pcua=((cua*100)/larg);
        uno.setText("Los votos del candidato 1 son:"+un+", el porcentaje que obtuvo fue: "+pun+"%");
        doss.setText("Los votos del candidato 2 son:"+dos+", el porcentaje que obtuvo fue: "+pdos+"%");
        tres.setText("Los votos del candidato 3 son:"+tre+", el porcentaje que obtuvo fue: "+ptre+"%");
        cuat.setText("Los votos del candidato 4 son:"+cua+", el porcentaje que obtuvo fue: "+pcua+"%");
    }
}