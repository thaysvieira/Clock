package com.thays.vieira;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Propiedades {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("configu.properties");

			// set the properties value
			prop.setProperty("formatoSalidaHora", "Romano");
			prop.setProperty("expresionRegularParaValidarLaHora", "^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

// "C:\\Users\\tvieirda\\eclipse-workspace\\Relojes\\src\\com\\thays\\berlin\\config.properties"
