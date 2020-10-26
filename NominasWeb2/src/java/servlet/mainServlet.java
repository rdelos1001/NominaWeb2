package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Empleado;
import modelo.GetInfo;

/**
 * Servlet implementation class mainServlet
 */
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int action=0;
		
		if(request.getParameter("action")!="") {
			action=Integer.parseInt(request.getParameter("action"));
		}
		String path="";
		ArrayList<Empleado>listEmpleados= new ArrayList<Empleado>();
		ArrayList<String> datos= new ArrayList<String>();
		switch(action) {
		case 1:
			listEmpleados=modelo.GetInfo.getEmpleados(null);
			request.setAttribute("listEmpleados", listEmpleados);
			path="MostrarTodoEmpleado.jsp";
			break;
		case 2:
			path="PedirDNI.jsp";
			break;
		case 3:
			path="SeleccionaEmpleado.jsp";
			break;
			
		//Proviene PedirDNI.jsp
		case 4:
			String dni=request.getParameter("dni");
			datos.add("");
			datos.add(dni);
			Empleado empleado = GetInfo.getEmpleados(datos).get(0);			
			int sueldo=GetInfo.getSueldo(empleado);
			request.setAttribute("sueldo", sueldo);
			request.setAttribute("empleado", empleado);
			path="MostrarSueldo.jsp";
			break;
			
		//Proviene de SeleccionaEmpleado.jsp
		case 5:
			String nombre=request.getParameter("nombre");
			dni = request.getParameter("dni");
			String sexo= request.getParameter("sexo");
			String categoria= request.getParameter("categoria");
			String anyo = request.getParameter("anyo");
			datos.add(nombre);
			datos.add(dni);
			datos.add(sexo);
			datos.add(categoria);
			datos.add(anyo);
			listEmpleados= GetInfo.getEmpleados(datos);
			request.setAttribute("listEmpleados", listEmpleados);
			path="MostrarTodoEmpleado.jsp";
			break;
			
		default:
			path="Error404.jsp";
			break;
		}
		datos.clear();
		request.getRequestDispatcher(path).forward(request, response);
	}
}
