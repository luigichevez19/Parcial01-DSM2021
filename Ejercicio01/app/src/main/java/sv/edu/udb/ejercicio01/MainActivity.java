package sv.edu.udb.ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText A,B,C;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A=(EditText) findViewById(R.id.txtA);
        B=(EditText) findViewById(R.id.txtB);
        C=(EditText) findViewById(R.id.txtC);
    }

    public void Resultado(View v)
    {
        Intent i = new Intent(this,Resultado.class);
        i.putExtra("txtA",A.getText().toString());
        i.putExtra("txtB", B.getText().toString());
        i.putExtra("txtC",C.getText().toString());
        startActivity(i);
    }
    public void finalizar(View v) {
        finish();
    }

}