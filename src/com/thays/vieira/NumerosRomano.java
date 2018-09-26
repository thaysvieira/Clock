package com.thays.vieira;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumerosRomano implements Formato {
	// TreeMap está ordenando las claves por orden natural.

	// TreeMap está ordenando las claves por orden natural.

	private final static TreeMap<Integer, String> NUMEROS_ROMANOS = new TreeMap<Integer, String>();

	static {
		NUMEROS_ROMANOS.put(1000, "M");
		NUMEROS_ROMANOS.put(900, "CM");
		NUMEROS_ROMANOS.put(500, "D");
		NUMEROS_ROMANOS.put(400, "CD");
		NUMEROS_ROMANOS.put(100, "C");
		NUMEROS_ROMANOS.put(90, "XC");
		NUMEROS_ROMANOS.put(50, "L");
		NUMEROS_ROMANOS.put(40, "XL");
		NUMEROS_ROMANOS.put(10, "X");
		NUMEROS_ROMANOS.put(9, "IX");
		NUMEROS_ROMANOS.put(5, "V");
		NUMEROS_ROMANOS.put(4, "IV");
		NUMEROS_ROMANOS.put(1, "I");
		NUMEROS_ROMANOS.put(0, "0");

	}

	/*
	 * El método TreeMap # floorKey tiene un papel vital en esta solución, ya que
	 * puede buscar la clave más grande, menor o igual que la clave dada. Si hay una
	 * coincidencia exacta,devuelve el símbolo romano asociado
	 */

	public static String conversionRoman(int entrada) {
		int num = NUMEROS_ROMANOS.floorKey(entrada);
		if (entrada == num) {
			return NUMEROS_ROMANOS.get(entrada);
		}

		return NUMEROS_ROMANOS.get(num) + conversionRoman(entrada - num);

	}

	@Override
	public String imprimirHoras(int segundos, int hora, int minutos) {
		// TODO Auto-generated method stub
		String romano = conversionRoman(hora) + '\n' + conversionRoman(minutos) + '\n' + conversionRoman(segundos);
		System.out.println(romano);
		return romano;
	}

	public boolean validaciones(String entradaDatos) {
		Pattern p = Pattern.compile("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

		Matcher m = p.matcher(entradaDatos);
		String delimiter = ":";
		String[] salida = entradaDatos.split(delimiter);

		if (m.find()) {

			for (int j = 0; j < salida.length; j++)
				System.out.println(salida[j]);
			int num2 = Integer.parseInt(salida[2]);
			int num3 = Integer.parseInt(salida[0]);

			int num1 = Integer.parseInt(salida[1]);

		
			System.out.println("==========Reloj Romano=========");
			imprimirHoras(num2, num3, num1);
			return true;

		}
		System.out.println("caracter inadecuado");

		return false;
	}

	@Override
	public void introducirDatos() {

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
