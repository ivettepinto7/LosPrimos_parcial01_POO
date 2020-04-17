package com.OARA.x00206019;

public final class CalculadoraImpuestos {
    private static double totalRenta, totalISSS, totalAFP;

    private CalculadoraImpuestos(){}
    public static double calcularPago(Empleado unEmpleado){
        double pago=0,restante=0;
        if (unEmpleado instanceof ServicioProfesional){
            totalRenta = (0.1)*(unEmpleado.getSalario());
            pago = (unEmpleado.getSalario())-(totalRenta);
        }else if (unEmpleado instanceof PlazaFija){
            totalAFP = (0.0625)*(unEmpleado.getSalario());
            totalISSS = (0.03)*(unEmpleado.getSalario());
            restante = (unEmpleado.getSalario())-(totalAFP)-(totalISSS);
            if (restante >= 0.01 && restante <= 472.00){
                totalRenta = 0;
            }else if (restante >= 472.01 && restante <= 895.24){
                totalRenta = (0.1)*(restante-472)+(17.67);
            }else if (restante >= 895.25 && restante <= 2038.10){
                totalRenta = (0.2)*(restante-895.24)+(60);
            }else if (restante >= 2038.11){
                totalRenta = (0.3)*(restante-2038.10)+(288.57);
            }
            pago = (restante)-(totalRenta);
        }return pago;
    }
    public static String mostrarTotales(){
        return "Total renta: "+totalRenta
                + "\nTotal ISSS: "+totalISSS
                + "\nTotal AFP: "+totalAFP;
    }
}
