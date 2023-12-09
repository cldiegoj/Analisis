/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.MySQLConexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.*;

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
    
    public String ClientexId(int id){
        String nombre = "";
        Connection cn = MySQLConexion.getConexion();
        String sql = "select c.cli_nom from clientes c INNER JOIN fac_cabe f on f.cli_cod = c.cli_cod WHERE f.fac_num = ?";
        try{
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                nombre = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nombre;
    }
    
    public List<Integer> nfacturas (){
        Connection cn = MySQLConexion.getConexion();
        String sql = "select fac_num from fac_cabe";
        List<Integer> lista = new ArrayList();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int b = rs.getInt(1);
                lista.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
