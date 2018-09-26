package com.thays.vieira;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepresentaLetrasHoras implements Formato {
	public static final String LUCES_APAGADAS = "O ";
	public static final String LUCES_ROJAS = "R ";
	public static final String LUCES_AMARILLAS = "Y ";
	public static final int PRIMERAFILA = 1;
	public static final int FILAMEDIANA = 4;
	public static final int FILAGRANDE = 11;

	public int division(int horario) {
		int resultado;
		resultado = horario / 5;
		return resultado;
	}

	public int modulo(int horario) {
		int resultado;
		resultado = horario % 5;

		return resultado;
	}

	public int segundos(int horario) {
		int resultado;
		resultado = horario % 60;

		return resultado;
	}

	@Override
	public String imprimirHoras(int segundos, int hora, int minutos) {
		String representar;

		representar = concatenarLetras(segundos(segundos), RepresentaLetrasHoras.PRIMERAFILA,
				RepresentaLetrasHoras.LUCES_AMARILLAS) + "\n"
				+ concatenarLetras(division(hora), RepresentaLetrasHoras.FILAMEDIANA, RepresentaLetrasHoras.LUCES_ROJAS)
				+ "\n"
				+ concatenarLetras(modulo(hora), RepresentaLetrasHoras.FILAMEDIANA, RepresentaLetrasHoras.LUCES_ROJAS)
				+ "\n" + colorTercerFila(division(minutos)) + "\n" + concatenarLetras(modulo(minutos),
						RepresentaLetrasHoras.FILAMEDIANA, RepresentaLetrasHoras.LUCES_AMARILLAS)
				+ "\n";
		System.out.println(representar);
		return representar;
	}

	public String concatenarLetras(int iteraciones, int pos, String color) {
		String fila = new String();
		for (int i = 0; i < pos; i++) {

			if (iteraciones > i) {

				fila += color;
			} else
				fila += LUCES_APAGADAS;

		}
		return fila;
	}

	public String colorTercerFila(int iteraci) {
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
	public boolean validaciones(String entradaDatos) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

		Matcher m = p.matcher(entradaDatos);
		String delimiter = ":";
		String[] salida = entradaDatos.split(delimiter);

		if (m.find()) {

			for (int j = 0; j < salida.length; j++)
				System.out.println(salida[j]);
			int numero = Integer.parseInt(salida[0]);
			int numero1 = Integer.parseInt(salida[0]);
			int numero2 = Integer.parseInt(salida[1]);
			System.out.println("==========Reloj Berlin=========");
			imprimirHoras(numero, numero1, numero2);
			return true;

		}
		System.out.println("Caracteres inadecuado");
		return false;
	}

	@Override
	public void introducirDatos() {
		// TODO Auto-generated method stub
		int i = 0;
		String entradaDatos;
		boolean datosCorrectos = false;
		try {
			while (!datosCorrectos) {
				i++;
				Scanner sc = new Scanner(System.in);

				System.out.println("Escriba horas, minutos, segundos. Formato(HH:mm:ss): ");
				entradaDatos = sc.nextLine();
				datosCorrectos = validaciones(entradaDatos);

			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
