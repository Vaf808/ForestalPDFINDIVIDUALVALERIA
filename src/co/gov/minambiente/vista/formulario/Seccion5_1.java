package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Sección 5.1
 * @author Natalia García
 */
public class Seccion5_1 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;
    
    public Seccion5_1(ControladorSolicitud controlador) {
        initComponents();
        this.setTitle("Sección 5.1");
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarMenuPrincipal();
            }
        });
    }
    
    public void mostrarMenuPrincipal(){
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if(opcion == 0){
            this.setVisible(false);
            controlador.mostrarPrincipal();
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSiguiente1 = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbMetodoA = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecies = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUso = new javax.swing.JTextArea();
        btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("    flora silvestre y los productos forestales no maderables");

        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguiente1MouseClicked(evt);
            }
        });
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel13.setText("       sostenible de flora silvestre y los productos forestales no maderables y método");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Indique el uso que se pretende dar a los productos a obtener:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("5. Información sobre el aprovechamiento forestal o manejo sostenible de la");

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setText("5.1. Información de las especies objeto de la solicitud de aprovechamiento forestal o manejo");

        cmbMetodoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Mecánico", "Manual", "Mecánico-Manual" }));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Método de aprovechamiento o manejo sostenible:");

        tblEspecies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), null, null, null, null, null, null, null, null},
                { new Short((short) 2), null, null, null, null, null, null, null, null},
                { new Short((short) 3), null, null, null, null, null, null, null, null},
                { new Short((short) 4), null, null, null, null, null, null, null, null},
                { new Short((short) 5), null, null, null, null, null, null, null, null},
                { new Short((short) 6), null, null, null, null, null, null, null, null},
                { new Short((short) 7), null, null, null, null, null, null, null, null},
                { new Short((short) 8), null, null, null, null, null, null, null, null},
                { new Short((short) 9), null, null, null, null, null, null, null, null},
                { new Short((short) 10), null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Cantidad", "Unidad de medida", "Nombre Común", "Nombre Científico", "Parte Aprovechada", "Hábito", "Veda", "Categoría de Amenaza"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEspecies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEspeciesMousePressed(evt);
            }
        });
        tblEspecies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblEspeciesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblEspecies);

        jLabel34.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel34.setText("Nota: Para los aprovechamientos forestales únicos la información sobre el volumen corresponde a la establecida por el inventario estadístico.");

        jLabel33.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel33.setText("*Unidad de medida: Metros cúbicos, toneladas, kilogramos, gramos, miligramos, entre otros.");
        jLabel33.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Especies objeto de la solicitud:");

        txtUso.setColumns(20);
        txtUso.setLineWrap(true);
        txtUso.setRows(5);
        txtUso.setWrapStyleWord(true);
        txtUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtUso);

        btnPrincipal.setText("Volver a la ventana principal");
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAnterior)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnPrincipal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSiguiente1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMetodoA, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(732, 732, 732))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13))
                    .addComponent(jLabel20))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbMetodoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente1)
                    .addComponent(btnPrincipal))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguiente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguiente1MouseClicked
        ArrayList<ArrayList<String>> datosTabla = new ArrayList<>();

        for (int row = 0; row < tblEspecies.getRowCount(); row++) {
            if (tblEspecies.getValueAt(row, 1) != null && tblEspecies.getValueAt(row, 2) != null && tblEspecies.getValueAt(row, 3) != null
                    && tblEspecies.getValueAt(row, 4) != null && tblEspecies.getValueAt(row, 5) != null
                    && tblEspecies.getValueAt(row, 6) != null && tblEspecies.getValueAt(row, 7) != null
                    && tblEspecies.getValueAt(row, 8) != null) {
                System.out.println("Adentro");
                ArrayList<String> array = new ArrayList<>();
                array.add(String.valueOf(tblEspecies.getValueAt(row, 1)));
                array.add((String) tblEspecies.getValueAt(row, 2));
                array.add((String) tblEspecies.getValueAt(row, 3));
                array.add((String) tblEspecies.getValueAt(row, 4));
                array.add((String) tblEspecies.getValueAt(row, 5));
                array.add((String) tblEspecies.getValueAt(row, 6));
                array.add((String) tblEspecies.getValueAt(row, 7));
                array.add((String) tblEspecies.getValueAt(row, 8));
                datosTabla.add(array);
            }
        }

        System.out.println(datosTabla);
        for (ArrayList<String> fila : datosTabla) {
            for (String s : fila) {
                System.out.println(s);
            }
        }

        String metodo = (String) cmbMetodoA.getSelectedItem();
        String uso = txtUso.getText().trim();

        if (!metodo.equals("Seleccione") && !uso.equals("")) {
            controlador.guardarInformacionSeccion5_1(metodo, datosTabla, uso);
            this.setVisible(false);
            if (controlador.esCategoriaC()) {
                controlador.mostrarSeccion5_2();
            } else {
                controlador.mostrarSeccion6();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
        }
    }//GEN-LAST:event_btnSiguiente1MouseClicked

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed

    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        this.setVisible(false);
        controlador.mostrarSeccion4_2();
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void txtUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoKeyTyped
        if (txtUso.getText().length() >= 150) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsoKeyTyped

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed

    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void tblEspeciesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEspeciesKeyTyped

    }//GEN-LAST:event_tblEspeciesKeyTyped

    private void tblEspeciesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspeciesMousePressed

    }//GEN-LAST:event_tblEspeciesMousePressed

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        mostrarMenuPrincipal();
    }//GEN-LAST:event_btnPrincipalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrincipal;
    public javax.swing.JButton btnSiguiente1;
    public javax.swing.JComboBox<String> cmbMetodoA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblEspecies;
    public javax.swing.JTextArea txtUso;
    // End of variables declaration//GEN-END:variables
}
