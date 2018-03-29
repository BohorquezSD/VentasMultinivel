/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import negocio.RecursosHumanos;
import negocio.Empleado;

/**
 *
 * @author sebastianbd
 */
public class prueba {
    
    
public static void main(String[] args) throws RHException {
    ServiceLocator conexion = null;
    conexion.getInstance();
    RecursosHumanos rh = new RecursosHumanos();
    //rh.incluirEmpleado(1, "Sebastian", "Bohorquez", "AD_PRES", "SebasB", 12, "2012-11-05");
    rh.actualizarSalario(2, 13);
     //Empleado e= rh.buscarEmpleado(1);
    //System.out.println("El empleado se llama:" + e.getFirst_name());
    
}
}
