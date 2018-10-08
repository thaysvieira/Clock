package com.thays.vieira;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ClockService clockService = new ClockService();
		Scanner sc = new Scanner(System.in);
		boolean ret;

		do {
			System.out.println("Ingresar conjunto de horas HH:mm:ss|HH:mm:ss|HH:mm:ss: ");
			ret = clockService.entradaHoras(sc.nextLine());
		} while (!ret);

		do {
			System.out.println("Para ordenar de manera [asc] y [desc]");
			ret = clockService.ordenar(sc.nextLine());
		} while (!ret);
		
		do {
			System.out.println("Ingresar horas para buscar: ");
			ret=clockService.imprimirHora(sc.nextLine());
		} while (!ret);
		sc.close();

	}
}
