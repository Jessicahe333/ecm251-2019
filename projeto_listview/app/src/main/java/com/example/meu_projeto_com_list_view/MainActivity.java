package com.example.meu_projeto_com_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import models.User;

public class MainActivity extends AppCompatActivity {

    private List<User> myUsers;

    @BindView(R.id.btnAdd)
    protected Button btnAdd;

    @BindView(R.id.btnCheckList)
    protected Button btnCheckList;

    @BindView(R.id.etName)
    protected EditText etName;
    @BindView(R.id.etMail)
    protected EditText etMail;
    @BindView(R.id.etPhone)
    protected EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myUsers = new ArrayList<>();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAdd)
    public void addClick(){
        User newUser = new User(
                etName.getText().toString(),
                etMail.getText().toString(),
                etPhone.getText().toString()
        );
        myUsers.add(newUser);

        //Limpa o texto das caixas de texto
        etName.getText().clear();
        etMail.getText().clear();
        etPhone.getText().clear();
    }

    @OnClick(R.id.btnCheckList)
    public void enviarLista(){
        Intent intent = new Intent(this, ListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("LISTA_USUARIOS", (Serializable) myUsers);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
