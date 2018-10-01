package com.thays.vieira;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		EjecutablesEnMain ejecutar = new EjecutablesEnMain();

		ejecutar.cargarArchivoProperties();

		ejecutar.imprimirReloj24Horas();

	}
}