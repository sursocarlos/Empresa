package com.empresa.strategy;

import com.empresa.empleados.Empleados;

public class SalarioPorCategoriaYEanos implements EstrategiaSalario {
	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	@Override
	public int calcularSalario(Empleados emp) {
		return SUELDO_BASE[emp.getCategoria() - 1] + emp.getAnyos() * 5000;
	}
}
