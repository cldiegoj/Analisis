package IGU;

import Clases.*;
import static IGU.FacturaIGU.txtIGV;
import static IGU.FacturaIGU.txtSubtotal;
import static IGU.FacturaIGU.txtTotal;
import ModeloDAO.ArticuloDAO;
import ModeloDAO.ProveedorDAO;
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

public class Abastecimiento extends javax.swing.JFrame {

    ArticuloDAO articulodao = new ArticuloDAO();
    ProveedorDAO proveedordao = new ProveedorDAO();

    DefaultTableModel modelo2 = new DefaultTableModel();
    InventarioIGU inve = new InventarioIGU();
    private ImageIcon imagen;
    private Icon icono;

    public Abastecimiento() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbPedidos.setModel(modelo2);
        String[] cabecera = {"Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad", "Subtotal"};
        modelo2.setColumnIdentifiers(cabecera);
        llenarComboProveedor();
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void pintarImagen(JLabel lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
    }

    public void sumar(int cantidad, String nombre) {
        try {
            Connection cn = MySQLConexion.getConexion();
            String sql = "UPDATE articulos SET art_stk=art_stk+" + cantidad + " WHERE art_nom='" + nombre + "'";

            PreparedStatement st = cn.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error...Falla en la conexion");
        }
    }

    public void CargarProductosTabla() {
        //Cabecera de la tabla
        String[] titulo = {"Producto", "Stock"};

        String[] fila = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulo);
        String proveedor = cbxProovedor.getSelectedItem().toString();
        List<Articulo> lista = articulodao.ListaFiltro(proveedor);

        for (Articulo x : lista) {
            fila[0] = x.getArt_nom();
            fila[1] = Integer.toString(x.getArt_stk());
            tabla.addRow(fila);
            tbPrecios.setModel(tabla);
        }
    }

    public void llenarCombo() {

        List<Articulo> listaart = new ArrayList();
        String proveedor = cbxProovedor.getSelectedItem().toString();
        listaart = articulodao.ListaFiltro(proveedor);

        for (Articulo x : listaart) {
            cbxProducto.addItem(x.getArt_nom());
        }
    }

    public void llenarComboProveedor() {

        List<Proveedor> listproveedor = new ArrayList();
        listproveedor = proveedordao.listado();

        for (Proveedor x : listproveedor) {
            cbxProovedor.addItem(x.getPro_nom());
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
        Imagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxProovedor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPrecios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 260, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, 40));

        tbPedidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPedidos.setForeground(new java.awt.Color(187, 122, 68));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 460, 410));

        btProcesarPedido.setBackground(new java.awt.Color(187, 122, 66));
        btProcesarPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btProcesarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_CarritoProcesar.png"))); // NOI18N
        btProcesarPedido.setText("  Procesar Pedido");
        btProcesarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcesarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btProcesarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 220, 60));

        btAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_CarritoAgregar.png"))); // NOI18N
        btAgregarProducto.setText("  Agregar Producto");
        btAgregarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btAgregarProducto.setBorderPainted(false);
        btAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAgregarProducto.setDoubleBuffered(true);
        btAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 220, 60));

        btMostrarInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btMostrarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ico_end_InventarioAlmacen2.png"))); // NOI18N
        btMostrarInventario.setText("  Mostrar Inventario");
        btMostrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btMostrarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 220, 60));

        Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 180, 150));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        cbxProovedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cbxProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProovedorActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 260, 40));

        tbPrecios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPrecios.setForeground(new java.awt.Color(51, 51, 51));
        tbPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Stock"
            }
        ));
        jScrollPane2.setViewportView(tbPrecios);
        if (tbPrecios.getColumnModel().getColumnCount() > 0) {
            tbPrecios.getColumnModel().getColumn(0).setHeaderValue("Producto");
            tbPrecios.getColumnModel().getColumn(1).setHeaderValue("Stock");
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 280, 340));

        jButton1.setBackground(new java.awt.Color(187, 122, 66));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver (1).png"))); // NOI18N
        jButton1.setText("Volver al Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 200, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
       String nombre  = cbxProducto.getSelectedItem().toString();
        cargarimagen(nombre);
    }//GEN-LAST:event_cbxProductoActionPerformed

    public void cargarimagen(String nombre){
        ImageIcon imagen = new ImageIcon("src/img/" + nombre + ".jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
        Imagen.setIcon(icono);
        this.repaint();
    }
    
    
    private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed
        try {
            Connection cn = MySQLConexion.getConexion();

            String orden[] = new String[5];
            String sql = "SELECT * from articulos where art_nom='" + cbxProducto.getSelectedItem().toString() + "'";

            PreparedStatement st = cn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                orden[0] = rs.getString("art_cod");
                orden[1] = rs.getString("art_nom");
                orden[2] = Double.toString(rs.getDouble("art_pre"));
                orden[3] = txtCantidad.getText();
                orden[4] = String.valueOf(Double.parseDouble(orden[3]) * Double.parseDouble(orden[2]));
                modelo2.addRow(orden);
            }
            inve.cargarRegistroAlaTabla();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        }
        txtCantidad.setText("");
    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void btMostrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarInventarioActionPerformed

        inve.setVisible(true);
    }//GEN-LAST:event_btMostrarInventarioActionPerformed

    private void btProcesarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesarPedidoActionPerformed
        Connection cn = null;
        
        
        try{
            if (tbPedidos.getRowCount() > 0) {
                for (int i = 0; i < tbPedidos.getRowCount(); i++) {
                    cn = MySQLConexion.getConexion();
                    String sql = "UPDATE articulos set art_stk = art_stk + ? where art_cod = ?";
                    PreparedStatement st = cn.prepareStatement(sql);
                    
                    Object cant_art = tbPedidos.getValueAt(i, 3);
                    Object cod_art = tbPedidos.getValueAt(i, 0);
                    
                    st.setInt(1, Integer.parseInt(cant_art.toString()));
                    st.setInt(2, Integer.parseInt(cod_art.toString()));
                    st.executeUpdate();
                }
                for (int j = tbPedidos.getRowCount(); j > 0; j--) {
                    modelo2.removeRow(j-1);
                }
                
                JOptionPane.showMessageDialog(null, "Abastecimiento de productos completo");
                CargarProductosTabla();
                
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos añadidos");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cbxProovedor.setEnabled(true);
    }//GEN-LAST:event_btProcesarPedidoActionPerformed

    private void cbxProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProovedorActionPerformed
        llenarCombo();
        CargarProductosTabla();
        cbxProovedor.setEnabled(false);
    }//GEN-LAST:event_cbxProovedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vista menu = new Vista();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Abastecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Abastecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Abastecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Abastecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Abastecimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btMostrarInventario;
    private javax.swing.JButton btProcesarPedido;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JComboBox<String> cbxProovedor;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPedidos;
    public static javax.swing.JTable tbPrecios;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
