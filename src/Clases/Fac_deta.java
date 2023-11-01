/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author KID-R
 */
public class Fac_deta {
    private int art_can;
    private String art_cod;
    private String fac_num;

    public Fac_deta(int art_can, String art_cod, String fac_num) {
        this.art_can = art_can;
        this.art_cod = art_cod;
        this.fac_num = fac_num;
    }
    
    public Fac_deta(){
        
    }

    public int getArt_can() {
        return art_can;
    }

    public void setArt_can(int art_can) {
        this.art_can = art_can;
    }

    public String getArt_cod() {
        return art_cod;
    }

    public void setArt_cod(String art_cod) {
        this.art_cod = art_cod;
    }

    public String getFac_num() {
        return fac_num;
    }

    public void setFac_num(String fac_num) {
        this.fac_num = fac_num;
    }
    
    
}
