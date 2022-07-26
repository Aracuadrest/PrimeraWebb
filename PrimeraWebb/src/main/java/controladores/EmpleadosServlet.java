package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/datosEmpleados")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmpleadosServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		UtilidadesServlet.imprimirCabecera("Datos", out);
		String nombre= request.getParameter("nombre");
		String apellidos= request.getParameter("apellidos");
		String provincia=request.getParameter("provincia");
		String[] conocimientos=request.getParameterValues("conocimientos[]");
		String fecha=request.getParameter("fecha");
		int experiencia=Integer.parseInt(request.getParameter("experiencia"));
		
		out.println("<h2> Datos introducidos </h2>");
		out.println("<ul>");
		out.println("<li> Nombre: "+nombre+"</li>");
		out.println("<li> Apellidos: "+apellidos+"</li>");
		out.println("<li> Cod. Provincia: "+provincia+"</li>");
	
		out.println("<li> Conocimientos: ");
		if (conocimientos ==null || conocimientos.length==0) {
			out.println("No hay conocimientos marcados </li>");
		}else {
			out.println("<ul>");
			for (String c : conocimientos) {
				out.println("<li>"+c+"</li>");
				
			}out.println("</ul>");
			out.println("</li>");
		}
			
		out.println("<li> Fecha nacimiento: "+fecha+"</li>");
		out.println("<li> Experiencia(años): "+experiencia+"</li>");
		out.println("</ul>");
		
		UtilidadesServlet.imprimirPie(out);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
