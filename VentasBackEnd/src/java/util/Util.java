/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author sebastianbd
 */
public abstract class Util {
    
     public ServiceLocator conectarBD(String usuario, String password) throws RHException, Exception {
            try{
                ServiceLocator conexion = null;
                return ServiceLocator.getInstance(usuario, password);
            }catch(Exception e){
                throw new RHException("Conexion","ERROR_CONEXION_BD "+ e);
            }
    }
}
