package com.thays.vieira;

import java.util.regex.Pattern;

public interface Relojes {

	String concatenarHoras(int segundos, int hora, int minutos);

	String FORMATO_SALIDAHORA = "formatoSalidaHora";
	String HORARIO_BERLIN = "Berlin";
	String HORARIO_ROMANO = "Romano";

	Pattern p = Pattern.compile("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

}
