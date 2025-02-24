package com.example.appcilindror;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Model.Cilindro;

public class MainActivity extends AppCompatActivity {
    //Declaramos los objetos de ingreso de datos
    EditText txtRadio, txtAltura;
    TextView lbVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        //Inicilizar los objetos de tipo visuales
        txtRadio = findViewById(R.id.txtRadio);
        txtAltura = findViewById(R.id.txtAltura);
        lbVolumen= findViewById(R.id.lbVolumen);
        lbVolumen.setText("");

    }

    public void CalcularVolumen (View boton){
        if(Validar()) //Si validar retorna true
            return;
        //leer los datos en los ediText
        Double radio = Double.valueOf(txtRadio.getText().toString());
        Double altura = Double.valueOf(txtAltura.getText().toString());
        Cilindro oC= new Cilindro(radio,altura);
        //Imprimimos el resultado
        lbVolumen.setText(oC.toString());
    }

    private boolean Validar() {
        if(txtRadio.getText().toString().trim().isEmpty()){
            txtRadio.setError("Campo obligatorio para el radio de la base");
            txtRadio.requestFocus();
            return  true;
        }

        if(txtAltura.getText().toString().trim().isEmpty()){
            txtAltura.setError("Campo obligatorio para el volumen del cilindro");
            txtAltura.requestFocus();
            return  true;
        }

        return false;
    }
}