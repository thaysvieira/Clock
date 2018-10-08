package com.thays.vieira;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClockService {

	ConversorHora conversorHoras = null;
	private List<String> horas;

	public ClockService() {

		this.horas = new ArrayList<String>(); // Lo pongo como ArrayList y no como un vector a fin de que en un futuro
												// pueda admitir más de 3 entradas

		String tipoConversor = extraerDeArchivoProperties("formatoSalidaHora");

		if (tipoConversor.equals(ConversorHora.FORMATO_BERLIN))
			conversorHoras = new ConversorRelojBerlin();
		else if (tipoConversor.equals(ConversorHora.FORMATO_ROMANO))
			conversorHoras = new ConversorRelojRomano();
		else
			System.out.println("No se ha configurado bien el tipo de reloj");

	}

	private String extraerDeArchivoProperties(String property) {

		String ret = null;
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src/com/thays/vieira/config.properties");
			prop.load(input);

			ret = prop.getProperty(property);

		} catch (IOException ex) {
			System.err.println("Error al extraer del archivo");
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return ret;
	}

	public boolean entradaHoras(String entradaDatos) {

		List<String> horasSeparadas = Arrays.asList(entradaDatos.split("\\|"));

		if (verificarFormatoHoras(horasSeparadas))
			this.horas = horasSeparadas;
		else {
			System.err.println("Entrada de datos incorrecta");
			return false;
		}

		return true;
	}

	private boolean verificarFormatoHoras(List<String> entradaDatos) {

		boolean ret = true;

		if (entradaDatos.size() < 3) {
			System.err.println("Error: no son 3 horas");
			ret = false;
		} else {
			for (String hora : entradaDatos) {
				if (!verificarFormatoHora(hora))
					ret = false;

			}
		}
		return ret;
	}

	private boolean verificarFormatoHora(String hora) {

		// Pattern p =
		// Pattern.compile("^((([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9]):([0-5]?[0-9]))?$");
		Pattern p = Pattern.compile(extraerDeArchivoProperties("expresionRegularParaValidarLaHora"));

		Matcher m = p.matcher(hora);

		return m.matches();

	}

	private boolean comprobarBusqueda(String horaABuscar) {

		if (verificarFormatoHora(horaABuscar)) {
			return this.horas.contains(horaABuscar);
		}

		return false;
	}

	public boolean ordenar(String orden) {
		boolean entradaCorrecta = false;

		switch (orden) {
		case "asc":
			Collections.sort(this.horas);
			entradaCorrecta = true;
			break;
		case "desc":
			Collections.sort(this.horas, Collections.reverseOrder());
			entradaCorrecta = true;
			break;
		default:
		}

		if (entradaCorrecta)
			System.out.println(this.horas);
		else
			System.out.println("No has ingresado el valor correcto");

		return entradaCorrecta;
	}

	public boolean imprimirHora(String horaABuscar) {

		boolean correcto = comprobarBusqueda(horaABuscar);

		if (correcto) {
			int horas, minutos, segundos;
			String delimitar = "[:]";
			String salida[] = horaABuscar.split(delimitar);

			horas = Integer.parseInt(salida[2]);
			minutos = Integer.parseInt(salida[0]);
			segundos = Integer.parseInt(salida[1]);

			System.out.println(conversorHoras.convertirHora(horas, minutos, segundos));

		} else {
			System.err.println("La hora buscada no se encuentra en el sistema, o no tiene el formato adecuado");
		}

		return correcto;

	}

}
