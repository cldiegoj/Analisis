/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author KID-R
 */
public class Usuario {
    private String cat_cod;
    private String cod;
    private String pass;
    private String usr;

    public Usuario(String cat_cod, String cod, String pass, String usr) {
        this.cat_cod = cat_cod;
        this.cod = cod;
        this.pass = pass;
        this.usr = usr;
    }
    public Usuario(){
        
    }

    public String getCat_cod() {
        return cat_cod;
    }

    public void setCat_cod(String cat_cod) {
        this.cat_cod = cat_cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }
    
    
}
