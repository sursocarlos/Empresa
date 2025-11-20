package com.empresa.observer;

import com.empresa.empleados.Empleados;

/*
 * El patrón Observer me permite registrar automáticamente todas las acciones importantes sobre los
 * empleados, como crear, editar o consultar el salario. Cada vez que se realiza una de estas acciones,
 * EmpleadoSubject notifica al observador (EmpleadoLogger) y se guarda un registro en un archivo de logs en
 * el escritorio. Esto facilita auditar o depurar el programa, porque tengo un historial de lo que se ha hecho sin
 * tener que escribir manualmente código adicional en cada operación.
 * */


/*
 * 
 * Es una interfaz que define un contrato: cualquier clase que “observe” cambios en empleados debe implementar el método actualizar().
 * 
 * actualizar() recibe un objeto Empleado y una descripción de la acción (accion).
 * 
 * */


public interface Observer {
	void actualizar(Empleados empleado, String accion);
}


