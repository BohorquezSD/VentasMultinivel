/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Role;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class RolesDAO {
    
    public Role verRole(String role) throws RHException, Exception {
        Role rol = new Role();
      try {
             System.out.println("ENTRA AL METODO");
        String strSQL = "SELECT  * FROM  dba_role_privs where GRANTEE = UPPER(" + role + ")";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
           System.out.println("TOMA CONEXION "+ role);
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
            System.out.println("EMPIEZA MAPEO");
            
            ArrayList<String> grantee= new ArrayList<>();
            ArrayList<String> granted_role = new ArrayList<>();
            ArrayList<String> adm = new ArrayList<>();
            ArrayList<String> def = new ArrayList<>();
            int i=0;
            if(rs!= null){
                while(rs.next()== true) {
                   grantee.add(rs.getString("GRANTEE"));
                   granted_role.add(rs.getString(2));
                   adm.add(rs.getString(3));
                   def.add(rs.getString(4));
                   i++;
                }
                
            }
  
            rol.setGrantee(grantee);
            rol.setGrantedRole(granted_role);
            rol.setAdm(adm);
            rol.setDef(def);
        return rol;
      } catch (SQLException e) {
           throw new RHException( "RolesDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
   
}
