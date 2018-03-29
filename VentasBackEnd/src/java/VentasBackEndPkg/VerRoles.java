/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentasBackEndPkg;

import datos.RolesDAO;
import java.sql.Array;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Role;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verRoles")
public class VerRoles extends Util {
    
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRoles(@QueryParam("user") String usuario, @QueryParam("pass") String password, @QueryParam("search") String search)throws RHException, Exception{
        ArrayList obj= new ArrayList();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        RolesDAO loginD = new RolesDAO();
         Role role = loginD.verRole("\'"+ search +"\'");
        
        for(int i=0; i<role.getGrantee().size(); i++){
            JSONObject rol = new JSONObject();
            rol.put("nombre", role.getGrantee().get(i));
            rol.put("RoleAsociado", role.getGrantedRole().get(i));
            rol.put("adm", role.getAdm().get(i));
            rol.put("def",role.getDef().get(i));
            obj.add(rol);
        }
            obj2.put("roles", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}
