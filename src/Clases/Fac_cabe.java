/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

/**
 *
 * @author KID-R
 */
public class Fac_cabe {
    private String cli_cod;
    private Date fac_fec;
    private String fac_igv;
    private String fac_num;

    public Fac_cabe(String cli_cod, Date fac_fec, String fac_igv, String fac_num) {
        this.cli_cod = cli_cod;
        this.fac_fec = fac_fec;
        this.fac_igv = fac_igv;
        this.fac_num = fac_num;
    }
    public Fac_cabe(){
        
    }

    public String getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(String cli_cod) {
        this.cli_cod = cli_cod;
    }

    public Date getFac_fec() {
        return fac_fec;
    }

    public void setFac_fec(Date fac_fec) {
        this.fac_fec = fac_fec;
    }

    public String getFac_igv() {
        return fac_igv;
    }

    public void setFac_igv(String fac_igv) {
        this.fac_igv = fac_igv;
    }

    public String getFac_num() {
        return fac_num;
    }

    public void setFac_num(String fac_num) {
        this.fac_num = fac_num;
    }
    
    
}
