package negocio;

import datos.EmpleadoDAO;

import util.RHException;

/**
 * Clase controladora de la aplicaci�n
 * @author Alba Consuelo Nieto
 */
public class RecursosHumanos {
    private EmpleadoDAO empleadoDAO;
    private Empleado empleado;
    
    public RecursosHumanos() {
        empleadoDAO = new EmpleadoDAO();
    }
    /**
     * Invoca el m�todo del DAO que permite incluir un nuevo empleado
     * @param id
     * @param nombre
     * @param apellido
     * @param job_id
     * @param email
     * @param fecha
     * @throws RHException
     */
    public void incluirEmpleado(int id, String nombre,String apellido, String job_id, String email, double salary, String fecha) throws RHException {
      empleado = new Empleado();
      empleado.setEmployee_id(id);
      empleado.setFirst_name(nombre);
      empleado.setLast_name(apellido);
      empleado.setJob_id(job_id);
      empleado.setEmail(email);
      empleado.setSalary(salary);
      empleado.setHire_date(fecha);
      empleadoDAO.incluirEmpleado(empleado);
      /** TODO Invocar el metodo correspondiente del DAO para incluir el empleado */
    }
    
    public void actualizarSalario(int id, double salario) throws RHException {
      empleado = new Empleado();
      empleado.setEmployee_id(id);
      empleado.setSalary(salario);
      empleadoDAO.actualizarSalario(empleado);
    }
    
    public Empleado buscarEmpleado (int id) throws RHException{
        return empleado=empleadoDAO.buscarEmpleado(id);
    /** TODO Implementar el m�todo para buscar el empleado**/
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return new Empleado();
    }
}
