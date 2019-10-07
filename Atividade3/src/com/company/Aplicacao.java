package com.company;
import java.util.InputMismatchException;

import auxiliar_database.SingletonUsuariosDAO;
import model.Produto;
import auxiliar_database.SingletonProdutosDAO;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Produto> produtos;
    public Aplicacao() {
        produtos = new ArrayList<>();
    }
        public void run(){
            Scanner scanner = new Scanner(System.in);
            do{
                menu1();
                int op = scanner.nextInt();
                boolean resultUser;
                switch (op){
                    case 1:
                        String nome,email,senha;
                        System.out.println("Informe o nome do usuario e a senha:");
                        nome = scanner.next();
                        senha = scanner.next();
                        resultUser = SingletonUsuariosDAO.getInstance().getSenha(nome,senha);

                        if (resultUser) {
                            System.out.println("Senha correta!");
                            if (nome.equals("admin") ) {

                                do{
                                    menu2();
                                    int ip = scanner.nextInt();
                                    int id;
                                    switch (ip){
                                        case 1:

                                            System.out.println("Informe nome, email e senha:");
                                            nome = scanner.next();
                                            email = scanner.next();
                                            senha = scanner.next();
                                            Usuario user = new Usuario(
                                                    nome, email, senha
                                            );
                                            SingletonUsuariosDAO.getInstance().insertUsuario(user);
                                            break;
                                        case 2:
                                            System.out.println("Id para deletar:");
                                            id = scanner.nextInt();
                                            SingletonUsuariosDAO.getInstance().deleteUserById(id);
                                    }
                                    if(ip == 0) break;
                                }while(true);
                            } else {
                                do{
                                    menu3();
                                    int ep = scanner.nextInt();
                                    int id;
                                    Produto resultProduct;
                                    switch (ep){
                                        case 1:
                                            String frabricante, categoria;
                                            int quantidade;
                                            double preco;
                                            System.out.println("Informe o nome, o preço, a quantidade, o fabricante e a categoria(ferramenta ou tinta):");
                                            nome = scanner.next();
                                            preco = scanner.nextDouble();
                                            quantidade = scanner.nextInt();
                                            frabricante = scanner.next();
                                            categoria = scanner.next();
                                            Produto produto = new Produto(nome,preco,quantidade,frabricante,categoria);
                                            SingletonProdutosDAO.getInstance().insertProduto(produto);
                                            break;
                                        case 2:
                                            produtos = SingletonProdutosDAO.getInstance().getAllProduto();
                                            for (Produto p : produtos) {
                                                System.out.println(p);

                                            }
                                            break;
                                        case 3:
                                            System.out.println("Informe o ID:");
                                            id = scanner.nextInt();
                                            resultProduct = SingletonProdutosDAO.getInstance().getProduto(id);
                                            if(resultProduct == null)
                                                System.out.println("Usuario nao cadastrado");
                                            else{
                                                System.out.print("ID: " + resultProduct.id);
                                                System.out.print(" Nome: " + resultProduct.nome);
                                                System.out.println(" Preço: " + resultProduct.preco);
                                                System.out.println(" Qunatidade: " + resultProduct.quantidade);
                                                System.out.println(" Fabricante: " + resultProduct.fabricante);
                                                System.out.println(" Categoria: " + resultProduct.categoria);
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Informe a plataforma do jogo:");
                                            categoria = scanner.next();
                                            produtos = SingletonProdutosDAO.getInstance().getAllProdutosByCategoria(categoria);
                                            produtos.forEach(produto1 -> System.out.println(produto1));
                                    }
                                    if(ep == 0) break;
                                }while(true);
                            }
                    }
                    else{
                        System.out.println("Usuário ou senha inválidos");
                        //menu1();
                    }
                }
                if(op == 0) break;
            }while(true);








    }
    
    public void menu3(){
        System.out.println("1 - Inserir Produto");
        System.out.println("2 - Mostrar todos os produtos");
        System.out.println("3 - Buscar produto pelo ID");
        System.out.println("4 - Buscar produtos pela Categoria");
        System.out.println("5 - Vender produto");
        System.out.printf("0 - Sair");
    }
    public  void menu1(){
        System.out.println("1 - login");
        System.out.printf("0 - Sair");

    }
    public  void menu2() {
        System.out.println("1 - Cadastrar novo vendedor");
        System.out.println("2 - Deletar vendedor");
        System.out.printf("0 - Sair");
    }

}
