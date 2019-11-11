package com.example.carregaimagemonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
    }


    //Método para fechar a tela
    public void voltar(View view){
        finish();
    }

    //Método para carregar imagem no imagemView
    public void carregarImagem(View view){
        ImageView imagemView = (ImageView) findViewById(R.id.imageView);
        EditText editText = findViewById(R.id.editText);
        Picasso.get().load(editText.getText().toString()).into(imagemView);

    }
}
