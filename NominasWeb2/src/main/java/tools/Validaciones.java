package tools;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Esta clase comprueba si los datos recibidos son correctos
 * @author Raúl
 *
 */
public class Validaciones {

	/**
	 * Comprueba si el sexo introducido es correcto
	 * @param sexo Sexo introducido
	 * @return <ul>
	 * 				<li>True: El sexo es correcto</li>
	 * 				<li>False: El sexo es incorrecto</li>
	 * 		   </ul>
	 */
	public static boolean validarSexo(char sexo) 
	{
		boolean check;
		Pattern p =Pattern.compile("^[HM]$");
		Matcher m=p.matcher(Character.toString(sexo));
		check =m.matches();
		return check;
	}
	
	/**
	 * Este Método comprueba si un dni recibido es correcto o no.
	 * @param dni DNI sometido a prueba.
	 * @return <ul>
	 * 				<li>True: El DNI es correcto</li>
	 * 				<li>False: El DNI es incorrecto</li>
	 * 		   </ul>
	 */
	public static boolean validarDNI(String dni) 
	{
		boolean check=false;
		Pattern p=Pattern.compile("\\d{8}[A-Z]");
		Matcher m = p.matcher(dni);
		check=m.matches();
		return check;
	}
	
	/**
	 * Este método sirve para comprobar la validez de año
	 * @param anyos
	 * @return <ul>
	 * 				<li>True: El año es correcto</li>
	 * 				<li>False: El año es incorrecto</li>
	 * 		   </ul>
	 */
	public static boolean validarAnyos(int anyos) 
	{
		boolean check=false;
		if (anyos>=0) 
		{
			check=true;
		}
		return check;
	}
	
	/**
	 * Este método comprueba la validez de la categoria recibida
	 * @param categoria
	 * @return <ul>
	 * 				<li>True: El año es correcto</li>
	 * 				<li>False: El año es incorrecto</li>
	 * 		   </ul>
	 */
	public static boolean validarCategoria(int categoria) 
	{
		boolean check=false;
		if (categoria>=1&&categoria<=10) 
		{
			check=true;
		}
		return check;
	}
}
