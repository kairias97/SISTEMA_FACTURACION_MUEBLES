/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemafacturacionmuebles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kevin
 */
public class clientes extends javax.swing.JFrame {
    
    /**
     * Creates new form Ingreso_datos
     */
    CONEXION conect;
    int a; //de activo
    public clientes() {
       
        initComponents();
        conect = new CONEXION();
        conect.CONECTAR();
        limpiar();
        a=1;
        updateGrid("Select * from clientes WHERE activo='"+this.a+"';");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }
  
    public void updateGrid(String sql){
        conect.CONECTAR();
        try {
            
            //String[] titulos = {"CEDULA","NOMBRE","EDAD", "SEXO","TELEFONO","EMAIL", "ACTIVO"};
            
            DefaultTableModel modelo = (DefaultTableModel) this.tDatos.getModel();
            int f = this.tDatos.getRowCount();
            while(f>0){
                modelo.removeRow(0);
                f--;
            }
            ResultSet rs = conect.CONSULTAR(sql);
            String[] fila = new String[7];
            
            while(rs.next()){
                
                String sexo= (String) rs.getString("sexo");
                String activo= (String) rs.getString("activo");
                    fila[0] = (String) rs.getString("id_cliente");
                    fila[1] = (String) rs.getString("nombre");
                    fila[2] = (String) rs.getString("edad");  
                    fila[3] = sexo.equals("1")?"HOMBRE":"MUJER";
                    fila[4] = (String) rs.getString("telefono");
                    fila[5] = (String) rs.getString("email");  
                    fila[6] = activo.equals("1")?"ACTIVO":"INACTIVO";
                    modelo.addRow(fila);
            }
            this.tDatos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        conect.CERRAR();
        
    
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idcliente = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        newDC = new javax.swing.JButton();
        saveDC = new javax.swing.JButton();
        deleteDC = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        activo = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox();
        edad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cédula:");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Teléfono: ");

        jLabel4.setText("Email:");

        idcliente.setEditable(false);
        idcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idclienteActionPerformed(evt);
            }
        });

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        newDC.setText("Nuevo");
        newDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDCActionPerformed(evt);
            }
        });

        saveDC.setText("Guardar");
        saveDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDCActionPerformed(evt);
            }
        });

        deleteDC.setText("Eliminar");
        deleteDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDCActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ingreso de datos de clientes");

        jLabel6.setText("Activo:");

        jLabel7.setText("Edad:");

        jLabel8.setText("Sexo:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        edad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edadFocusLost(evt);
            }
        });

        tDatos.setAutoCreateRowSorter(true);
        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "EDAD", "SEXO", "TELEFONO", "EMAIL", "ACTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tDatos.getTableHeader().setReorderingAllowed(false);
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tDatos);
        if (tDatos.getColumnModel().getColumnCount() > 0) {
            tDatos.getColumnModel().getColumn(0).setResizable(false);
            tDatos.getColumnModel().getColumn(0).setPreferredWidth(140);
            tDatos.getColumnModel().getColumn(1).setResizable(false);
            tDatos.getColumnModel().getColumn(1).setPreferredWidth(250);
            tDatos.getColumnModel().getColumn(2).setResizable(false);
            tDatos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tDatos.getColumnModel().getColumn(3).setResizable(false);
            tDatos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tDatos.getColumnModel().getColumn(4).setResizable(false);
            tDatos.getColumnModel().getColumn(4).setPreferredWidth(90);
            tDatos.getColumnModel().getColumn(5).setResizable(false);
            tDatos.getColumnModel().getColumn(5).setPreferredWidth(200);
            tDatos.getColumnModel().getColumn(6).setResizable(false);
            tDatos.getColumnModel().getColumn(6).setPreferredWidth(110);
        }

        btnMostrar.setText("Mostrar todos");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(activo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                            .addComponent(nombre)
                                            .addComponent(telefono)
                                            .addComponent(email)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(33, 33, 33))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(edad)
                                                .addGap(181, 181, 181))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newDC)
                                .addGap(18, 18, 18)
                                .addComponent(saveDC)
                                .addGap(18, 18, 18)
                                .addComponent(deleteDC)
                                .addGap(30, 30, 30)
                                .addComponent(btnMostrar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(activo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDC)
                    .addComponent(saveDC)
                    .addComponent(deleteDC)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idclienteActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed
    public void limpiar(){
        this.idcliente.setText("");
        this.nombre.setText("");
        this.edad.setText("");
        this.sexo.setSelectedIndex(0);
        this.telefono.setText("");
        this.email.setText("");
        this.activo.setSelected(false);
    }
    
    private void newDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDCActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        this.idcliente.setEditable(true);
        limpiar();
        conect.CERRAR();
    }//GEN-LAST:event_newDCActionPerformed

    private void deleteDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDCActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        if(!idcliente.getText().equals("")){
            conect.EJECUTAR("DELETE FROM clientes WHERE id_cliente="+idcliente.getText());
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null," Campo del codigo vacío!");
        }
        conect.EJECUTAR("");
        limpiar();
        conect.CERRAR();
        updateGrid("select * from clientes WHERE activo='"+this.a+"'");
    }//GEN-LAST:event_deleteDCActionPerformed

    private void saveDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDCActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        int activo = this.activo.isSelected()?1:0;
        String sexo = this.sexo.getSelectedIndex()==0?"1":"0";
        if(this.tDatos.getSelectedRow()==-1){
            if(!nombre.getText().equals("") && !telefono.getText().equals("") && !email.getText().equals("")){
                conect.EJECUTAR("INSERT INTO clientes(id_cliente, nombre, telefono, email, activo, edad, sexo) VALUES('"+this.idcliente.getText()+"', '"+nombre.getText()+"', '"+telefono.getText()+"', '"+email.getText()+"', '"+activo+"', "+this.edad.getText()+", "+sexo+");");
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Campos sin llenar!");
            }
        } else {
            if(this.nombre.getText().equals("") || this.telefono.getText().equals("") || this.email.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Datos a modificar incompletos");
            } else{
                conect.CONECTAR();
                conect.EJECUTAR("UPDATE clientes SET nombre='"+this.nombre.getText()+"', telefono='"+this.telefono.getText()+"', email='"+this.email.getText()+"', activo='"+activo+"', edad="+edad.getText()+", sexo="+sexo+" WHERE id_cliente='"+this.idcliente.getText()+"';");
                conect.CERRAR();
                this.limpiar();
                JOptionPane.showMessageDialog(null,"Datos modificados correctamente!");
                
            }
        }
        
        conect.CERRAR();
        updateGrid("Select * from clientes WHERE activo='"+this.a+"';");
        
    }//GEN-LAST:event_saveDCActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        // TODO add your handling code here:
        int fila = this.tDatos.getSelectedRow();
        this.idcliente.setText((String) this.tDatos.getValueAt(fila, 0));
        this.nombre.setText((String) this.tDatos.getValueAt(fila, 1));
        this.edad.setText((String) this.tDatos.getValueAt(fila, 2));
        this.sexo.setSelectedIndex((String) this.tDatos.getValueAt(fila, 3)=="HOMBRE"?0:1);
        this.telefono.setText((String) this.tDatos.getValueAt(fila, 4));
        this.email.setText((String) this.tDatos.getValueAt(fila, 5));
        this.activo.setSelected((String) this.tDatos.getValueAt(fila, 6)=="ACTIVO"?true:false);
    }//GEN-LAST:event_tDatosMouseClicked

    private void edadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edadFocusLost
        // TODO add your handling code here:
        
        try{
            int edad = Integer.parseInt(this.edad.getText());
            if(edad < 18){
                JOptionPane.showMessageDialog(null, "Edad inválida. El cliente debe ser mayor de 18 años!");
                this.edad.setText("");
            }
        } catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null,"Edad inválida. Favor ingrese un número");
        }
    }//GEN-LAST:event_edadFocusLost

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
        // TODO add your handling code here:
        if(this.a==1){
            this.a=0;
            updateGrid("Select * from clientes;");
            this.btnMostrar.setText("Mostrar solo activos");
        } else if(this.a==0){
            this.a=1;
            updateGrid("Select * from clientes WHERE activo='"+this.a+"';");
            this.btnMostrar.setText("Mostrar todos");
        
        }
        
    }//GEN-LAST:event_btnMostrarMouseClicked

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
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activo;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton deleteDC;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idcliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newDC;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton saveDC;
    private javax.swing.JComboBox sexo;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}