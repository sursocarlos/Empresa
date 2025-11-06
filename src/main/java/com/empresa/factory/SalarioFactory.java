package com.empresa.factory;

import com.empresa.strategy.*;

public class SalarioFactory {
	public static EstrategiaSalario getEstrategia(String tipo) {
		switch (tipo) {
		case "categoriaYAnos":
			return new SalarioPorCategoriaYEanos();
		default:
			throw new IllegalArgumentException("Tipo de estrategia no válido");
		}
	}
}
