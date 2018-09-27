package com.thays.vieira;

import java.util.TreeMap;

public class NumerosRomano implements ImprimirReloj {

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
		String representar_romano = conversionRoman(hora) + '\n' + conversionRoman(minutos) + '\n'
				+ conversionRoman(segundos);
		System.out.println(representar_romano);
		return representar_romano;
	}

}
