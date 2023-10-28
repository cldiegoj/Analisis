package Clases;


public class Proveedores{
    String codigo;
    String nombreP;
    int cantidad;
    double total;

    public Proveedores(String codigo,String nombreP, int cantidad, double total) {
        this.codigo=codigo;
        this.nombreP = nombreP;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
