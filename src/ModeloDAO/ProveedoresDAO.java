/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Clases.Proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.MySQLConexion;

/**
 *
 * @author djcor
 */
public class ProveedoresDAO {

     public void adicion(Proveedores u) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO `proveedor` VALUES (?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, u.getPro_cod());
            st.setString(2, u.getPro_nom());
            st.setInt(3, u.getPro_ruc());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
