/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author KID-R
 */
public class Proveedor {
    private String pro_cod;
    private String pro_nom;
    private int pro_ruc;

    public Proveedor(String pro_cod, String pro_nom, int pro_ruc) {
        this.pro_cod = pro_cod;
        this.pro_nom = pro_nom;
        this.pro_ruc = pro_ruc;
    }
    public Proveedor(){
        
    }

    public String getPro_cod() {
        return pro_cod;
    }

    public void setPro_cod(String pro_cod) {
        this.pro_cod = pro_cod;
    }

    public String getPro_nom() {
        return pro_nom;
    }

    public void setPro_nom(String pro_nom) {
        this.pro_nom = pro_nom;
    }

    public int getPro_ruc() {
        return pro_ruc;
    }

    public void setPro_ruc(int pro_ruc) {
        this.pro_ruc = pro_ruc;
    }
    
    
}
