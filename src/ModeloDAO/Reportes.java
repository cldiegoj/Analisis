package ModeloDAO;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Reportes {

    /* ********************************************************************
    * metodo para crear reportes de los clientes registrados en el sistema
    *********************************************************************** */
    public void ReportesClientes() {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("ReporteClientes.pdf"));
            Image header = Image.getInstance("src/img/SuperNova.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nSUPER - NOVA\n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Telefono");
            tabla.addCell("Correo");
            tabla.addCell("Dirección");

            try {
                Connection cn = MySQLConexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select cli_cod, cli_nom, cli_tel, cli_cor , cli_dir from CLIENTES");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }

    }

    /* ********************************************************************
    * metodo para crear reportes de los productos registrados en el sistema
    *********************************************************************** */
    public void ReportesProductos() {

        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Reporte_Productos.pdf"));
            Image header = Image.getInstance("src/img/SuperNova.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nSUPER - NOVA\n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 5, 4, 5, 7, 5};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Descripcion");
            tabla.addCell("Precio");
            tabla.addCell("Cantidad");
            tabla.addCell("Proveedor");

            try {
                Connection cn = MySQLConexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select art_cod, art_nom, art_des, art_pre, art_stk, p.pro_nom from articulos a inner join proveedor p where p.pro_cod=a.pro_cod order by art_cod;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* ********************************************************************
    * metodo para crear reportes de las ventas registrados en el sistema
    *********************************************************************** */
    public void ReportesVentas() {

        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Reporte_Facturas.pdf"));
            Image header = Image.getInstance("src/img/SuperNova.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nSUPER - NOVA\n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Facturas\n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {5, 5, 5};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Numero de factura");
            tabla.addCell("Fecha");
            tabla.addCell("Cliente");

            try {
                Connection cn = MySQLConexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select fac_num, fac_fec, c.cli_nom from fac_cabe f INNER JOIN clientes c where c.cli_cod=f.cli_cod");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    public void ReportesVentasDetalle(int num) {
        FacturaDAO facturadao = new FacturaDAO();
        String nombre = facturadao.ClientexId(num);
        double totalfila = 0;
        double totalfinal = 0;
        
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Reporte_Numero " + num + " de " + nombre + ".pdf"));
            Image header = Image.getInstance("src/img/SuperNova.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nSUPER - NOVA\n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Factura de " + nombre + "\n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 5, 2, 2};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Cantidad");
            tabla.addCell("Descripcion");
            tabla.addCell("P. Unit");
            tabla.addCell("Importe");

            

            try {
                Connection cn = MySQLConexion.getConexion();
                String sql = "select d.art_can, a.art_des, a.art_pre from fac_deta d INNER JOIN articulos a ON a.art_cod=d.art_cod INNER JOIN fac_cabe f ON f.fac_num=d.fac_num WHERE f.fac_num = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, num);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        totalfila = rs.getInt(1) * rs.getDouble(3);
                        totalfinal = totalfinal + totalfila;
                        String totalfi = Double.toString(totalfila);
                        tabla.addCell(totalfi);
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            String totalfinal2 = Double.toString(totalfinal);
            
            float[] columnas = {10, 2};
            PdfPTable tabla2 = new PdfPTable(columnas);
            tabla2.addCell("Total");
            tabla2.addCell(totalfinal2);
            documento.add(tabla2);
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

}
