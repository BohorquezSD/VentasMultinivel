package util;

public class RHException extends Exception {
      private String detalle;
      private String clase;
     

      public RHException(String clase,String error) {
        super(error);
        this.clase = clase; 
        detalle = error;
      }

      public String toString() {
        return "["+clase+"] "+detalle;
      }
 }

