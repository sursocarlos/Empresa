package com.empresa.factory;

import com.empresa.strategy.*;


/*
* En mi proyecto, el uso del patrón Factory me da la ventaja de tener un código más limpio y flexible.
* Ya no necesito preocuparme por crear los objetos de cálculo de salario directamente con new, sino que la propia
* fábrica (SalarioFactory) se encarga de decidir qué estrategia devolver según el tipo que le indique. Esto
* facilita mantener y ampliar el proyecto, porque si en el futuro quiero agregar nuevas formas de calcular el
* salario, solo tendría que modificar la fábrica y no todas las partes del código donde se calcula el salario.
*/


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
