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

    private int cat_cod;
    private int cod;
    private String pass;
    private String usr;
    private int est;

    public Usuario() {
    }

    public Usuario(int cat_cod, int cod, String pass, String usr, int est) {
        this.cat_cod = cat_cod;
        this.cod = cod;
        this.pass = pass;
        this.usr = usr;
        this.est = est;
    }

    public int getCat_cod() {
        return cat_cod;
    }

    public void setCat_cod(int cat_cod) {
        this.cat_cod = cat_cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
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

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

}
