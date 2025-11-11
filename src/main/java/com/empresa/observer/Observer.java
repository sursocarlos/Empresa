package com.empresa.observer;

import com.empresa.empleados.Empleados;

public interface Observer {
	void actualizar(Empleados empleado, String accion);
}
