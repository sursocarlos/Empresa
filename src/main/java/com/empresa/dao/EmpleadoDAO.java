package com.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empresa.conexion.Conexion;
import com.empresa.empleados.Empleados;

public class EmpleadoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	// guardar empleado
	public boolean guardar(Empleados empleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO empleados (dni, nombre, sexo, categoria, anyos) VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, empleado.getDni());
			statement.setString(2, empleado.getNombre());

			statement.setString(3, String.valueOf(empleado.getSexo()));

			/* PRUEBA */
			/*
			 * System.out.println("Valor que se va a insertar en sexo: '" +
			 * String.valueOf(empleado.getSexo()) + "'"); statement.setString(3,
			 * String.valueOf(empleado.getSexo()));
			 */
			/* PRUEBA */

			statement.setInt(4, empleado.getCategoria());
			statement.setInt(5, empleado.getAnyos());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// editar empleado
	public boolean editar(Empleados empleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE empleados SET nombre=?, sexo=?, categoria=?, anyos=? WHERE dni=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, empleado.getNombre());
			statement.setString(2, String.valueOf(empleado.getSexo()));
			statement.setInt(3, empleado.getCategoria());
			statement.setInt(4, empleado.getAnyos());
			statement.setString(5, empleado.getDni());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// eliminar empleado
	public boolean eliminar(String dni) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM empleados WHERE dni=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener lista de empleados
	public List<Empleados> obtenerEmpleados() throws SQLException {
		ResultSet resultSet = null;
		List<Empleados> listaEmpleados = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM empleados";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Empleados em = new Empleados();
				em.setDni(resultSet.getString(1));
				em.setNombre(resultSet.getString(2));
				em.setSexo(resultSet.getString(3).charAt(0));
				em.setCategoria(resultSet.getInt(4));
				em.setAnyos(resultSet.getInt(5));
				listaEmpleados.add(em);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaEmpleados;
	}

	// obtener empleado METODO ORIGINAL
	public Empleados obtenerEmpleado(String dni) throws SQLException {
		ResultSet resultSet = null;
		Empleados em = new Empleados();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM empleados WHERE dni = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				em.setDni(resultSet.getString(1));
				em.setNombre(resultSet.getString(2));
				em.setSexo(resultSet.getString(3).charAt(0));
				em.setCategoria(resultSet.getInt(4));
				em.setAnyos(resultSet.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return em;
	}
	

	
	// obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	public int calcularSalario(Empleados emp) {
		return SUELDO_BASE[emp.getCategoria() - 1] + emp.getAnyos() * 5000;
	}

}
