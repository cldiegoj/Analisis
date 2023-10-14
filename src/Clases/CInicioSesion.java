

package Clases;

import javax.swing.JOptionPane;

public class CInicioSesion {
    String idU;
    String contraseña;
    public boolean correcto=false;

    public CInicioSesion() {
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
  public void ingresar(String idU,String contraseña){
    if(idU.equalsIgnoreCase("usuario1") && contraseña.equalsIgnoreCase("1234")){
        JOptionPane.showMessageDialog(null, "Inicio de sesión correcto, Bienvenido");
        this.correcto=true;
    }else{        
        JOptionPane.showMessageDialog(null, "ID de usuario o contraseña incorrecta, intente nuevamente");
        this.correcto=false;
    }
    } 
  //diego esta con hambre  
}





