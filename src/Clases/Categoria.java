/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author KID-R
 */
public class Categoria {
    private int cat_cod ;
    private String cat_des;
    private String cat_nom;

    public Categoria(int cat_cod, String cat_des, String cat_nom) {
        this.cat_cod = cat_cod;
        this.cat_des = cat_des;
        this.cat_nom = cat_nom;
    }
    public Categoria(){
        
    }

    public int getCat_cod() {
        return cat_cod;
    }

    public void setCat_cod(int cat_cod) {
        this.cat_cod = cat_cod;
    }

    public String getCat_des() {
        return cat_des;
    }

    public void setCat_des(String cat_des) {
        this.cat_des = cat_des;
    }

    public String getCat_nom() {
        return cat_nom;
    }

    public void setCat_nom(String cat_nom) {
        this.cat_nom = cat_nom;
    }
    
    
    
}
