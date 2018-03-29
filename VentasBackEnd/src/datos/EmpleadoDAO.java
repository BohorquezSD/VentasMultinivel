package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import negocio.Empleado;

import util.RHException;
import util.ServiceLocator;

/**
 * @author Alba Consuelo Nieto.
 * Esta clase encapsula el acceso a la Base de Datos
 */
public class EmpleadoDAO {
    /*
     * Constructor de la clase
     */
    public EmpleadoDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    public void incluirEmpleado(Empleado empleado) throws RHException {
      try {
        String strSQL = "INSERT INTO employees (employee_id, first_name, last_name, job_id, email,salary, hire_date) VALUES(?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1,empleado.getEmployee_id()); 
        prepStmt.setString(2, empleado.getFirst_name()); 
        prepStmt.setString(3, empleado.getLast_name()); 
        prepStmt.setString(4, empleado.getJob_id()); 
        prepStmt.setString(5, empleado.getEmail());   
        prepStmt.setDouble(6, empleado.getSalary());  
        prepStmt.setDate(7, java.sql.Date.valueOf(empleado.getHire_date()));
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           throw new RHException( "EmpleadoDAO", "No pudo crear el empleado"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
    public void modificarEmpleado(Empleado empleado) throws RHException{
       try {
      
        String strSQL = "UPDATE Employees SET First_name = '?', Last_name= ?, Job_id = ?, email = ?, salary =?, hire_date = ? WHERE Employee_id = ?;";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
      
        prepStmt.setString(1, empleado.getFirst_name()); 
        prepStmt.setString(2, empleado.getLast_name()); 
        prepStmt.setString(3, empleado.getJob_id()); 
        prepStmt.setString(4, empleado.getEmail());   
        prepStmt.setDouble(5, empleado.getSalary());  
        prepStmt.setDate(6, java.sql.Date.valueOf(empleado.getHire_date()));
        prepStmt.setInt(7,empleado.getEmployee_id()); 
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           throw new RHException( "EmpleadoDAO", "No pudo modificar el empleado"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
    }
    
    public Empleado buscarEmpleado(Integer employee_id) throws RHException{
      Empleado e = new Empleado(); //Instancia el objeto para retornar los datos del empleado
      try{
         String strSQL = "SELECT employee_id, first_name, last_name, job_id, email, hire_date FROM employees WHERE employee_id = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setInt(1,employee_id);
          ResultSet rs = prepStmt.executeQuery();
          System.out.println(rs);
            rs.next();
          
            int id = rs.getInt(1);
            String nombre= rs.getString(2);
            String apellido= rs.getString(3);
            String jobId = rs.getString(4);
            String email = rs.getString(5);
            String hire_date = rs.getString(6);
            
             e.setEmployee_id(employee_id);
             e.setFirst_name(nombre);
             e.setLast_name(apellido);
             e.setEmail(email);
             e.setJob_id(jobId);
             e.setHire_date(hire_date);
          return e;
      }
      catch(SQLException error){
         throw new RHException( "EmpleadoDAO", "No se encontro empleado"+ error.getMessage());
      } finally {
         ServiceLocator.getInstance().liberarConexion();
      }
    }
    
    public void actualizarSalario(Empleado empleado) throws RHException {
        try {
      
        String strSQL = "UPDATE Employees SET salary= ? WHERE Employee_id = ? ;";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
      
        prepStmt.setDouble(1, empleado.getSalary());
        prepStmt.setInt(2, empleado.getEmployee_id()); 
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           throw new RHException( "EmpleadoDAO", "No pudo modificar el empleado "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
    }

}


