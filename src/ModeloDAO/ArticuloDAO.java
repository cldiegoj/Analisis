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
public class ArticuloDAO {

    public List<Articulo> Listado() {
        Connection cn = MySQLConexion.getConexion();
        String sql = "select art_cod, art_nom, art_des, art_pre, art_stk, pro_cod from articulos";
        List<Articulo> lista = new ArrayList();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Articulo b = new Articulo();
                b.setArt_cod(rs.getString(1));
                b.setArt_nom(rs.getString(2));
                b.setArt_des(rs.getString(3));
                b.setArt_pre(rs.getDouble(4));
                b.setArt_stk(rs.getInt(5));
                b.setPro_cod(rs.getString(6));
                lista.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void Adicion(Articulo b) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO articulos VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, b.getArt_cod());
            st.setString(2, b.getArt_nom());
            st.setString(3, b.getArt_des());
            st.setDouble(4, b.getArt_pre());
            st.setInt(5, b.getArt_stk());
            st.setString(6, b.getPro_cod());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Actualiza(Articulo b) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "update articulos set art_nom=?, art_des=?, art_pre=?, art_stk=? where art_cod=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, b.getArt_nom());
            st.setString(2, b.getArt_des());
            st.setDouble(3, b.getArt_pre());
            st.setInt(4, b.getArt_stk());
            st.setString(5, b.getArt_cod());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Borra(String nro) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "delete from articulos where art_cod=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, nro);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
