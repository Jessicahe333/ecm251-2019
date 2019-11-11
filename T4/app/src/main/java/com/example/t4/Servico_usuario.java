package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Servico_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_usuario);
    }

    public void entrarUsuario(View view){
        Intent intent = new Intent(this, Devolucao.class);
        startActivity(intent);
    }
}
