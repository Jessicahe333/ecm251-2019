package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void entrarUsuario(View view){
        Intent intent = new Intent(this, Login_Usuario.class);
        startActivity(intent);
    }

    public void entrarFuncionario(View view){
        Intent intent = new Intent(this, Login_Funcionario.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnusuario)
    public void pegar(){
        try {
            entrarUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
