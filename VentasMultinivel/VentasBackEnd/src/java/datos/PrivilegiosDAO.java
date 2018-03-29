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
import negocio.Privilegio;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class PrivilegiosDAO {
     public Privilegio verPrivilegios(String privilegio) throws RHException, Exception {
        Privilegio priv = new Privilegio();
      try {
          //TODO buscar consulta de privs
        String strSQL = "SELECT  * FROM  dba_role_privs where GRANTEE = UPPER(" + privilegio + ")";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
            
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
  
            //priv.setGrantee(grantee);
            //priv.setGrantedRole(granted_role);
            //priv.setAdm(adm);
            //priv.setDef(def);
        return priv;
      } catch (SQLException e) {
           throw new RHException( "PrivilegiosDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
}
