/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemafacturacionmuebles;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class TIPOMUEBLE extends javax.swing.JInternalFrame {

    /**
     * Creates new form TIPOMUEBLE
     */
    int a; //de activo
    CONEXION conect;
    
    public TIPOMUEBLE() {
        initComponents();
        conect = new CONEXION();
        conect.CONECTAR();
        limpiar();
        this.a=1;
        updateGrid("Select * from tipo WHERE activo='"+this.a+"';");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void limpiar(){
        this.txtIDTM.setText("");
        this.txtDescripcionTM.setText("");
        this.activoTM.setSelected(false);
    }
    private void updateGrid(String sql){
        conect.CONECTAR();
        try {
            
            //String[] titulos = {"CEDULA","NOMBRE","EDAD", "SEXO","TELEFONO","EMAIL", "ACTIVO"};
            
            DefaultTableModel modelo = (DefaultTableModel) this.tDatosTM.getModel();
            int f = this.tDatosTM.getRowCount();
            while(f>0){
                modelo.removeRow(0);
                f--;
            }
            ResultSet rs = conect.CONSULTAR(sql);
            String[] fila = new String[3];
            
            while(rs.next()){
                
                String activo= (String) rs.getString("activo");
                    fila[0] = (String) rs.getString("id_tipo");//Verificar
                    fila[1] = (String) rs.getString("descripcion"); 
                    fila[2] = activo.equals("1")?"ACTIVO":"INACTIVO";
                    modelo.addRow(fila);
            
            }
            this.tDatosTM.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        conect.CERRAR();
        }
    
    /**
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
        activoTM = new javax.swing.JCheckBox();
        txtIDTM = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionTM = new javax.swing.JTextArea();
        jSPTM = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDatosTM = new javax.swing.JTable();
        saveTM = new javax.swing.JButton();
        deleteTM = new javax.swing.JButton();
        newTM = new javax.swing.JButton();
        showTM = new javax.swing.JButton();

        setClosable(true);
        setTitle("CATALOGO TIPO DE MUEBLES");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Muebles");

        jLabel2.setText("ID Tipo:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Activo:");

        txtDescripcionTM.setColumns(20);
        txtDescripcionTM.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionTM);

        tDatosTM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID TIPO", "DESCRIPCION", "ACTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDatosTM.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tDatosTM.setColumnSelectionAllowed(true);
        tDatosTM.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tDatosTM);
        tDatosTM.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tDatosTM.getColumnModel().getColumnCount() > 0) {
            tDatosTM.getColumnModel().getColumn(0).setResizable(false);
            tDatosTM.getColumnModel().getColumn(0).setPreferredWidth(100);
            tDatosTM.getColumnModel().getColumn(1).setResizable(false);
            tDatosTM.getColumnModel().getColumn(1).setPreferredWidth(500);
            tDatosTM.getColumnModel().getColumn(2).setResizable(false);
            tDatosTM.getColumnModel().getColumn(2).setPreferredWidth(110);
        }

        jSPTM.setViewportView(jScrollPane2);

        saveTM.setText("Guardar");
        saveTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTMActionPerformed(evt);
            }
        });

        deleteTM.setText("Eliminar");
        deleteTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTMActionPerformed(evt);
            }
        });

        newTM.setText("Nuevo");
        newTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTMActionPerformed(evt);
            }
        });

        showTM.setText("Mostrar todos");
        showTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(activoTM)
                                            .addComponent(txtIDTM, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jSPTM, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newTM)
                                .addGap(18, 18, 18)
                                .addComponent(saveTM)
                                .addGap(18, 18, 18)
                                .addComponent(deleteTM)
                                .addGap(18, 18, 18)
                                .addComponent(showTM))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDTM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(activoTM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTM)
                    .addComponent(saveTM)
                    .addComponent(deleteTM)
                    .addComponent(showTM))
                .addGap(18, 18, 18)
                .addComponent(jSPTM, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTMActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        int activo = this.activoTM.isSelected()?1:0;
        
        if(this.tDatosTM.getSelectedRow()==-1){
            if(!txtIDTM.getText().equals("") && !this.txtDescripcionTM.getText().equals("")){
                conect.EJECUTAR("INSERT INTO tipo(id_tipo, descripcion, activo) VALUES('"+this.txtIDTM.getText()+"', '"+this.txtDescripcionTM.getText()+"', '"+activo+"');");
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Campos sin llenar!");
            }
        } else {
            if(this.txtIDTM.getText().equals("") || this.txtDescripcionTM.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Datos a modificar incompletos");
            } else{
                conect.CONECTAR();
                conect.EJECUTAR("UPDATE tipo SET descripcion='"+this.txtDescripcionTM.getText()+"', activo='"+activo+"' WHERE id_tipo='"+this.txtIDTM.getText()+"';");
                conect.CERRAR();
                this.limpiar();
                JOptionPane.showMessageDialog(null,"Datos modificados correctamente!");

            }
        }

        conect.CERRAR();
        updateGrid("Select * from tipo WHERE activo=1;");

    }//GEN-LAST:event_saveTMActionPerformed

    private void deleteTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTMActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        if(!this.txtIDTM.getText().equals("")){
            conect.EJECUTAR("DELETE FROM tipo WHERE id_tipo='"+this.txtIDTM.getText()+"';");
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null," Campo del codigo vacío!");
        }
        conect.EJECUTAR("");
        limpiar();
        conect.CERRAR();
        updateGrid("select * from id_tipo");
    }//GEN-LAST:event_deleteTMActionPerformed

    private void newTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTMActionPerformed
        // TODO add your handling code here:
        conect.CONECTAR();
        this.txtIDTM.setEditable(true);
        limpiar();
        conect.CERRAR();
    }//GEN-LAST:event_newTMActionPerformed

    private void showTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTMMouseClicked
        // TODO add your handling code here:
        if(this.a==1){
            this.a=0;
            updateGrid("Select * from tipo;");
            this.showTM.setText("Mostrar solo activos");
        } else if(this.a==0){
            this.a=1;
            updateGrid("Select * from tipo WHERE activo='"+this.a+"';");
            this.showTM.setText("Mostrar todos");
        
        }
    }//GEN-LAST:event_showTMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoTM;
    private javax.swing.JButton deleteTM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jSPTM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newTM;
    private javax.swing.JButton saveTM;
    private javax.swing.JButton showTM;
    private javax.swing.JTable tDatosTM;
    private javax.swing.JTextArea txtDescripcionTM;
    private javax.swing.JTextField txtIDTM;
    // End of variables declaration//GEN-END:variables
}
