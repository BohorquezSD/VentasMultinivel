/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentasBackEndPkg;

import util.Util;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import util.RHException;
import org.json.simple.JSONObject;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
@Path("login")
public class Login extends Util{
    
    private String user;
    private String pass;
   
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject validar(@QueryParam("user") String usuario, @QueryParam("pass") String password)throws RHException{
         JSONObject obj = new JSONObject();
        try{
            ServiceLocator s =conectarBD(usuario,password);
            obj.put("nombre", s.getUser());
            return obj;
        }catch(Exception e){
            obj.put("nombre", e.getMessage());
            return obj;
        }
    }
    
   
    
   
    
}
