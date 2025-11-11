package com.empresa.observer;

import com.empresa.empleados.Empleados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmpleadoLogger implements Observer {

    private static final String ESCRITORIO = System.getProperty("user.home") + File.separator + "Desktop";
    private static final String CARPETA_LOGS = ESCRITORIO + File.separator + "Logs";
    private static final String ARCHIVO_LOG = CARPETA_LOGS + File.separator + "empleados_log.txt";

    @Override
    public void actualizar(Empleados empleado, String accion) {
        try {
            // Crear carpeta Logs si no existe
            File carpeta = new File(CARPETA_LOGS);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Crear FileWriter en modo append
            FileWriter writer = new FileWriter(ARCHIVO_LOG, true);

            // Fecha y hora actual
            LocalDateTime ahora = LocalDateTime.now();
            String fecha = ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Escribir log
            writer.write(fecha + " - Acción: " + accion + " sobre empleado DNI: " + empleado.getDni() + "\n");

            writer.close();

            System.out.println("Log guardado correctamente en: " + ARCHIVO_LOG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
