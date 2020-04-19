package com.OARA.x00206019;

public final class CalculadoraImpuestos {
    private static double totalRenta, totalISSS, totalAFP;

    private CalculadoraImpuestos(){}
    public static double calcularPago(Empleado unEmpleado){
        double renta=0,pago=0,AFP,ISSS,restante;
        if (unEmpleado instanceof ServicioProfesional){
            renta = (0.1)*(unEmpleado.getSalario());
            pago = (unEmpleado.getSalario())-(renta);
            totalRenta += renta;
        }else if (unEmpleado instanceof PlazaFija){
            AFP = (0.0625)*(unEmpleado.getSalario());
            totalAFP += AFP;
            ISSS = (0.03)*(unEmpleado.getSalario());
            totalISSS += ISSS;
            restante = (unEmpleado.getSalario())-(AFP)-(ISSS);
            if (restante >= 0.01 && restante <= 472.00){
                renta = 0;
                totalRenta += renta;
            }else if (restante >= 472.01 && restante <= 895.24){
                renta = (0.1)*(restante - 472) + 17.67;
                totalRenta += renta;
            }else if (restante >= 895.25 && restante <= 2038.10){
                renta = (0.2)*(restante - 895.24) + 60;
                totalRenta += renta;
            }else if (restante >= 2038.11){
                renta = (0.3)*(restante - 2038.10) + 288.57;
                totalRenta += renta;
            }
            pago = (restante) - (renta);
        }
        return pago;
    }
    public static String mostrarTotales(){
        return "Total renta: $"+totalRenta
                + "\nTotal ISSS: $"+totalISSS
                + "\nTotal AFP: $"+totalAFP;
    }
}
