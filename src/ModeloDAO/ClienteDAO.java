/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

/**
 *
 * @author djcor
 */
public class ClienteDAO {

    public List<Cliente> Listado() {
        Connection cn = MySQLConexion.getConexion();
        String sql = "select cli_cod, cli_nom, cli_tel, cli_cor, cli_dir from clientes";
        List<Cliente> lista = new ArrayList();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente b = new Cliente();
                b.setCli_cod(rs.getString(1));
                b.setCli_nom(rs.getString(2));
                b.setCli_tel(rs.getString(3));
                b.setCli_cor(rs.getString(4));
                b.setCli_dir(rs.getString(5));
                lista.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void Adicion(Cliente b) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO clientes VALUES(?,?,?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, b.getCli_cod());
            st.setString(2, b.getCli_nom());
            st.setString(3, b.getCli_tel());
            st.setString(4, b.getCli_cor());
            st.setString(5, b.getCli_dir());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Actualiza(Cliente b) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "update clientes set cli_nom=?, cli_tel=?, cli_cor=?, cli_dir=? where cli_cod=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, b.getCli_nom());
            st.setString(2, b.getCli_tel());
            st.setString(3, b.getCli_cor());
            st.setString(4, b.getCli_dir());
            st.setString(5, b.getCli_cod());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Borra(String nro) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "delete from clientes where cli_cod=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, nro);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
