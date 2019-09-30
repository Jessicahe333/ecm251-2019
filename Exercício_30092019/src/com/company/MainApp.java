package com.company;

import com.company.model.Jogo;
import com.company.model.JogosDAO;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    private Scanner scan;
    private List<Jogo> jogos;

    public MainApp() {
        scan = new Scanner(System.in);
        jogos = new ArrayList<>();
    }

    private void menu() {
        System.out.println("1 - Exibir todos");
        System.out.println("2 - Cadastrar Jogo");
        System.out.println("3 - Buscar por nome");
        System.out.println("4 - Buscar por plataforma");
        System.out.println("5 - Buscar por genero");
        System.out.println("6 - Update Jogo");
        System.out.println("7 - Delete Jogo");
        System.out.println("0 - Sair");
    }

    private void avaliarOp(int op) {
        Jogo jogo = new Jogo();
        switch (op) {
            //Buscar todos
            case 1:
                jogos = JogosDAO.getInstance().getAll();
                exibirJogos();
                break;
            case 2:
                System.out.println("Informe nome, genero, plataforma e ano:");
                jogo.nome = scan.next();
                jogo.genero = scan.next();
                jogo.plataforma = scan.next();
                jogo.lancamento = scan.next();
                JogosDAO.getInstance().insertJogo(jogo);
                break;
            case 3:
                System.out.println("Informe um nome:");
                jogo.nome = scan.next();
                jogos = JogosDAO.getInstance().getAllByName(jogo.nome);
                exibirJogos();
                break;
            case 4:
                System.out.println("Informe um plataforma:");
                jogo.plataforma = scan.next();
                jogos = JogosDAO.getInstance().getAllByPlataforma(jogo.plataforma);
                exibirJogos();
                break;
            case 5:
                System.out.println("Informe um plataforma:");
                jogo.genero = scan.next();
                jogos = JogosDAO.getInstance().getAllByGenero(jogo.genero);
                exibirJogos();
                break;
            case 6:
                System.out.println("Informe no nome:");
                jogo.nome = scan.next();
                jogos = JogosDAO.getInstance().getAllByName(jogo.nome);
                if(jogos == null)
                    System.out.println("Jogo nao cadastrado");
                else{
                    jogo = jogos.get(0);
                    System.out.println("Nome [" + jogo.nome + "]:");
                    jogo.nome = scan.next();
                    System.out.println("Genero [" + jogo.genero + "]:");
                    jogo.genero = scan.next();
                    System.out.println("Plataforma [" + jogo.plataforma + "]:");
                    jogo.plataforma = scan.next();
                    System.out.println("Lancamento [" + jogo.lancamento + "]:");
                    jogo.lancamento = scan.next();
                    JogosDAO.getInstance().updateJogo(jogo);
                }
                break;
            case 7:
                System.out.println("Informe o ID:");
                jogo.id =scan.nextInt();
                JogosDAO.getInstance().deletById(jogo.id);
                break;

        }

    }

    public void mainLoop() {
        int op;
        while (true) {
            menu();
            op = scan.nextInt();
            if (op == 0)
                break;
            else
                avaliarOp(op);
        }
    }

    private void exibirJogos() {
        for (Jogo jogo : jogos) {
            System.out.println(jogo);
        }
    }
}
