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

/**
 *
 * @author djcor
 */
public class UsuarioDAO {
    
    
    public void Register(Usuario u) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO `usuario` VALUES (?,?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, u.getCod());
            st.setString(2, u.getUsr());
            st.setString(3, u.getPass());
            st.setString(4, u.getCat_cod());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Usuario Login(String usr, String pas) {
        Usuario p = null;
        Connection cn = MySQLConexion.getConexion();
        String sql = "select cod, usr, pass, cat_cod from usuario where usr=? and pass=? ";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, usr);
            st.setString(2, pas);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Usuario();
                p.setCod(rs.getString(1));
                p.setUsr(rs.getString(2));
                p.setPass(rs.getString(3));
                p.setCat_cod(rs.getString(4));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }
}
