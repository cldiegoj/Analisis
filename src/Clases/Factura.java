
package Clases;

import java.io.Serializable;

public class Factura implements Serializable{
    String codigo;
    private String Nombre;
    private int RUC;
    private String direccion;
    private String Fecha;
    private double Total;
    

    public Factura(String codigo,String Nombre, int RUC, String direccion, String Fecha, double Total) {
        this.codigo=codigo;
        this.Nombre = Nombre;
        this.RUC = RUC;
        this.direccion = direccion;
        this.Fecha = Fecha;
        this.Total = Total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getRUC() {
        return RUC;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    
}

