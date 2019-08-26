package com.company;

import auxiliar_database.UsuariosDAO;
import model.Usuario;
import utilities.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UsuariosDAO usuariosDAO;
        usuariosDAO = new UsuariosDAO(Constants.URL_MEU_BANCO);
        List<Usuario> meusUsuarios = usuariosDAO.getALLUsuario();
        for (Usuario user : meusUsuarios){
            System.out.println("ID: " + user.id);
            System.out.println("Nome: " + user.nome);
        }

    }
}
