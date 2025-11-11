package com.empresa.observer;

import com.empresa.empleados.Empleados;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoSubject {
	private List<Observer> observadores = new ArrayList<>();

	public void agregarObservador(Observer obs) {
		observadores.add(obs);
	}

	public void notificar(Empleados emp, String accion) {
		for (Observer obs : observadores) {
			obs.actualizar(emp, accion);
		}
	}
}
