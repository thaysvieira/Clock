package com.thays.vieira;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RelojeService reloj = new RelojeService();
		Scanner sc = new Scanner(System.in);
		String entradaDatos, orden;
		
	
		System.out.println("Ingresar conjunto de horas HH:mm:ss|HH:mm:ss|HH:mm:ss: ");
		entradaDatos = sc.nextLine();
	    reloj.verificarFormatoHoras(entradaDatos);
		System.out.println("Para ordenar de manera [asc] y [desc]");
		orden = sc.nextLine();
		reloj.ordenar(entradaDatos, orden);
		System.out.println("Ingresar horas para buscar: ");
		entradaDatos = sc.nextLine();
		reloj.verificarFormatoHoras(entradaDatos);
		reloj.comprobarBusqueda(entradaDatos);
		reloj.imprimirHoras(entradaDatos);

	}
}
