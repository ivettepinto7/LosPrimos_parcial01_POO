package com.OARA.x00206019;
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//excepcion de salario negativo
        int op,op2;
        Empresa empresa1 = new Empresa("Los Primos");
    do{
        String nombreEmp="", puestoEmp="", numeroEmp="";
        double salarioEmp=0;
        try {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu(empresa1.getNombre())));
        }catch(NumberFormatException|NullPointerException ex){
            op=9;
        }
        switch (op) {
            case 1://Agregar empleado
                try {
                    while (nombreEmp.equalsIgnoreCase(""))
                        nombreEmp = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                    while (puestoEmp.equalsIgnoreCase(""))
                        puestoEmp = JOptionPane.showInputDialog(null, "Ingrese el puesto: ");
                    while (salarioEmp <= 0)
                        salarioEmp = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario: "));
                    op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de empleado:" +
                            "\n1. Servicio Profesional\n2.Plaza Fija"));
                    if (op2 == 1) {
                        int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Meses de contrato:"));
                        ServicioProfesional persona = new ServicioProfesional(nombreEmp, puestoEmp, salarioEmp, mesesContrato);
                        empresa1.addEmpleado(persona);
                        int jop=1;
                        while(jop!=0) {
                            String nomb = JOptionPane.showInputDialog(null, "Documento\nnombre:");
                            String num = JOptionPane.showInputDialog(null, "Documento\nnumero:");
                            Documento docs = new Documento(nomb, num);
                            persona.addDocumento(docs);
                            jop = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregar otro documento \n1. Si\n0. No"));
                        }
                    } else if (op2 == 2) {
                        int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Extension del empleado:"));
                        PlazaFija persona = new PlazaFija(nombreEmp, puestoEmp, salarioEmp, extension);
                        empresa1.addEmpleado(persona);
                        int jop=1;
                        while(jop!=0){
                            String nomb=JOptionPane.showInputDialog(null,"Documento \n Nombre:");
                            String num=JOptionPane.showInputDialog(null,"Documento \n Numero:");
                            Documento docs= new Documento(nomb,num);
                            persona.addDocumento(docs);
                            jop=Integer.parseInt(JOptionPane.showInputDialog(null,"Agregar otro documento \n1. Si\n0. No"));
                        }
                    } else {
                        throw new NotExistingEmployeeTypeException("El tipo de empleado no es valido");
                    }
                } catch (NotExistingEmployeeTypeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    JOptionPane.showMessageDialog(null,"Creacion de empleado CANCELADA");
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Salario debe ser un numero");
                    JOptionPane.showMessageDialog(null,"Creacion de empleado CANCELADA");
        }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Creacion de empleado CANCELADA");
                }
                break;
            case 2://Despedir empleado
                nombreEmp= JOptionPane.showInputDialog(null, "Nombre empleado a despedir: ");
                ArrayList<Empleado> empleadosMismosNombres= new ArrayList<>();

                try{
                    empresa1.quitEmpleado(nombreEmp);
                }catch(NotExistingEmployeeException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            break;
            case 3://Ver lista de empleados
                //empresa1.consultarEmpleados();
                empresa1.getPlanilla().forEach(s->{
                    if (s instanceof ServicioProfesional)
                        JOptionPane.showMessageDialog(null, "Servicio Profesional"
                                +"\nNombre: "+s.getNombre()
                        +"\nPuesto: "+s.getPuesto()
                        +"\nSalario: $"+s.getSalario()
                        +"\nMeses contrato: "+((ServicioProfesional) s).getMeses()
                                +s.getDocumentos());
                });
                empresa1.getPlanilla().forEach(s-> {
                    if (s instanceof PlazaFija)
                        JOptionPane.showMessageDialog(null, "Plaza fija"
                                +"\nNombre: "+s.getNombre()
                        +"\nPuesto: "+s.getPuesto()
                        +"\nSalario: $"+s.getSalario()
                        +"\nExtensión: "+((PlazaFija) s).getExtension()
                        +s.getDocumentos());
                });
                break;
            case 4://Calcular sueldo
                break;
            case 5:
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "Saliendo . . .");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida!");
                break;

        }
    }while(op!=0);

    }
    public static String menu(String nombre){
        return ("Empresa "+ nombre+"\n1. Agregar empleado\n2. Despedir empleado\n3. Ver lista de empleados\n" +
                "4. Calcular sueldo\n5.Mostrar totales\n0. Salir");
    }
}
