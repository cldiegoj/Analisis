package IGU;

import static IGU.FacturaIGU.txtIGV;
import static IGU.FacturaIGU.txtSubtotal;
import static IGU.FacturaIGU.txtTotal;
import ModeloDAO.ArticuloDAO;
import Clases.*;
import java.util.*;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import util.MySQLConexion;

public class Pedidos extends javax.swing.JFrame {

    //Dao articulos
    ArticuloDAO articulodao = new ArticuloDAO();

    //Tabla
    DefaultTableModel modelo2 = new DefaultTableModel();

    InventarioIGU inve = new InventarioIGU();
    private ImageIcon imagen;
    private Icon icono;
    FacturaIGU newframe = new FacturaIGU();

    public Pedidos() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbPedidos.setModel(modelo2);
        String[] cabecera = {"Codigo", "Nombre Producto", "Precio Unitario", "Cantidad"};
        modelo2.setColumnIdentifiers(cabecera);
        llenarCombo();
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void pintarImagen(JLabel lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
    }

    public void modificar(int cantidad, String nombre) {
        try {

            Connection cn = MySQLConexion.getConexion();
            String sql = "UPDATE articulos SET art_stk = art_stk - " + cantidad + " where art_nom = '" + nombre + "'";
            PreparedStatement st = cn.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error...Falla en la conexion");
        }
    }

    public void llenarCombo() {

        List<Articulo> listaart = new ArrayList();
        listaart = articulodao.Listado();

        for (Articulo x : listaart) {
            cbxProducto.addItem(x.getArt_nom());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxProducto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        btProcesarPedido = new javax.swing.JButton();
        btAgregarProducto = new javax.swing.JButton();
        btMostrarInventario = new javax.swing.JButton();
        lbImagen = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 130, 40));

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 520, 390));

        btProcesarPedido.setBackground(new java.awt.Color(187, 122, 68));
        btProcesarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btProcesarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btProcesarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_CarritoProcesar.png"))); // NOI18N
        btProcesarPedido.setText("  Procesar Pedido");
        btProcesarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcesarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btProcesarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 210, 60));

        btAgregarProducto.setBackground(new java.awt.Color(187, 122, 68));
        btAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_CarritoAgregar.png"))); // NOI18N
        btAgregarProducto.setText("  Agregar Producto");
        btAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 210, 60));

        btMostrarInventario.setBackground(new java.awt.Color(187, 122, 68));
        btMostrarInventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btMostrarInventario.setForeground(new java.awt.Color(255, 255, 255));
        btMostrarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_InventarioAlmacen2.png"))); // NOI18N
        btMostrarInventario.setText(" Mostrar Inventario");
        btMostrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btMostrarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 210, 60));

        lbImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 160, 150));

        btSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btSalir.setText("Volver al Menú");
        btSalir.setBorderPainted(false);
        btSalir.setContentAreaFilled(false);
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 210, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedido_End.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
//        String producto = cbxProducto.getSelectedItem().toString();
//        Image icon = new ImageIcon(this.getClass().getResource("/"+producto+".jpg")).getImage();
//        lbImagen.setIcon(icono);
    }//GEN-LAST:event_cbxProductoActionPerformed

    private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed

        try {
            if (Integer.parseInt(txtCantidad.getText()) > 0) {
                Connection cn = MySQLConexion.getConexion();
                String sql = "select * from articulos where art_nom = '" + cbxProducto.getSelectedItem().toString() + "'";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                Object orden[] = new Object[4];

                while (rs.next()) {
                    orden[0] = rs.getInt("art_cod");
                    orden[1] = rs.getString("art_nom");
                    orden[2] = rs.getDouble("art_pre");
                    orden[3] = txtCantidad.getText();
                    modelo2.addRow(orden);
                }

                modificar(Integer.parseInt(txtCantidad.getText()), orden[1].toString());
                inve.cargarRegistroAlaTabla();

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
        }


    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void btMostrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarInventarioActionPerformed
        inve.setVisible(true);
    }//GEN-LAST:event_btMostrarInventarioActionPerformed

    private void btProcesarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesarPedidoActionPerformed
        try {

            if (tbPedidos.getRowCount() > 0) {
                String[] datos = new String[5];
                double totalCompra = 0;
                for (int i = 0; i < modelo2.getRowCount(); i++) {
                    //Codigo de articulo
                    datos[0] = tbPedidos.getValueAt(i, 0).toString();
                    //Nombre de producto
                    datos[1] = tbPedidos.getValueAt(i, 1).toString();
                    //Precio unitario
                    datos[2] = tbPedidos.getValueAt(i, 3).toString();
                    //Cantidad
                    datos[3] = tbPedidos.getValueAt(i, 2).toString();
                    
                    //Calcula 
                    datos[4] = String.valueOf(Double.parseDouble(datos[2]) * Double.parseDouble(datos[3]));
                    
                    
                    totalCompra = totalCompra + Double.parseDouble(datos[4]);
                    newframe.modelo.addRow(datos);

                }
                //Subtotal
                txtSubtotal.setText(String.valueOf(totalCompra));
               //IGV 
                txtIGV.setText(String.valueOf(totalCompra * 0.18));
                //Total
                txtTotal.setText(String.valueOf(totalCompra + (totalCompra * 0.18)));
                newframe.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Productos insuficientes");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
        }

    }//GEN-LAST:event_btProcesarPedidoActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        Vista menu = new Vista();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btMostrarInventario;
    private javax.swing.JButton btProcesarPedido;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
