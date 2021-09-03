package br.pro.adalto.appcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor = findViewById(R.id.etValor);
        botao = findViewById(R.id.btnMultiplicar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

    }


    private void calcular(){
        //  double result = 2 * Double.valueOf( etValor.getText().toString() );
        String texto = etValor.getText().toString();
        double valor = Double.valueOf( texto );
        double resultado = valor * 2;

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Resultado");
        alerta.setMessage( String.valueOf( resultado )  );
        alerta.setPositiveButton("OK" , null);
        alerta.show();
    }

}