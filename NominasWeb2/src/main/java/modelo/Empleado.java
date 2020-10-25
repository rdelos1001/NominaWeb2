package modelo;

import tools.DatosNoCorrectosException;
import tools.Validaciones;

/**
 * Esta clase engloba a todos los empleados los cuales heredan atributos de la clase Persona
 * @author Raúl
 *@version 1.0
 */
public class Empleado extends Persona{
	
	/**
	 * Categoria del empleado en cuestión debe estar entre 1 y 10.
	 * */
	private int categoria;
	
	/**
	 * Años de antiguedad del empleado.
	 * */
	public int anyos;
	
	/**
	 * 1er construcctor de la clase empleado este construcctor valida los datos cuando crea el empleado
	 * @param nombre de la persona
	 * @param dni de la persona
	 * @param sexo de la persona
	 * @param categoria del empleado
	 * @param anyos del empleado
	 * */
	public Empleado (String nombre, String dni, char sexo,int categoria, int anyos) 
	{
		super(nombre,dni,sexo);
		try {	
			if(Validaciones.validarCategoria(categoria)) {
				this.categoria=categoria;
			}else {
				throw new DatosNoCorrectosException();
			}
			
			if(Validaciones.validarAnyos(anyos)) {
				this.anyos=anyos;
			}else {
				throw new DatosNoCorrectosException();
			}
			
		}catch(DatosNoCorrectosException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 2er construcctor de la clase empleado este construcctor valida los datos cuando crea el empleado
	 * @param nombre de la persona
	 * @param dni de la persona
	 * @param sexo de la persona
	 * */
	public Empleado (String nombre, String dni, char sexo) 
	{
		super(nombre,dni,sexo);
		this.categoria=1;
		this.anyos=0;
		try {
			
			if(!Validaciones.validarDNI(this.dni)) {
				throw new DatosNoCorrectosException();
			}
			
			if(!Validaciones.validarSexo(this.sexo)) {
				throw new DatosNoCorrectosException();
			}
			
			if(!Validaciones.validarCategoria(this.categoria)) {
				throw new DatosNoCorrectosException();
			}
			
			if(!Validaciones.validarAnyos(this.anyos)) {
				throw new DatosNoCorrectosException();
			}
			
		}catch(DatosNoCorrectosException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * setter del atributo categoria
	 * @param categoria nueva
	 * */
	public void setCategoria(int categoria) 
	{
		this.categoria=categoria;
	}
	
	/**
	 * Getter del atributo categoria
	 * @return categoria actual*/
	public int getCategoria() 
	{
		return this.categoria;
	}
	
	/**
	 * Incrementa los años trabajados en 1
	 * */
	public void incrAnyo() 
	{
		this.anyos++;
	}
	
	/**
	 * Muestra todos los atributos de la persona en cuestión
	 */
	public void imprime() 
	{
		System.out.println("Nombre: "+this.nombre);
		System.out.println("DNI: "+this.dni);
		System.out.println("Sexo: "+this.sexo);
		System.out.println("Categoria: "+this.categoria);
		System.out.println("Años Trabajados: "+this.anyos);
	}
}

