package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Sección 3
 * @author Natalia García
 */
public class Seccion3 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;

    public Seccion3(ControladorSolicitud controlador) {
        initComponents();
        this.setTitle("Sección 3");
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
        cmbCategoriaAsociada.setEnabled(false);
        setEnabledSection1(false);
        setEnabledSection2(false);
        setEnabledSection4(false);
        setEnabledHowToAcquire();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtIngresosLetras = new javax.swing.JTextField();
        txtIngresos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTerrenosDominio = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbAutorizacion = new javax.swing.JCheckBox();
        cmbTipoAprovechamientoD = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cmbCategoriaAsociada = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbTipoAprovechamientoA = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cmbClaseManejo = new javax.swing.JComboBox<>();
        lbA = new javax.swing.JCheckBox();
        lbB = new javax.swing.JCheckBox();
        lbC = new javax.swing.JCheckBox();
        lbD = new javax.swing.JCheckBox();
        btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("3. Descripción detallada de la solicitud");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Predios de propiedad privada o colectiva:");

        txtIngresosLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresosLetrasKeyTyped(evt);
            }
        });

        txtIngresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresosKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("$");

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setText("3.2 Objetos forestales objeto de la solicitud de aprovechamiento o manejo sostenible:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Terrenos de dominio público:");

        cmbTerrenosDominio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Permiso", "Asociación", "Concesión Forestal" }));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel26.setText("En caso de que se seleccione la clase de manejo sotenible persistente, indique la categoría asociada: ");
        jLabel26.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel13.setText("3.1. Modo de adquirir el derecho al uso del recurso: ");

        lbAutorizacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbAutorizacion.setText("Autorización");

        cmbTipoAprovechamientoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Tipo 1", "Tipo 2", "Cambio definitivo de uso de suelo", "Establecimiento y Manejo" }));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Seleccione la clase de aprovechamiento a solicitar: ");

        cmbCategoriaAsociada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Pequeños", "Medianos", "Grandes" }));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Seleccione el tipo de aprovechamiento a solicitar: ");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Valor en letras:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Ingresos mensuales en Salarios Minímos Legales Mensuales Vigentes - (SLMMV) esperados para la actividad comercial que se pretende desarrollar:");

        jLabel27.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel27.setText("Seleccione de acuerdo con el tipo de solicitud el modo por el cual pretende adquirir el derecho al uso del recurso forestal:");
        jLabel27.setToolTipText("");

        cmbTipoAprovechamientoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Persistente", "Único", "Doméstico", "Manejo Forestal Unificado" }));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Seleccione la clase de manejo sostenible a solicitar: ");

        cmbClaseManejo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Doméstico", "Persistente" }));
        cmbClaseManejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClaseManejoActionPerformed(evt);
            }
        });

        lbA.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbA.setText("A. Productos forestales maderables");
        lbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbAActionPerformed(evt);
            }
        });

        lbB.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbB.setText("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables");
        lbB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbBActionPerformed(evt);
            }
        });

        lbC.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbC.setText("C. Árboles Aislados ");
        lbC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbCActionPerformed(evt);
            }
        });

        lbD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbD.setText("D. Guaduales y bambusales");
        lbD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbDActionPerformed(evt);
            }
        });

        btnPrincipal.setText("Volver a la ventana principal");
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jLabel27)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(12, 12, 12)
                                .addComponent(cmbTerrenosDominio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbAutorizacion))
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbClaseManejo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17)
                                .addGap(12, 12, 12)
                                .addComponent(txtIngresosLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCategoriaAsociada, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(11, 11, 11)
                                .addComponent(cmbTipoAprovechamientoD, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipoAprovechamientoA, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(734, 734, 734))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)
                        .addGap(133, 133, 133))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addGap(9, 9, 9)
                .addComponent(jLabel27)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cmbTerrenosDominio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lbAutorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(9, 9, 9)
                .addComponent(lbA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbTipoAprovechamientoA, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lbB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbClaseManejo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtIngresosLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cmbCategoriaAsociada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(lbC)
                .addGap(14, 14, 14)
                .addComponent(lbD)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cmbTipoAprovechamientoD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnPrincipal))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setEnabledSection1(boolean state) {
        lbA.setSelected(state);
        cmbTipoAprovechamientoA.setEnabled(state);
    }

    private void setEnabledSection2(boolean state) {
        lbB.setSelected(state);
        cmbClaseManejo.setEnabled(state);
        txtIngresosLetras.setEnabled(state);
        txtIngresos.setEnabled(state);
    }

    private void setEnabledSection4(boolean state) {
        lbD.setSelected(state);
        cmbTipoAprovechamientoD.setEnabled(state);
    }

    private void mostrarSiguienteVentana() {
        this.setVisible(false);
        controlador.mostrarSeccion4_1();
    }

    private void setEnabledHowToAcquire() {
        switch (controlador.verTypeProperty()) {
            case "Público":
                lbAutorizacion.setEnabled(false);
                break;
            case "Colectivo":
                cmbTerrenosDominio.setEnabled(false);
                break;
            case "Privado":
                cmbTerrenosDominio.setEnabled(false);
                break;
        }
    }

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        String terrenosDominio = (controlador.verTypeProperty().equals("Público")) ? (String) cmbTerrenosDominio.getSelectedItem() : (lbAutorizacion.isSelected() ? "Autorización" : "Seleccione");
        String tipoAprovechamientoA = (String) cmbTipoAprovechamientoA.getSelectedItem();
        String claseManejo = (String) cmbClaseManejo.getSelectedItem();
        String ingresos = txtIngresos.getText().trim();
        String ingresosLetras = txtIngresosLetras.getText().trim();
        String categoriaAsociada = (String) cmbCategoriaAsociada.getSelectedItem();
        String tipoAprovechamientoD = (String) cmbTipoAprovechamientoD.getSelectedItem();
        LinkedList<String> categorias = new LinkedList<>();

        if (!terrenosDominio.equals("Seleccione")) {
            if (lbA.isSelected()) {
                categorias.add("A");
                if (!tipoAprovechamientoA.equals("Seleccione")) {
                    controlador.guardarInformacionSeccion3(terrenosDominio, categorias, tipoAprovechamientoA, claseManejo, ingresos,
                            ingresosLetras, categoriaAsociada, tipoAprovechamientoD);
                    mostrarSiguienteVentana();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                }
            }
            
            if (lbB.isSelected()) {
                categorias.add("B");
                if (!claseManejo.equals("Seleccione") && !ingresos.equals("") && !ingresosLetras.equals("")) {
                    if (cmbClaseManejo.getSelectedIndex() == 2) {
                        if (!categoriaAsociada.equals("Seleccione")) {
                            controlador.guardarInformacionSeccion3(terrenosDominio, categorias, tipoAprovechamientoA, claseManejo, ingresos,
                                    ingresosLetras, categoriaAsociada, tipoAprovechamientoD);
                            mostrarSiguienteVentana();
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                        }
                    } else {
                        controlador.guardarInformacionSeccion3(terrenosDominio, categorias, tipoAprovechamientoA, claseManejo, ingresos,
                                ingresosLetras, categoriaAsociada, tipoAprovechamientoD);
                        mostrarSiguienteVentana();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                }
            } 
            
            if (lbC.isSelected()) {
                categorias.add("C");
                controlador.guardarInformacionSeccion3(terrenosDominio, categorias, tipoAprovechamientoA, claseManejo, ingresos,
                        ingresosLetras, categoriaAsociada, tipoAprovechamientoD);
                mostrarSiguienteVentana();
            } 
            
            if (lbD.isSelected()) {
                categorias.add("C");
                if (!tipoAprovechamientoD.equals("Seleccione")) {
                    controlador.guardarInformacionSeccion3(terrenosDominio, categorias, tipoAprovechamientoA, claseManejo, ingresos,
                            ingresosLetras, categoriaAsociada, tipoAprovechamientoD);
                    mostrarSiguienteVentana();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
                }
            } 
            
            if(!lbA.isSelected() && !lbB.isSelected() && !lbC.isSelected() && !lbD.isSelected()){
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.setVisible(false);
        controlador.mostrarSeccion1();       
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void cmbClaseManejoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClaseManejoActionPerformed
        if (cmbClaseManejo.getSelectedIndex() == 2) {
            cmbCategoriaAsociada.setEnabled(true);
        } else {
            cmbCategoriaAsociada.setSelectedIndex(0);
            cmbCategoriaAsociada.setEnabled(false);
        }
    }//GEN-LAST:event_cmbClaseManejoActionPerformed

    private void txtIngresosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresosKeyTyped
        if (txtIngresos.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtIngresosKeyTyped

    private void txtIngresosLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresosLetrasKeyTyped
        if (txtIngresosLetras.getText().length() > 25) {
            evt.consume();
        } else {
            if (!Character.isAlphabetic(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtIngresosLetrasKeyTyped

    private void lbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbAActionPerformed
        if (lbA.isSelected()) {
            setEnabledSection1(true);
            lbC.setSelected(false);
            setEnabledSection4(false);
        } else {
            setEnabledSection1(false);
            lbC.setSelected(false);
            setEnabledSection4(false);
        }
    }//GEN-LAST:event_lbAActionPerformed

    private void lbBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbBActionPerformed
        if (lbB.isSelected()) {
            setEnabledSection2(true);
            lbC.setSelected(false);
            setEnabledSection4(false);
        } else {
            setEnabledSection2(false);
            lbC.setSelected(false);
            setEnabledSection4(false);
        }
    }//GEN-LAST:event_lbBActionPerformed

    private void lbCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbCActionPerformed
        if (lbC.isSelected()) {
            setEnabledSection1(false);
            setEnabledSection2(false);
            setEnabledSection4(false);
        } else {
            lbC.setSelected(false);
        }
    }//GEN-LAST:event_lbCActionPerformed

    private void lbDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbDActionPerformed
        if (lbD.isSelected()) {
            setEnabledSection1(false);
            setEnabledSection2(false);
            lbC.setSelected(false);
            setEnabledSection4(true);
        } else {
            setEnabledSection4(false);
        }
    }//GEN-LAST:event_lbDActionPerformed

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if(opcion == 0){
            this.setVisible(false);
            controlador.mostrarPrincipal();
        } 
    }//GEN-LAST:event_btnPrincipalMouseClicked

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        mostrarMenuPrincipal();
    }//GEN-LAST:event_btnPrincipalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbCategoriaAsociada;
    private javax.swing.JComboBox<String> cmbClaseManejo;
    private javax.swing.JComboBox<String> cmbTerrenosDominio;
    private javax.swing.JComboBox<String> cmbTipoAprovechamientoA;
    private javax.swing.JComboBox<String> cmbTipoAprovechamientoD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox lbA;
    private javax.swing.JCheckBox lbAutorizacion;
    private javax.swing.JCheckBox lbB;
    private javax.swing.JCheckBox lbC;
    private javax.swing.JCheckBox lbD;
    private javax.swing.JTextField txtIngresos;
    private javax.swing.JTextField txtIngresosLetras;
    // End of variables declaration//GEN-END:variables
}
