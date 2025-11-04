package com.empresa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.dao.EmpleadoDAO;
import com.empresa.empleados.Empleados;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla empleados", urlPatterns = { "/empleados" })
public class EmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("listar")) {

			EmpleadoDAO DAO = new EmpleadoDAO();
			List<Empleados> lista = new ArrayList<>();
			try {
				lista = DAO.obtenerEmpleados();
				for (Empleados empleado : lista) {
					System.out.println(empleado);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted ha presionado la opción listar");
		} else if (opcion.equals("editar")) {
			String dni = request.getParameter("dni");
			System.out.println("Editar dni: " + dni);
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			Empleados em = new Empleados();
			try {
				em = empleadoDAO.obtenerEmpleado(dni);
				System.out.println(em);
				request.setAttribute("empleado", em);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("eliminar")) {
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			String dni = request.getParameter("dni");
			try {
				empleadoDAO.eliminar(dni);
				System.out.println("Registro eliminado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		

		if (opcion.equals("guardar")) {
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			Empleados empleado = new Empleados();
			 empleado.setDni(request.getParameter("dni"));
		     empleado.setNombre(request.getParameter("nombre"));
		     
		     empleado.setSexo(request.getParameter("sexo").charAt(0));
		     
		     empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		     empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
		     
		     String sexoStr = request.getParameter("sexo").trim();
		     System.out.println("Sexo recibido del formulario: '" + sexoStr + "'");
		     empleado.setSexo(sexoStr.charAt(0));
		     
			
			try {
				empleadoDAO.guardar(empleado);
				System.out.println("Registro guardado satisfactoriamente...");
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
	            requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("editar")) {
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	        Empleados empleado = new Empleados();

	        empleado.setDni(request.getParameter("dni"));
	        empleado.setNombre(request.getParameter("nombre"));
	        empleado.setSexo(request.getParameter("sexo").charAt(0));
	        empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
	        empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
			try {
				empleadoDAO.editar(empleado);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// doGet(request, response);
	}

}