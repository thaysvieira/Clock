package com.thays.vieira;

import java.util.TreeMap;

public class NumerosRomano  implements Relojes {

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



	public String concatenarHoras(int segundos, int hora, int minutos) {
		String representar_romano = conversionRoman(hora) + '\n' + conversionRoman(minutos) + '\n'
				+ conversionRoman(segundos);
		System.out.println("==========Reloj Romano=========");
		return representar_romano;
	}
	
	private String conversionRoman(int entrada) {
		int numerosNaturales = NUMEROS_ROMANOS.floorKey(entrada);
		if (entrada == numerosNaturales) {
			return NUMEROS_ROMANOS.get(entrada);
		}

		return NUMEROS_ROMANOS.get(numerosNaturales) + conversionRoman(entrada - numerosNaturales);
	}


	

}
