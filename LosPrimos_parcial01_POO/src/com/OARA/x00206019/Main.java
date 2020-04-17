package com.OARA.x00206019;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//excepcion de salario negativo
        int op,op2;
        String nombreEmp, puestoEmp, numeroEmp;
        double salarioEmp;

        String nombre=JOptionPane.showInputDialog(null,"Ingrese el nombre de la empresa: ");
        Empresa empresa1 = new Empresa(nombre);
    do{
        op=Integer.parseInt(menu(empresa1.getNombre()));
        switch (op){
            case 1:
                try{
                op2=Integer.parseInt(JOptionPane.showInputDialog(null,"Tipo de empleado:" +
                        "1. Servicio Profesional\n2.Plaza Fija"));
                    if(op2==1){
                        String mesesContrato= JOptionPane.showInputDialog(null,"Meses de contrato:");
                    }else if(op2==2){
                        String extension= JOptionPane.showInputDialog(null,"Extension del empleado:");
                    }else{
                        throw new NotExistingEmployeeTypeException("El tipo de empleado no es valido");
                    }
                nombreEmp=JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
                nombreEmp=JOptionPane.showInputDialog(null,"Ingrese el puesto: ");
                salarioEmp=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el salario: "));
                }catch(NotExistingEmployeeTypeException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                break;
            case 2:
            break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida!");
                break;

        }
    }while(op!=0);

    }
    public static String menu(String nombre){
        return ("Empresa"+ nombre+"\n1. Agregar empleado\n2. Despedir empleado\n3. Ver lista de empleados\n" +
                "4. Calcular sueldo\n5.Mostrar totales\n0. Salir");
    }
}
