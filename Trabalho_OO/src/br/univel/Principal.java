package br.univel;

import java.lang.reflect.Field;
//import java.text.DateFormat.Field;
import java.lang.reflect.Method;

public class Principal {

	public Principal() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {

		Pessoa p = new Pessoa();		
		
		exibirNomeClasse(p);
		exibirNomeAtributos(p);
		exibirValoresAtributos(p);
	}

	private void exibirNomeClasse(Object p) throws ClassNotFoundException {		
		Class<?> clazz = p.getClass();
		System.out.println(clazz.getName() + "\n");					
	}	
	
	private void exibirNomeAtributos(Object p) {
		Class<?> clazz = p.getClass();
		for (Field f : clazz.getDeclaredFields()) {													
			System.out.println(f.getName() + "\n");
		}
	}
		
	private void exibirValoresAtributos(Object p) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = p.getClass();
		
		for (Field f : clazz.getDeclaredFields()) {			
			f.setAccessible(true);							
			Object valor = f.get(p); 				
			System.out.println(f.getName() + "\t" + valor);
		}
	}




	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		new Principal();
	}
}
