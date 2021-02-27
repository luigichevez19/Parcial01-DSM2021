package sv.edu.udb.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText vots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vots=(EditText) findViewById(R.id.txtVotos);
    }
    public void Resultado(View v)
    {
        Intent i = new Intent(this,Resultado.class);
        i.putExtra("txtVotos",vots.getText().toString());
        startActivity(i);
    }
    public void finalizar(View v) {
        finish();
    }
}