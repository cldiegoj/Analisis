/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author KID-R
 */
public class Cliente {
    private String cli_cod;
    private String cli_cor;
    private String cli_dir;
    private String cli_nom;
    private String cli_tel;

    public Cliente(String cli_cod, String cli_cor, String cli_dir, String cli_nom, String cli_tel) {
        this.cli_cod = cli_cod;
        this.cli_cor = cli_cor;
        this.cli_dir = cli_dir;
        this.cli_nom = cli_nom;
        this.cli_tel = cli_tel;
    }
    public Cliente(){
        
    }

    public String getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(String cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getCli_cor() {
        return cli_cor;
    }

    public void setCli_cor(String cli_cor) {
        this.cli_cor = cli_cor;
    }

    public String getCli_dir() {
        return cli_dir;
    }

    public void setCli_dir(String cli_dir) {
        this.cli_dir = cli_dir;
    }

    public String getCli_nom() {
        return cli_nom;
    }

    public void setCli_nom(String cli_nom) {
        this.cli_nom = cli_nom;
    }

    public String getCli_tel() {
        return cli_tel;
    }

    public void setCli_tel(String cli_tel) {
        this.cli_tel = cli_tel;
    }
    
    
}
