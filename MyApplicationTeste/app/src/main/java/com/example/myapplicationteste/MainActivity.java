package com.example.myapplicationteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicar(View v){
        Toast.makeText(getApplicationContext(),
                "Ola Mundo", Toast.LENGTH_LONG).show();
    }
}