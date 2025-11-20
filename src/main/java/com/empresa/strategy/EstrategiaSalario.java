package com.empresa.strategy;

import com.empresa.empleados.Empleados;

/*
 * El patrón Strategy me permite definir diferentes formas de calcular el salario sin modificar el código del
 * servlet. En mi caso uso SalarioPorCategoriaYEanos, pero podría agregar otra estrategia fácilmente. Gracias
 * a esto, el código es más flexible y reutilizable, y puedo cambiar la lógica de cálculo de salario sin tocar el
 * flujo principal del FrontController.
 * */


public interface EstrategiaSalario {
	int calcularSalario(Empleados emp);
}
