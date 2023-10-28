

package IGU;


import Clases.Proveedores;
import static IGU.FacturaIGU.txtIGV;
import static IGU.FacturaIGU.txtSubtotal;
import static IGU.FacturaIGU.txtTotal;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Abastecimiento extends javax.swing.JFrame {

    DefaultTableModel modelo2=new DefaultTableModel();
    InventarioIGU inve=new InventarioIGU();
    private ImageIcon imagen;
    private Icon icono;
    
    public Abastecimiento() {
        initComponents();
        this.setLocationRelativeTo(null);  
        tbPedidos.setModel(modelo2);
        String[] cabecera={"Codigo Producto","Nombre Producto","Precio Unitario","Cantidad","Subtotal"};
        modelo2.setColumnIdentifiers(cabecera);   
        llenarCombo();
        llenarComboProveedor();
    }
    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
     private  void pintarImagen(JLabel lbl, String ruta){
        this.imagen= new ImageIcon(ruta);
        this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(),Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
}
     public void sumar(int cantidad,String nombre){
         try{
        String xurl="jdbc:mysql://localhost/bdcasahogar";
        String xusu="root";
        String xpas="";
        
        Connection conex= DriverManager.getConnection(xurl,xusu,xpas);
     
        Statement declarar=conex.createStatement();
    
        String xsql="UPDATE inventario SET stock_prod=stock_prod+"+cantidad+" WHERE nom_prod='"+nombre+"'";
        declarar.execute(xsql);
        }catch(SQLException ex){
            System.out.println("Error...Falla en la conexion");
        }
     }
 public void llenarCombo(){
          try {
         
        String xurl="jdbc:mysql://localhost/bdcasahogar";
        String xusu="root";
        String xpas="";
        
        Connection conex= DriverManager.getConnection(xurl,xusu,xpas);
     
        Statement declarar=conex.createStatement();
       
        String xsql="SELECT nom_prod from inventario";
        ResultSet rs=declarar.executeQuery(xsql);
        while(rs.next()){  
            
        cbxProducto.addItem(rs.getString("nom_prod"));        
        }

        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        }
     }
 public void llenarComboProveedor(){
          try {
          
        String xurl="jdbc:mysql://localhost/bdcasahogar";
        String xusu="root";
        String xpas="";
        
        Connection conex= DriverManager.getConnection(xurl,xusu,xpas);
        Statement declarar=conex.createStatement();
        String xsql="SELECT cod_prov,nom_prov from proveedores";
        ResultSet rs=declarar.executeQuery(xsql);
        while(rs.next()){            
        cbxProovedor.addItem(rs.getString("cod_prov")+" - "+rs.getString("nom_prov"));        
        }

        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
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
        jLabel3 = new javax.swing.JLabel();
        cbxProovedor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPrecios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
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
        getContentPane().add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 260, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

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

        lbImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 180, 150));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cbxProovedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cbxProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProovedorActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 260, 40));

        tbPrecios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPrecios.setForeground(new java.awt.Color(51, 51, 51));
        tbPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cama 2 plazas", null},
                {"Ropero", null},
                {"Sillas", null},
                {"Escritorio", null},
                {"Comoda", null},
                {"Tocador", null},
                {"Sofa", null},
                {"Velador", null},
                {"Zapatero", null}
            },
            new String [] {
                "Producto", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tbPrecios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 280, 340));

        jButton1.setBackground(new java.awt.Color(187, 122, 66));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver (1).png"))); // NOI18N
        jButton1.setText("Volver al Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 200, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Almacen_End.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1020, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
     
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed

        switch(cbxProducto.getSelectedIndex()){
            case 0:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\");break;
            case 1:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\cama2.jpg");break;
            case 2:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\ropero.jpg");break;
            case 3:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\silla.jpg");break;
            case 4:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\escritorio.jpg");break;
            case 5:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\comoda_1.png");break;
            case 6:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\tocador.jpg");break;
            case 7:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\sofa.jpg");break;
            case 8:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\velador.jpg");break;
            case 9:pintarImagen(lbImagen, "C:\\Users\\Jordan Davila\\Documents\\NetBeansProjects\\Proyecto_Avance3\\src\\Imagenes\\zapatero.jpg");break;
       }
       
    }//GEN-LAST:event_cbxProductoActionPerformed

    private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed
         try {
          
        String xurl="jdbc:mysql://localhost/bdcasahogar";
        String xusu="root";
        String xpas="";
        String orden[]=new String[5];
        Connection conex= DriverManager.getConnection(xurl,xusu,xpas);
       
        Statement declarar=conex.createStatement();
        
        String xsql="SELECT * from inventario where nom_prod='"+cbxProducto.getSelectedItem().toString()+"'";
        ResultSet rs=declarar.executeQuery(xsql);        
        while(rs.next()){
        orden[0]=rs.getString("cod_prod");
        orden[1]=rs.getString("nom_prod");
            switch (orden[1]) {
                case "Cama 2 plazas":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(0, 1));break;
                case "Ropero":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(1, 1));break;
                case "Sillas":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(2, 1));break;
                case "Escritorio":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(3, 1));break;
                case "Comoda":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(4, 1));break;
                case "Tocador":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(5, 1));break;
                case "Sofa":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(6, 1));break;
                case "Velador":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(7, 1));break;
                case "Zapatero":
                    orden[2]=String.valueOf(tbPrecios.getValueAt(8, 1));break;
                default:
                    throw new AssertionError();
            }
        
        orden[3]=txtCantidad.getText();
        orden[4]=String.valueOf(Double.parseDouble(orden[3])*Double.parseDouble(orden[2]));
        modelo2.addRow(orden);      
        }
        sumar(Integer.parseInt(orden[3]), orden[1]);
        inve.cargarRegistroAlaTabla();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        }
        
    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void btMostrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarInventarioActionPerformed

      inve.setVisible(true);
    }//GEN-LAST:event_btMostrarInventarioActionPerformed

    private void btProcesarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesarPedidoActionPerformed
        if(cbxProovedor.getSelectedIndex()>0 && Integer.parseInt(txtCantidad.getText())>0){
      try {
        
        String xurl="jdbc:mysql://localhost/bdcasahogar";
        String xusu="root";
        String xpas="";
        
        
        Connection conex= DriverManager.getConnection(xurl,xusu,xpas);
        Statement declarar=conex.createStatement();      
        String codigo=cbxProovedor.getSelectedItem().toString().substring(0, 4);
        int cantidad=0;
        double total=0;

        

        Proveedores prov=new Proveedores(codigo, cbxProovedor.getSelectedItem().toString().substring(7, cbxProovedor.getSelectedItem().toString().length()),cantidad , total);
        for(int i=0;i<tbPedidos.getRowCount();i++){
            cantidad=cantidad+Integer.parseInt(tbPedidos.getValueAt(i, 3).toString());
            total=total+Double.parseDouble(tbPedidos.getValueAt(i, 4).toString());
            
        }
        prov.setCantidad(cantidad);
        prov.setTotal(total);

        String xsql2="INSERT INTO registroproveedores values('"+prov.getCodigo()+"','"+prov.getNombreP()
                +"','"+String.valueOf(prov.getCantidad())+"','"+prov.getTotal()+"')";
        declarar.execute(xsql2);
            JOptionPane.showMessageDialog(null, "El proveedor fue registrado");
            Vista menu=new Vista();
            menu.setVisible(true);
            this.dispose();
        
        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
      
        }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un proveedor valido");
        }
    }//GEN-LAST:event_btProcesarPedidoActionPerformed

    private void cbxProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProovedorActionPerformed
      switch(cbxProovedor.getSelectedIndex()){
          case 1: 
              tbPrecios.setValueAt(200, 0, 1);
              tbPrecios.setValueAt(100, 1, 1);
              tbPrecios.setValueAt(10, 2, 1);
              tbPrecios.setValueAt(150, 3, 1);
              tbPrecios.setValueAt(120, 4, 1);
              tbPrecios.setValueAt(80, 5, 1);
              tbPrecios.setValueAt(50, 6, 1);
              tbPrecios.setValueAt(70, 7, 1);
              tbPrecios.setValueAt(30, 8, 1);break;
          case 2: 
              tbPrecios.setValueAt(250, 0, 1);
              tbPrecios.setValueAt(130, 1, 1);
              tbPrecios.setValueAt(25, 2, 1);
              tbPrecios.setValueAt(165, 3, 1);
              tbPrecios.setValueAt(125, 4, 1);
              tbPrecios.setValueAt(90, 5, 1);
              tbPrecios.setValueAt(60, 6, 1);
              tbPrecios.setValueAt(75, 7, 1);
              tbPrecios.setValueAt(45, 8, 1);break;
         case 3: 
              tbPrecios.setValueAt(260, 0, 1);
              tbPrecios.setValueAt(120, 1, 1);
              tbPrecios.setValueAt(30, 2, 1);
              tbPrecios.setValueAt(130, 3, 1);
              tbPrecios.setValueAt(100, 4, 1);
              tbPrecios.setValueAt(50, 5, 1);
              tbPrecios.setValueAt(80, 6, 1);
              tbPrecios.setValueAt(60, 7, 1);
              tbPrecios.setValueAt(30, 8, 1);break;
      }
      cbxProovedor.setEnabled(false);
    }//GEN-LAST:event_cbxProovedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vista menu=new Vista();
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
    private javax.swing.JLabel lbImagen;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTable tbPrecios;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
