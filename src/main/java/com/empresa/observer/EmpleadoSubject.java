package com.empresa.observer;

import com.empresa.empleados.Empleados;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoSubject {
	/*
	 * List<Observer> observadores: mantiene todas las clases que quieren ser notificadas de cambios en empleados.
	 * */
	
	private List<Observer> observadores = new ArrayList<>();

	
	/*
	 * agregarObservador(Observer obs): permite registrar nuevos observadores (como EmpleadoLogger).
	 * */
	public void agregarObservador(Observer obs) {
		observadores.add(obs);
	}

	
	/*
	 * notificar(Empleados emp, String accion): recorre todos los observadores y llama a su método actualizar().
	 * */
	public void notificar(Empleados emp, String accion) {
		for (Observer obs : observadores) {
			obs.actualizar(emp, accion);
		}
	}
}
