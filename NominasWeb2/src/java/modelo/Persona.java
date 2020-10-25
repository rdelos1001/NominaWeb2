package modelo;

import tools.DatosNoCorrectosException;
import tools.Validaciones;

/**
 * Esta clase engloba a todas las personas del programa
 * @author Raúl;
 *
 */
public class Persona {
	
	/** 
	 * Nombre de la persona
	 * */
	public String nombre;
	
	/**
	 * DNI de la persona
	 * */
	public String dni;
	
	/**
	 * Sexo de la persona
	 * */
	public char sexo;
	
	/**
	 * 1er construcctor de la clase persona
	 * @param nombre de la persona
	 * @param dni de la persona
	 * @param sexo de la persona
	 * */
	public Persona (String nombre,String dni,char sexo) {
		this.nombre=nombre;
		try {
			if(Validaciones.validarDNI(dni)) {
				this.dni=dni;
			}else {
				throw new DatosNoCorrectosException();
			}
			
			if(Validaciones.validarSexo(sexo)) {
				this.sexo=sexo;
			}else {
				throw new DatosNoCorrectosException();
			}
		}catch (DatosNoCorrectosException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 2º construcctor de la clase persona
	 * @param nombre de la persona
	 * @param sexo de la persona
	 * */
	public Persona (String nombre,char sexo) {
		this.nombre=nombre;
		try {
			if(Validaciones.validarSexo(this.sexo)) {
				this.sexo=sexo;
			}else {
				throw new DatosNoCorrectosException();
			}
		}catch (DatosNoCorrectosException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Cambia el valor del dni por otro
	 * @param dni El nuevo dni
	 * */
	public void setDni (String dni) {
		this.dni=dni;
	}
	/**
	 * Muestra por pantalla el nombre y el dni de la persona correspondiente
	 * */
	public void imprime() {
		System.out.println("Nombre: "+this.nombre);
		System.out.println("DNI: "+this.dni);
	}
}