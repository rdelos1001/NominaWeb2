package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetInfo {
	/**
	 * Url del driver que se desea cargar
	 * */
	private static final String URLDRIVER="com.mysql.cj.jdbc.Driver";
	
	/**
	 * Url de la base de datos
	 * */
	private static final String URLDB="jdbc:mysql://localhost:3306/nominaWeb";
	
	/**
	 * Nombre de usuario
	 * */
	private static final String USER="root";
	
	/**
	 * Contraseña
	 * */
	private static final String PASSWORD="";

	/**
	 * Obtiene el sueldo del empleado recibido
	 * @return devuelve el sueldo como número entero
	 * @param epleado empleado de quien se quiere conseguir su sueldo
	 * */
	public static int getSueldo(Empleado empleado) {
		int sueldo = 0;
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			Class.forName(URLDRIVER);
			conn=DriverManager.getConnection(URLDB,USER,PASSWORD);
			ps=conn.prepareStatement("Select sueldo from nomina where dni='"+empleado.dni+"'");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				sueldo=rs.getInt(1);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return sueldo;
	}
	
	/**
	 * Método que recibiendo un arrayList de datos devuelve un arrayList de empleado que correspondan con esos datos
	 * @param datos datos del empleado de quien se quiere buscar
	 * @return devuelve un arrayList de los empleados que correspondan con los datos recibidos
	 * */
	public static ArrayList<Empleado> getEmpleados(ArrayList<String>datos) {
		if(datos==null) {
			datos=new ArrayList<String>();
		}
		ArrayList<Empleado> listEmpleado=new ArrayList<Empleado>();
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		//Este bucle while hace que el arrayList de datos tenga 5 de tamaño
		while(datos.size()<5) {
			datos.add("");
		}
		
		//Este bucle for sustituye los valores por aquello que haga que la sentencia SQL funcione
		for(int i=0;i<datos.size();i++) {
			if(datos.get(i).equals("")) {
				datos.set(i, " like '%' ");
			}else {
				datos.set(i, " = '"+datos.get(i)+"' "); ;
			}
		}
				
		try {
			Class.forName(URLDRIVER);
			conn=DriverManager.getConnection(URLDB,USER,PASSWORD);
			ps=conn.prepareStatement("Select * from empleado where nombre "+datos.get(0)+" and dni "+datos.get(1)+
					" and sexo "+datos.get(2)+ " and categoria "+datos.get(3)+" and anyos "+datos.get(4));
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nombre=rs.getString(1);
				String dni=rs.getString(2);
				String sexo=rs.getString(3);
				int categoria=rs.getInt(4);
				int anyos=rs.getInt(5);
				Empleado empleado = new Empleado(nombre,dni,sexo.charAt(0),categoria,anyos);
				listEmpleado.add(empleado);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return listEmpleado;
	}
}
