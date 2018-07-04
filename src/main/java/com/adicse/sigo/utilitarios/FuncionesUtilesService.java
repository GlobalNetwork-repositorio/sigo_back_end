package com.adicse.sigo.utilitarios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FuncionesUtilesService {
	
	public String getHoraActual () {
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");		
		return hourFormat.format(date);
	}
	
	public Date getFechaActual () {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date fechaActual = date;		
		try {
			fechaActual = dateFormat.parse(dateFormat.format(date));			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fechaActual;
	}
}
