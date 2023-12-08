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

    private int cli_cod;
    private String cli_nom;
    private int cli_tel;
    private String cli_cor;
    private String cli_dir;
    private String cli_usr;
    private String cli_pas;
    private int cli_est;

    public Cliente() {
    }

    public Cliente(int cli_cod, String cli_nom, int cli_tel, String cli_cor, String cli_dir, String cli_usr, String cli_pas, int cli_est) {
        this.cli_cod = cli_cod;
        this.cli_nom = cli_nom;
        this.cli_tel = cli_tel;
        this.cli_cor = cli_cor;
        this.cli_dir = cli_dir;
        this.cli_usr = cli_usr;
        this.cli_pas = cli_pas;
        this.cli_est = cli_est;
    }

    public int getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(int cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getCli_nom() {
        return cli_nom;
    }

    public void setCli_nom(String cli_nom) {
        this.cli_nom = cli_nom;
    }

    public int getCli_tel() {
        return cli_tel;
    }

    public void setCli_tel(int cli_tel) {
        this.cli_tel = cli_tel;
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

    public String getCli_usr() {
        return cli_usr;
    }

    public void setCli_usr(String cli_usr) {
        this.cli_usr = cli_usr;
    }

    public String getCli_pas() {
        return cli_pas;
    }

    public void setCli_pas(String cli_pas) {
        this.cli_pas = cli_pas;
    }

    public int getCli_est() {
        return cli_est;
    }

    public void setCli_est(int cli_est) {
        this.cli_est = cli_est;
    }

}
