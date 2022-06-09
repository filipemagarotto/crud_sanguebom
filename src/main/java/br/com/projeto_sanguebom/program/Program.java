package br.com.projeto_sanguebom.program;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.projeto_sanguebom.jdbc.Conexao;
import br.com.projeto_sanguebom.jdbc.doadorDAO;
import br.com.projeto_sanguebom.model.Doador;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Calendar c1 = Calendar.getInstance();
		int dia = c1.get(Calendar.DAY_OF_MONTH);
		int mes = c1.get(Calendar.MONTH)+1;
		int ano = c1.get(Calendar.YEAR);
		
		int hora = c1.get(Calendar.HOUR_OF_DAY);
		int minuto = c1.get(Calendar.MINUTE);
		
		System.out.println(Integer.toString(dia)+"/"+Integer.toString(mes)+
				"/"+Integer.toString(ano)+" "+Integer.toString(hora)+":"+Integer.toString(minuto));
		
		doadorDAO dao = new doadorDAO();
		List<Doador> lstDoadores = dao.buscarDoadores("12345678909");
		
		for(Doador d : lstDoadores) {
			System.out.println(d.getNome());
		}
	}

}
