package util;

import Clases.Proveedores;
import ModeloDAO.ProveedoresDAO;

public class prueba1 {

    public static void main(String[] args) {
        
        //LO QUE VOY A USAR PARA MANDAR DATOS O JALAR DATOS A LA BD
        ProveedoresDAO X = new ProveedoresDAO();
        
        //ESTA ES LA CLASE
        Proveedores y = new Proveedores();
        
        //HACIENDO MI CLASE
        y.setPro_cod("P0002");
        y.setPro_nom("Plaza San Miguel");
        y.setPro_ruc(1234456);
        
        //
        X.adicion(y);
    }
    
}
