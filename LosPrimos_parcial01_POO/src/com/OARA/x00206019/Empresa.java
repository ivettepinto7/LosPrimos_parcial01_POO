package com.OARA.x00206019;

import java.util.ArrayList;
public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }
    public void addEmpleado(Empleado pers1){
        planilla.add(pers1);
    }
    public void quitEmpleado(String nombre)throws NotExistingEmployeeException{
    //
        if(!planilla.removeIf(obj -> {
            return (obj.getNombre()).equalsIgnoreCase(nombre);
        })){
            throw new NotExistingEmployeeException("El Empleado"+nombre+" no existe.");
        }

    }
}
