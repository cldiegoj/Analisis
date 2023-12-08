/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.MySQLConexion;
import java.sql.Date;

/**
 *
 * @author djcor
 */
public class FacturaDAO {

    public void fac_cabe(int num, String fecha, int cod) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO fac_cabe values (?,?,?,1)";
        Date date = Date.valueOf(fecha);
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, num);
            st.setDate(2, date);
            st.setInt(3, cod);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fac_deta(int num, int cod, int can) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO fac_deta values (?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, num);
            st.setInt(2, cod);
            st.setInt(3, can);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
