/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.MySQLConexion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djcor
 */
public class ProveedorDAO {

    public void adicion(Proveedor u) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO `proveedor` VALUES (?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, u.getPro_cod());
            st.setString(2, u.getPro_nom());
            st.setInt(3, u.getPro_ruc());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Proveedor> listado() {
        Connection cn = MySQLConexion.getConexion();
        String sql = "select pro_cod, pro_nom, pro_ruc from proveedor";
        List<Proveedor> lista = new ArrayList();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setPro_cod(rs.getInt(1));
                p.setPro_nom(rs.getString(2));
                p.setPro_ruc(rs.getInt(3));
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
