/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author sebastianbd
 */
public class Role {

  
    private ArrayList grantee;
    private ArrayList grantedRole;
    private ArrayList  adm;
    private ArrayList  def;

    public ArrayList getGrantee() {
        return grantee;
    }

    public void setGrantee(ArrayList grantee) {
        this.grantee = grantee;
    }

    public ArrayList getGrantedRole() {
        return grantedRole;
    }

    public void setGrantedRole(ArrayList grantedRole) {
        this.grantedRole = grantedRole;
    }

    public ArrayList getAdm() {
        return adm;
    }

    public void setAdm(ArrayList adm) {
        this.adm = adm;
    }

    public ArrayList getDef() {
        return def;
    }

    public void setDef(ArrayList def) {
        this.def = def;
    }
    
    
    
    public Role() { 
        
    }

   

    
    
    
    
}
