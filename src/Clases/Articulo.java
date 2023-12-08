
package Clases;


public class Articulo {
    private int art_cod;
    private String art_nom;
    private String art_des;
    private double art_pre;
    private int art_stk;
    private int pro_cod;

    public Articulo(int art_cod, String art_nom, String art_des, double art_pre, int art_stk, int pro_cod) {
        this.art_cod = art_cod;
        this.art_nom = art_nom;
        this.art_des = art_des;
        this.art_pre = art_pre;
        this.art_stk = art_stk;
        this.pro_cod = pro_cod;
    }  
    
    public Articulo(){
        
    }

    public int getArt_cod() {
        return art_cod;
    }

    public void setArt_cod(int art_cod) {
        this.art_cod = art_cod;
    }

    public String getArt_nom() {
        return art_nom;
    }

    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public String getArt_des() {
        return art_des;
    }

    public void setArt_des(String art_des) {
        this.art_des = art_des;
    }

    public double getArt_pre() {
        return art_pre;
    }

    public void setArt_pre(double art_pre) {
        this.art_pre = art_pre;
    }

    public int getArt_stk() {
        return art_stk;
    }

    public void setArt_stk(int art_stk) {
        this.art_stk = art_stk;
    }

    public int getPro_cod() {
        return pro_cod;
    }

    public void setPro_cod(int pro_cod) {
        this.pro_cod = pro_cod;
    }
    
    
    
    
}
