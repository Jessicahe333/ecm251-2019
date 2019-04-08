package com.company;

public class Main {

    public static void main(String[] args) {
	Usuarios u1 = new Usuarios("Karina","karinalumi9@gmail.com","17.00709-7","29/12/1998");
	Debito d1 = new Debito(439,46223,607,"Caixa","05/2016","10/24","Visa",12456);
	Usuarios u2 = new Usuarios("Jessica","jessicahe333@hotmail.com","17.00670-8","13/03/2019");
	Debito d2 = new Debito(487,48972,498,"Bradesco","08/15","12/21","Visa",78912);
	Credito c1 = new Credito(459,78152,564,"Itaú","03/17","06/25,","Master",16465);
	Carteiras ca1 = new Carteiras("Kaka",1238,d1,null);
	Carteiras ca2 = new Carteiras("Je",9854,d2,c1);
    ca2.pagar(200,d2,78912);
    }

}
