/*

 */
package IGU;

import Clases.Cliente;
import Clases.Usuario;
import ModeloDAO.ArticuloDAO;
import ModeloDAO.ClienteDAO;
import ModeloDAO.FacturaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.MySQLConexion;

public class FacturaIGU extends javax.swing.JFrame {

    ClienteDAO clientedao = new ClienteDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");

    public FacturaIGU() {
        initComponents();
        this.setLocationRelativeTo(null);
        String[] titulo = new String[]{"Codigo", "Nombre Producto", "Cantidad", "Precio Unitario", "Total"};
        modelo.setColumnIdentifiers(titulo);
        this.tbFactura.setModel(modelo);
        txtFecha.setText(formato.format(fecha));
        this.setLocationRelativeTo(null);
        this.llenarnfactura();
        this.llenarcampos();
    }

    private void llenarnfactura() {
        Connection cn = MySQLConexion.getConexion();
        String sql = "select fac_num from fac_cabe ORDER BY fac_num desc limit 1";
        int codigo = 0;
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
            this.txtCodigo.setText(Integer.toString(codigo + 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void colocaDatos(String codigo, String nombre, int cantidad, double precio, double total) {
        String[] info = new String[5];
        info[0] = codigo;
        info[1] = nombre;
        info[2] = String.valueOf(cantidad);
        info[3] = String.valueOf(precio);
        info[4] = String.valueOf(total);
        modelo.addRow(info);
    }

    public void llenarcampos() {
        Connection cn = MySQLConexion.getConexion();
        String sql = "select * from clientes where cli_est = 1";
        try {
            Cliente u = new Cliente();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u.setCli_cod(rs.getInt(1));
                u.setCli_nom(rs.getString(2));
                u.setCli_tel(rs.getInt(3));
                u.setCli_cor(rs.getString(4));
                u.setCli_dir(rs.getString(5));
                u.setCli_usr(rs.getString(6));
                u.setCli_pas(rs.getString(7));
                u.setCli_est(rs.getInt(8));
            }
            txtnombre.setText(u.getCli_nom());
            txtDireccion.setText(u.getCli_dir());
            txtCorreo.setText((u.getCli_cor()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        txtSubtotal = new javax.swing.JLabel();
        txtIGV = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        btRegistro = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        Fondo_Fac = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Direccio: Av. Javier prado 501");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 97, 279, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("SUPER NOVA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Teléfono: 341-2345");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 125, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("NOMBRE :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 165, 80, 38));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Factura N°:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 90, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("FECHA DE EMISION:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 151, 35));

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("DIRECCIÓN:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 216, 128, 36));

        txtDireccion.setEditable(false);
        txtDireccion.setEnabled(false);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 218, 510, 35));

        txtnombre.setEditable(false);
        txtnombre.setEnabled(false);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 510, 38));

        txtCorreo.setEditable(false);
        txtCorreo.setEnabled(false);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 218, 35));

        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 218, 34));

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("TOTAL:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 680, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Horario de atención:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 226, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Lunes a Sábado  8 a.m a 10 p.m");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("SUB TOTAL:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, -1, 24));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("IGV:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 40, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("RUC: 20557492635");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 65, 198, 26));

        tbFactura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 690, 215));

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(51, 51, 51));
        txtSubtotal.setText("0");
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 100, 20));

        txtIGV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIGV.setForeground(new java.awt.Color(51, 51, 51));
        txtIGV.setText("0");
        jPanel1.add(txtIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 110, 20));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(51, 51, 51));
        txtTotal.setText("0");
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 680, 110, 20));

        btGuardar.setBackground(new java.awt.Color(187, 122, 68));
        btGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btGuardar.setText("Confirmar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 150, 50));

        btRegistro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_Registro_Facturas.png"))); // NOI18N
        btRegistro.setText("Regresar a comprar");
        btRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 680, 200, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Factura Electronica");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("CORREO:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 128, 35));

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 90, 35));

        Fondo_Fac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Factura_End (3).jpg"))); // NOI18N
        jPanel1.add(Fondo_Fac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 900));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed

    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        FacturaDAO facturadao = new FacturaDAO();
        ArticuloDAO articulodao = new ArticuloDAO();

        try {
            //INSERTAR FACTURA CABECERA
            int codigofac = Integer.parseInt(txtCodigo.getText());
            int codigocliente = clientedao.BuscaCliente(txtnombre.getText());
            facturadao.fac_cabe(codigofac, txtFecha.getText(), codigocliente);

            //INSERTAR FACTURA DETALLE
            int filas = tbFactura.getRowCount();
            for (int i = 0; i < filas; i++) {
                Object codigoart = tbFactura.getValueAt(i, 0);
                Object cantidadart = tbFactura.getValueAt(i, 2);
                facturadao.fac_deta(codigofac, Integer.parseInt(codigoart.toString()), Integer.parseInt(cantidadart.toString()));
                articulodao.actualizastock(Integer.parseInt(codigoart.toString()), Integer.parseInt(cantidadart.toString()));
            }
            
            Final menu = new Final();
            this.dispose();
            menu.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistroActionPerformed
        Pedidos mostrar = new Pedidos();
        this.dispose();
        mostrar.setVisible(true);
    }//GEN-LAST:event_btRegistroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacturaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaIGU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo_Fac;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btRegistro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JLabel txtIGV;
    public static javax.swing.JLabel txtSubtotal;
    public static javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    private String String(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
