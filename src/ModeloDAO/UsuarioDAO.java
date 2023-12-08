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
            st.setInt(1, u.getCod());
            st.setString(2, u.getUsr());
            st.setString(3, u.getPass());
            st.setInt(4, u.getCat_cod());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean Login(String usr, String pas) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "UPDATE usuario set est=1 where usr=? and pass=? ";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, usr);
            st.setString(2, pas);
            if(st.executeUpdate() > 0){
                return true;
            }
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean Logout(){
        Connection cn = MySQLConexion.getConexion();
        String sql = "UPDATE usuario set est=0 where est = 1";
        try{
            PreparedStatement st = cn.prepareStatement(sql);
            if(st.executeUpdate() > 0){
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Usuario activo(){
        Usuario u = null;
        Connection cn = MySQLConexion.getConexion();
        String sql = "select cod, usr, pass, est, cat_cod from usuario where est = 1";
        try{
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                u.setCod(rs.getInt(1));
                u.setUsr(rs.getString(2));
                u.setPass(rs.getString(3));
                u.setEst(rs.getInt(4));
                u.setCat_cod(rs.getInt(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }
}
