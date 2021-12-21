package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAcool;
    private TextInputEditText editPrecoGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAcool        = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina     = findViewById(R.id.editPrecoGasolina);
        textoResultado        = findViewById(R.id.textResultado);
    }

    public  void calcularPreco (View view){
        //recuperar valores
        String precoAlcool = editPrecoAcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validarCampos
      Boolean camposValidados = validarCampos( precoAlcool , precoGasolina);
      if( camposValidados ) { //converter string para int
          Double valorAlcool = Double.parseDouble(precoAlcool);
          Double valorGasolina = Double.parseDouble(precoGasolina);

          //fazer calculo para saber qual utilizar
          Double resultado = valorAlcool / valorGasolina;
          if (resultado >= 0.7) {
              textoResultado.setText("Melhor utilizar Gasolina");
          } else {
              textoResultado.setText("Mehor utilizar Alcool");
          }
         }else {
          textoResultado.setText(" Preencha todos os campos");
      }


    }
     public Boolean validarCampos ( String palcool , String pGasolina){
        Boolean camposValidados = true;
        ;

         if (pGasolina == null || pGasolina.equals( "" )){
             camposValidados = false;
         }else if(palcool == null || palcool.equals("")){
             camposValidados = false;


         }
        return camposValidados;

     }
}