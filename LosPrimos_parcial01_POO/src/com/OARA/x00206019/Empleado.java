package com.OARA.x00206019;
import java.util.ArrayList;
abstract class Empleado {
    protected String nombre, puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    public void addDocumento(Documento doc){
    documentos.add(doc);
    }
    public void removeDocumento(String nombre){
        documentos.removeIf(obj->{return (obj.getNombre()).equalsIgnoreCase(nombre);});
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}