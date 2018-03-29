/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentasBackEndPkg;

import datos.PrivilegiosDAO;
import datos.RolesDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Privilegio;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verPrivs")
public class VerPrivilegios extends Util {
    
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verPrivs(@QueryParam("user") String usuario, @QueryParam("pass") String password, @QueryParam("search") String search)throws RHException, Exception{
        ArrayList obj= new ArrayList();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        PrivilegiosDAO pri = new PrivilegiosDAO();
         Privilegio priv = pri.verPrivilegios("\'"+ search +"\'");
        /*
        for(int i=0; i<priv.getGrantee().size(); i++){
            JSONObject rol = new JSONObject();
            rol.put("nombre", priv.getGrantee().get(i));
            rol.put("RoleAsociado", priv.getGrantedRole().get(i));
            rol.put("adm", priv.getAdm().get(i));
            rol.put("def",priv.getDef().get(i));
            obj.add(rol);
        }*/
            obj2.put("privs", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
         
    } 
}