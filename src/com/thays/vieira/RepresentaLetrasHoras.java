package com.thays.vieira;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepresentaLetrasHoras implements Reloj  {
	public static final String LUCES_APAGADAS = "O ";
	public static final String LUCES_ROJAS = "R ";
	public static final String LUCES_AMARILLAS = "Y ";
	public static final int PRIMERAFILA = 1;
	public static final int FILAMEDIANA = 4;
	public static final int FILAGRANDE = 11;

	public  int division(int horario) {
		int resultado;
		resultado = horario / 5;
		return resultado;
	}

	public int modulo(int horario) {
		int resultado;
		resultado = horario % 5;

		return resultado;
	}

	public  int segundos(int horario) {
		int resultado;
		resultado = horario % 60;

		return resultado;
	}

	public  String concatenarLetras(int iteraciones, int pos, String color) {
		String fila = new String();
		for (int i = 0; i < pos; i++) {

			if (iteraciones > i) {

				fila += color;
			} else
				fila += LUCES_APAGADAS;

		}
		return fila;
	}

	public  String colorTercerFila(int iteraci) {
		String fila = new String();
		for (int a = 1; a <= FILAGRANDE; a++) {

			if (iteraci >= a) {
				if (a % 3 == 0) {
					fila += LUCES_ROJAS;
				} else
					fila += LUCES_AMARILLAS;
			} else {
				fila += LUCES_APAGADAS;
			}

		}
		return fila;
	}

	@Override
	public String imprimirHoras(int segundos, int hora, int minutos) {
		String representar_berlin;

		representar_berlin = concatenarLetras(segundos(segundos), PRIMERAFILA,
				LUCES_AMARILLAS)
				+ "\n"
				+ concatenarLetras(division(hora), FILAMEDIANA,
						LUCES_ROJAS)
				+ "\n"
				+ concatenarLetras(modulo(hora), FILAMEDIANA,
						LUCES_ROJAS)
				+ "\n" + colorTercerFila(division(minutos)) + "\n"
				+ concatenarLetras(modulo(minutos),FILAMEDIANA,
						LUCES_AMARILLAS)
				+ "\n";
		System.out.println(representar_berlin);
		return representar_berlin;
	}

}
